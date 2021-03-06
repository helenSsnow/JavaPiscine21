import java.util.Scanner;

public class Program {
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
            System.exit(-1);
        }
        else if(num % 2 == 0 && num != 2 && num != 3)
            return false;
        else{
            while(count_symple * count_symple < num){
                count_symple++;
                res++;
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
            int num = -1;
            if(scan.hasNextInt())
                num = scan.nextInt();
            if(num == 42)
                break ;
            num = count_sum(num);
            if(isSymple(num) == true){
                sum_coffees++;
            }
        }
        if(sum_coffees > 0)
            System.out.println("Count of coffee-request - " + sum_coffees);
        else
            System.out.println("Count of coffee-request - 0");
        scan.close();
    }
}