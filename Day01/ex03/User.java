public class User {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    final private int id;

    private String name;

    private int balance;

    private TransactionsList listTransactions = new TransactionsLinkedList();

    User(String name, int balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
        this.name = name;
        this.id = UserIdsGenerator.getInstance().generateId();
    }

    int getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    int getBalance() {
        return this.balance;
    }

    public TransactionsList getListTransactions() {
        return listTransactions;
    }

    public void setBalance(int balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printUserData() {
        System.out.println(ANSI_GREEN + "User " + id + ":" + ANSI_RESET);
        System.out.println("NAME          " + name);
        System.out.println("BALANCE       " + balance + "\n");
    }

    public void printTransactionsList() {
        Transaction[] tmp = listTransactions.toArray();
        TransactionsLinkedList tmpList = new TransactionsLinkedList();
        String categor;
        System.out.println(ANSI_YELLOW + "Transactions (User " + id + "):" + ANSI_RESET);

        for (int i = tmpList.getSize(), j = 0; i > 0; i--, j++) {
            categor = tmp[j].getTransaction() == "debit" ? "debit" : "credit";
            System.out.print((j + 1) + ". ");
            System.out.print("ID = " + tmp[j].getId());
            System.out.print(" RECIPIENT = " + tmp[j].getReceiver().getName());
            System.out.print(" SENDER = " + tmp[j].getSender().getName());
            System.out.print(" TRANSACTION = " + categor);
            System.out.println(" AMOUNT = " + tmp[j].getSum());
        }
    }
}