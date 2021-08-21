import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class Program {

    static TreeSet<String> allWords;
    static Vector<String> first = new Vector<>();
    static Vector<String> second = new Vector<>();
    static Vector<Integer> firstInt = new Vector<>();
    static Vector<Integer> secondInt = new Vector<>();;

    public static TreeSet<String> getAllWords(String firstRaw, String secondRaw){
        String[] words = {firstRaw, secondRaw};
        TreeSet<String> allWords = new TreeSet<>();

        for(int i = 0; i < words.length; i++) {
            int j = 0;
            while(j < words[i].length()) {
                int finishWord = words[i].indexOf(" ");

                if(finishWord != -1){
                    String substr = words[i].substring(0, finishWord);
                    if(i == 0) {
                        first.add(substr);
                    }
                    else {
                        second.add(substr);
                    }
                    allWords.add(substr);
                    words[i] = words[i].substring(finishWord + 1, words[i].length());
                }
                else {
                    String substr = words[i].substring(0, words[i].length());
                    if(i == 0) {
                        first.add(substr);
                    }
                    else {
                        second.add(substr);
                    }
                    allWords.add(substr);
                    words[i] = "";
                }
            }
        }
        return allWords;
    }

    public static void getIntVector() {
        int count = 0;
        Vector<String> [] raws = new Vector[]{first, second};
        for (int j = 0; j < raws.length; j++) {
            Iterator<String> iterator = allWords.iterator();
            for(int i = 0; i < allWords.size(); i++){

                String str = iterator.next();
                for(int k = 0; k < raws[j].size(); k++) {
                    if(raws[j].get(k).equals(str) == true) {
                        count++;
                    }
                }
                if(j == 0) {
                    firstInt.add(count);
                }
                else {
                    secondInt.add(count);
                }
                count = 0;
            }
        }
    }

    private static double getSimilarity() {

        int len = allWords.size();

        int numerator = 0;

        for (int i = 0; i < len; i++) {
            numerator += firstInt.get(i) * secondInt.get(i);
        }

        int valueFirst = 0;

        int valueSecond = 0;

        for (int i = 0; i < len; i++) {
            valueFirst += firstInt.get(i) * firstInt.get(i);
            valueSecond += secondInt.get(i) * secondInt.get(i);
        }
        return (numerator / (Math.sqrt(valueFirst) * Math.sqrt(valueSecond)));
    }

    public static String getArgsInclude(String arg) throws FileNotFoundException {
        File file = new File(arg);

        if (!file.isFile() && !file.canRead()) {
            System.err.println("File is not correct");
            return null;
        }

        Scanner scan = new Scanner(file);
        String newArg = scan.nextLine();
        scan.close();
        return newArg;
    }

    public static void main(String[] args) throws FileNotFoundException {

        if(args.length != 2) {
            System.err.println("Incorrect args");
        }
        else{
            String firstArg = args[0];
            String secondArg= args[1];
            firstArg = getArgsInclude(firstArg);
            secondArg = getArgsInclude(secondArg);

            if(firstArg != null || secondArg != null){
                allWords = getAllWords(firstArg, secondArg);
                getIntVector();
                System.out.println("Similarity = " + (long) (getSimilarity() * 1e2) / 1e2);
            }else{
                System.err.println("Incorrect files");
            }
        }



    }
}
