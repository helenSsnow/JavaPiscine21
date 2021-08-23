package folder2;

import java.io.*;
import java.util.Scanner;

public class Program {
    static String path;
    static File mainPath;
    public static void main(String[] args) {
        if(args.length !=1)
            System.err.println("Incorrect sum args");
        String arg = args[0];

        String subArg = arg.substring(0, arg.lastIndexOf("=") + 1);
        path = arg.substring(arg.lastIndexOf("=") + 1);
        if(arg.lastIndexOf("=") == -1 || subArg.equals("--current-folder=") == false
                ||path.equals("")){
            System.err.println("Incorrect args");
        }
        else {
            getMainPath();
        }
    }

    public static void getMainPath() {
        String command;
        Scanner scan = new Scanner(System.in);
        mainPath = new File(path);
        if(!mainPath.exists() || !mainPath.isDirectory()) {
            System.err.println("Incorrect path to folder");
            return ;
        }else {
            System.out.println(mainPath.getAbsolutePath());
            while(scan.hasNext() == true) {
                command = scan.next();
                if(command.equals("ls")) {
                    commandLs("");
                }
                else if(command.equals("mv")) {
                    String from = scan.next();
                    String to = scan.next();
                    commandMv(from, to);
                }
                else if(command.equals("cd")) {
                    String subpath = scan.next();
                    commandCd(subpath);

                }
                else if(command.equals("exit")){
                    return;
                }
                else {
                    System.err.println("Incorrect command");
                }
            }
        }
    }
    public static void commandCd(String subpath) {
        String newMainPath = mainPath.getAbsolutePath()+ "\\" + subpath;
        File path = new File(newMainPath);
        if(!path.exists() || !path.isDirectory()) {
            System.err.println("folder does not exist");
        }
        else {
            mainPath = path;
        }
    }
    public static void commandMv(String from, String to) {

        String oldPath = mainPath.getAbsolutePath()+ "\\" + from;
        File toIsPath = new File(mainPath.getAbsolutePath() + "\\" + to);
        if(toIsPath.exists() && toIsPath.isDirectory() && to.startsWith("../")) {
            String path = mainPath.getAbsolutePath();
            path = changeDir(path, to) + "\\" + from;
            final File myFile = new File(oldPath);
            if(myFile.exists() && myFile.renameTo(new File(path))) {
            }
            else {
                System.err.println("file does not exist");
                return;
            }
        }
        else if (toIsPath.exists() && commandLs(from) == true) {

            String absPathMain = mainPath.getAbsolutePath();
            String absPathFile = mainPath.getAbsolutePath() + "\\" + from;

            File oldFile = new File(absPathFile);
            String newFilename = absPathFile.replace(from, to);
            File newFile = new File(newFilename);
            boolean renamed = oldFile.renameTo(newFile);
            if(renamed == false) {
                System.err.println( "rename was failed");
                return;
            }
        }
        else {
            System.err.println("path does not exist");
            return;
        }
    }

    private static String changeDir(String dirLocation, String newPath) {
        while (true) {

            if (newPath.equals(".."))
                return prevLevel(dirLocation);
            if (!newPath.startsWith("../")) {
                return dirLocation + "\\" + newPath;
            }
            dirLocation = prevLevel(dirLocation);
            newPath = deletePath(newPath);
            changeDir(dirLocation, newPath);

        }
    }

    private static String deletePath(String toWhere) {
        int i = toWhere.indexOf('/');
        return toWhere.substring(i + 1);
    }

    private static String prevLevel(String dirLocation) {
        int i = dirLocation.lastIndexOf('\\');
        return dirLocation.substring(0, i);
    }


    public static boolean commandLs(String from) {
        boolean res = false;
        File[] children = mainPath.listFiles();
        for (File file : children) {
            if(!from.equals("") && file.getName().equals(from)){
                res = true;
            }
            if(from.equals("") == true) {
                String name = file.getName();
                long length = folderSize(file);
                System.out.println(name + " " + (length / 1024) + "KB");
            }
        }
        return res;
    }

    public static long folderSize(File directory) {
        long length = 0;
        if(directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile())
                    length += file.length();
                else
                    length += folderSize(file);
            }
        }
        else {
            length += directory.length();
        }
        return length;
    }
}
