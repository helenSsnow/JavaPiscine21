public class User {
    final private int id;
    private String name;
    private int balance;
    private TransactionsLinkedList listTransactions;

    User(String name, int balance){
        if(balance >= 0)
            this.balance = balance;
        this.name = name;
        this.id = UserIdsGenerator.getInstance().generateId();
        this.listTransactions = new TransactionsLinkedList();
    }

    int getId(){
        return this.id;
    }

    String getName(){
        return this.name;
    }

    int getBalance(){
        return this.balance;
    }

    public TransactionsLinkedList getListTransactions() {
        return listTransactions;
    }

    public void setBalance(int balance) {
        if(balance >= 0)
            this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
}