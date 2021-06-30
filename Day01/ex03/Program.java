import java.util.UUID;

public class Program {
    public static void main(String[] args) throws TransactionNotFoundException, InccorectAmountException {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";


        User alex = new User("Alex", 4000);
        User maria = new User("Maria", 1000);

        System.out.println(ANSI_BLUE + "*** SUM BEFORE TRANSACTION ***" + ANSI_RESET);
        alex.printUserData();
        maria.printUserData();


        System.out.println(ANSI_BLUE + "*** SUM AFTER TRANSACTION (-800)***" + ANSI_RESET);
        Transaction tr1 = new Transaction(alex, maria, "credit", -800);

        alex.printUserData();
        maria.printUserData();
        alex.printTransactionsList();
        maria.printTransactionsList();

        try {
            System.out.println(ANSI_BLUE + "*** SUM AFTER INCORRECT TRANSACTION(insufficient funds) ***" + ANSI_RESET);
            Transaction tr2 = new Transaction(alex, maria, "credit", -4000);
        } catch (TransactionNotFoundException e) {
            System.out.println(e);
        }

        try {
            System.out.println(ANSI_BLUE + "*** INCORRECT TRANSACTION  ***" + ANSI_RESET);
            Transaction tr4 = new Transaction(alex, maria, "debitt", 1000);
        } catch (TransactionNotFoundException e) {
            System.out.println(e);
        }

        System.out.println(ANSI_BLUE + "*** SUM AFTER TRANSACTION (1000)***" + ANSI_RESET);
        Transaction tr3 = new Transaction(alex, maria, "debit", 1000);

        alex.printUserData();
        maria.printUserData();
        alex.printTransactionsList();
        maria.printTransactionsList();

        try {
            System.out.println(ANSI_BLUE + "*** INCORRECT TRANSACTION (need -1000)  ***" + ANSI_RESET);
            Transaction tr4 = new Transaction(alex, maria, "credit", 1000);
        } catch (InccorectAmountException e) {
            System.out.println(e);
        }
    }
}
