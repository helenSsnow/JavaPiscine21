/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex03;
import java.util.Scanner;

/**
 *
 * @author Lena
 */
public class program {

    
    static void error(){
        System.err.println("IllegalArgument");
        System.exit(-1);
    }

    static int searchMin(int firstAv, int secondAv, int firdAv, int fourthtAv, int fifthAv){
        int min = firstAv;
        if(secondAv < min)
            min = secondAv;
        else if(firdAv < min)
            min = firdAv;
        else if(fourthtAv < min)
            min = fourthtAv;
        else if(fifthAv < min) 
            min = fifthAv;
        return min;
    }

    static int getAvulation(Scanner scan){
        int firstAv = scan.nextInt();
        int secondAv = scan.nextInt();
        int firdAv = scan.nextInt();
        int fourthtAv = scan.nextInt();
        int fifthAv = scan.nextInt();
        if(firstAv > 9 || secondAv > 9 || firdAv > 9 || fourthtAv > 9 || fifthAv > 9 ||
           firstAv < 1 || secondAv < 1 || firdAv < 1 || fourthtAv < 1 || fifthAv < 1)
           error();
        int min = searchMin(firstAv, secondAv, firdAv, fourthtAv, fifthAv);
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
            System.out.println("Week " + i + " ");
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
        String weekN;
        while(scan.hasNext()){
            weekName = scan.next();
            if(weekName.equals("42") == true)
                break ;
            weekN = scan.next();
            String checkName = "Week";
                if(weekName.equals(checkName) == false || weekN.equals(String.valueOf(tmp)) == false || tmp++ > 18)
                    error();
            int min = getAvulation(scan);
            report = report * 10 + min;
        }
        report = reverseReport(report);
        printReport(report);

    }

}
