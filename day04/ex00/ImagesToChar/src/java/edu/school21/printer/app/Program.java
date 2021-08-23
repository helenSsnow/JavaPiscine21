package edu.school21.printer.app;


import edu.school21.printer.logic.Convert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        char black;
        char white;
        String path;

        if(args.length != 3){
            System.err.println("Incorrect args");
            return;
        }
        black = getString(0, args, "--white=").charAt(0);
        white = getString(1, args, "--black=").charAt(0);
        path = getString(2, args, "--filePath=");
        path = path.replace('\\', '/');
        File file = new File(path);
        if(!file.exists()){
            System.err.println("Incorrect file path");
            return;
        }

        BufferedImage image = ImageIO.read(file);
        if(image == null){
             System.err.println("File can not be read");
            return;
        }
        Convert convert = new Convert(image, white, black);
        convert.ConvertImage();
        convert.PrintImage();
    }

    public static String getString(int arg, String[] args, String check) {
        String subArg = args[arg].substring(0, args[arg].lastIndexOf("=") + 1);
        if(subArg.equals(check)) {
            String str = args[arg].substring(args[arg].lastIndexOf("=") + 1);
            return str;
        }
        return null;
    }
}



