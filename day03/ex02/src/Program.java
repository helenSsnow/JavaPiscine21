import java.util.ArrayList;
import java.util.Random;

class Threads extends Thread {

    private int threadNum;
    private int startNum;
    private int finishNum;


    Threads(int threadNum,  int startNum, int finishNum) {
        this.finishNum = finishNum;
        this.startNum = startNum;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        int sum = 0;

        for (int i = startNum; i < finishNum; i++) {
            sum += Program.getArray()[i];
        }
        System.out.println("Thread " + threadNum + ": from " + startNum + " to " + finishNum + " sum is " + sum);

        synchronized (this) {
            Program.sumThreads += sum;
        }
    }

}

public class Program {
    private static int[] array;
    public static int sumThreads = 0;
    public static void main(String[] args) throws InterruptedException {

        if(args.length != 2){
            System.err.println("Incorrect sum args");
        }
        String subArg1 = args[0].substring(0, args[0].lastIndexOf("=") + 1);
        int arraySize = Integer.parseInt(args[0].substring(args[0].lastIndexOf("=") + 1));

        String subArg2 = args[1].substring(0, args[1].lastIndexOf("=") + 1);
        int threadCount = Integer.parseInt(args[1].substring(args[1].lastIndexOf("=") + 1));
        if (args[0].lastIndexOf("=") == -1 || subArg1.equals("--arraySize=") == false || arraySize < 0 ||
                args[1].lastIndexOf("=") == -1 || subArg2.equals("--threadsCount=") == false || threadCount < 0
        ) {
            System.err.println("Incorrect args");
        } else {
            makeArr(arraySize);
            printAllSum(arraySize);
            makeThread(threadCount,arraySize);
            System.out.println("Sum by threads: " + sumThreads);
        }

    }

    public static void makeThread(int threadCount, int arraySize) throws InterruptedException {
        int threadNum = 0;
        int startNum = 0;
        int finishNum = 0;
        ArrayList<Threads> listThreads = new ArrayList<>();
        for(int i = 0; i <  threadCount; i++) {
            threadNum = i + 1;
            if(i == 0) {
                startNum = 0;
            }
            else {
                startNum = finishNum;
            }
            finishNum = startNum + (arraySize / threadCount) + 1;
            if(finishNum > arraySize)
                finishNum = arraySize;

            Threads thread = new Threads(threadNum, startNum, finishNum);
            thread.start();
            listThreads.add(thread);
        }

        for (int i = 0; i < threadCount; i++) {
            listThreads.get(i).join();
        }
    }

    public static void printAllSum(int arraySize) {
        int sum = 0;
        for (int i = 0; i < arraySize; i++) {
            sum += array[i];
        }
        System.out.println("Sum: " + sum);
    }

    private static void makeArr(int arraySize) {
        int min = 0, max = 1000;
        array = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            array[i] = (int)(Math.random() * (max));
        }
    }

    public static int[] getArray() {
        return array;
    }
}

