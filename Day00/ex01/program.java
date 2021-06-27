package ex01;
import java.util.Scanner;

public class program {

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    int count_symple = 2;
    int res = 1;
    if(num <= 1){
      System.err.println("IllegalArgument");
    }
    else if(num % 2 == 0)
       System.out.println("false 1");
    else{
        while(count_symple * count_symple < num){
            count_symple++;
            res++;
//           System.out.println("res " + res + " count_symple * count_symple = " + count_symple * count_symple);
          }
          if(count_symple * count_symple == num){
            System.out.println("false " + res);
          }
          else{
             System.out.println("true " + res); 
          }
    }
    
        
    }

}
