import java.util.UUID;

public class Program {
    public static void main(String[] args) throws NotExistException {
        User alex = new User("Alex", 4000);
        User maria = new User("Maria",1000);
//        User katya = new User("Katya", 500);
//        User lena = new User("Lena", 3000);
//        User nadya = new User("Nadya", 500);
//        User kostya = new User("Kostya", 2500);



//        Transaction session2 = new Transaction(UUID.randomUUID(), katya, lena, "debit", 500);
//        Transaction session3 = new Transaction(UUID.randomUUID(), nadya, kostya, "credit", -100);
        System.out.println("*** SUM BEFORE TRANSACTION ***");
        System.out.println("alex: " + alex.getBalance() + " maria: " + maria.getBalance() + " ===> "+ (alex.getBalance() + maria.getBalance()));

        Transaction tr1 = new Transaction(alex, maria, "credit", -800);
//        alex.getListTransactions().addTransaction(tr1);
//        maria.getListTransactions().addTransaction(tr1);
//
        System.out.println("*** SUM AFTER TRANSACTION ***");
        System.out.println("alex: " + alex.getBalance() + " maria: " + maria.getBalance() + " ===> "+ (alex.getBalance() + maria.getBalance()));


//        int i = 0;
//        while(i < 3){
//            System.out.println(list.toArray()[i].getReceiver().getName());
//            i++;
//        }
//        list.deleteTransaction(session2);
//        i = 0;
//        while(i < 2){
//            System.out.println(list.toArray()[i].getReceiver().getName());
//            i++;
//        }
//        list.deleteTransaction(session3);
//        i = 0;
//        while(i < 1){
//            System.out.println(list.toArray()[i].getReceiver().getName());
//            i++;
//        }
    }
}
