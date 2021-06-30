public class User {
    final private int id;
    private String name;
    private int balance;

    User(String name, int balance){
        if(balance >= 0) {
            this.balance = balance;
        }
        this.name = name;
        this.id = UserIdsGenerator.getInstance().generateId();
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

    public void setBalance(int balance) {
        if(balance >= 0)
            this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
}
