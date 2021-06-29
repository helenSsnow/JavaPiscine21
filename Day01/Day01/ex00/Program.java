import java.util.UUID;

public class Program{
    public static void main(String[] args) {
        User alex = new User(890, "Boris", 1200);
        User maria = new User(111, "Maks", 4000);
        Transaction session = new Transaction(UUID.randomUUID(), alex, maria, "credit", -800);

        System.out.println("\u001B[32m" + "**** PRINT DEFAULT USERS ****" + "\u001B[0m");
        System.out.println(alex.getName());
        System.out.println(maria.getName());
        System.out.println(alex.getId());
        System.out.println(maria.getId());
        System.out.println(alex.getBalance());
        System.out.println(maria.getBalance());

        System.out.println("\u001B[32m" + "**** PRINT DEFAULT TRANSACTION ****" + "\u001B[0m");
        System.out.println(session.getId());
        System.out.println(session.getReceiver().getName());
        System.out.println(session.getSender().getName());
        System.out.println(session.getTransaction());
        System.out.println(session.getSum());

        System.out.println("\u001B[32m" + "**** PRINT USERS AFTER SET ****" + "\u001B[0m");
        alex.setName("Alex");
        maria.setName("Maria");
        alex.setId(123);
        maria.setId(456);
        alex.setBalance(12000);
        maria.setBalance(4000);

        System.out.println(alex.getName());
        System.out.println(maria.getName());
        System.out.println(alex.getId());
        System.out.println(maria.getId());
        System.out.println(alex.getBalance());
        System.out.println(maria.getBalance());

        System.out.println("\u001B[32m" + "**** PRINT TRANSACTION  AFTER SET****" + "\u001B[0m");

        session.setId(UUID.randomUUID());
        System.out.print("set credit: ");
        session.setTransaction("credit");
        System.out.println(session.getTransaction());
        session.setSum(-200);
        System.out.print("set debit: ");
        session.setTransaction("debit");
        System.out.println(session.getTransaction());
        session.setSum(200);
        System.out.print("set incorrect Transaction: ");
        session.setTransaction("aaaa");
        System.out.print("set incorrect Amount: ");
        session.setTransaction("debit");
        session.setSum(-200);
    }
}