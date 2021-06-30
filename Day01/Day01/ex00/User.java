import java.util.UUID;

public class User {
    private int id;
    private String name;
    private int balance;

    User(int id, String name, int balance){
        this.id = id;
        if(balance >= 0)
            this.balance = balance;
        this.name = name;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(int balance) {
        if(balance >= 0)
            this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }


}