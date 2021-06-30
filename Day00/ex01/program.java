import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = -1;
        if(scan.hasNextInt())
            num = scan.nextInt();
        int count_symple = 2;
        int res = 1;
        if(num <= 1){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        else if(num % 2 == 0 && num != 2)
            System.out.println("false 1");
        else{
            while(count_symple * count_symple < num){
                count_symple++;
                res++;
            }
            if(count_symple * count_symple == num){
                System.out.println("false " + res);
            }
            else{
                System.out.println("true " + res);
            }
        }
        scan.close();
    }
}
