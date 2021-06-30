import java.util.Scanner;

public class Program {

    static void error(){
        System.err.println("IllegalArgument");
        System.exit(-1);
    }

    static int searchMin(int aval, int min){
        if(aval < min)
            min = aval;
        return min;
    }

    static int getAvaluation(Scanner scan){
        int min = -1;
        for(int i = 0; i < 5; i++)
        {
            int Aval = -1;
            if(scan.hasNextInt())
                Aval =  scan.nextInt();
            else
                error();
            if(Aval > 9 || Aval < 1)
                error();
            if(min == -1)
                min = Aval;
            min = searchMin(Aval, min);
        }
        return min;
    }

    static long reverseReport(long report){
        long newReport = 0;
        while(report > 0){
            newReport = (newReport * 10) + (report % 10);
            report /= 10;
        }
        return newReport;
    }

    static void printReport(long report){
        int i = 1;
        while(report > 0){
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");
            long sumPrint = report % 10;
            report = report / 10;
            while(sumPrint > 0){
                System.out.print("=");
                sumPrint--;
            }
            System.out.println(">");
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int weekSum = 18;
        long report = 0;
        int tmp = 1;
        String weekName;
        int weekN = 0;
        String checkName = "Week";
        while (scan.hasNext()) {
            weekName = scan.next();
            if (weekName.equals("42") == true)
                break ;
            if (weekName.equals(checkName) == false)
                error();
            if(scan.hasNextInt()){
                weekN = scan.nextInt();
            } else
                error();
            if(weekN != tmp || tmp++ > weekSum) {
                error();
            }
            int min = getAvaluation(scan);
            report = report * 10 + min;
        }
        report = reverseReport(report);
        printReport(report);
    }
}