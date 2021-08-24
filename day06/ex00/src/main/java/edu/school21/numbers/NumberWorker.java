package edu.school21.numbers;

public class NumberWorker {
    public static boolean isPrime(int number) {
        int count_simple = 2;
        if(number <= 1){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        else if(number % 2 == 0 && number != 2) {
            return false;
        }
        else {
            while (count_simple * count_simple <= number) {
                if (number % count_simple == 0) {
                    return false;
                }
                count_simple++;
            }
        }
        return true;
    }
    public static int digitsSum(int number) {
        int res = 0;

        while(number != 0){
            res += number % 10;
            number = number / 10;
        }
        return res;
    }

}
