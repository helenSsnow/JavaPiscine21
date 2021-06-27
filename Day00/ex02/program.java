package ex02;
import java.util.Scanner;

public class program {
    static int count_sum(int num){
       int res = 0;
       while(num > 0){
            res += num % 10;
            num = num / 10;
       }
        return(res);
    }
    static boolean isSymple(int num){
        int count_symple = 2;
        int res = 1;
        if(num <= 1){
          System.err.println("IllegalArgument");
        }
        else if(num % 2 == 0)
           return false;
        else{
            while(count_symple * count_symple < num){
                count_symple++;
                res++;
//               System.out.println("res " + res + " count_symple * count_symple = " + count_symple * count_symple);
              }
              if(count_symple * count_symple == num){
                return false;
              }
              else{
                 return true; 
              }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum_coffees = 0;
        while(scan.hasNext()){
            int num = scan.nextInt();
           if(num == 42)
                break ;
            num = count_sum(num);
//            System.out.println("num = " + num);
            if(isSymple(num) == true){
                sum_coffees++;
//                System.out.println("sum =  " + sum_coffees);
            }
        }
        if(sum_coffees > 0)
                System.out.println("Count of coffee-request - " + sum_coffees);
        else
             System.out.println("Count of coffee-request - 0");
    }
}
