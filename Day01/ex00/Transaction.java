import java.util.UUID;


public class Transaction {
    private UUID id;
    private User receiver;
    private User sender;
    private String transaction;
    private int sum;

    Transaction(User _receiver, User _sender, String transaction, int sum) {
        this.id = UUID.randomUUID();
        if (transaction.equals("debit") || transaction.equals("credit")) {
            this.transaction = transaction;
        } else {
            System.err.println("\u001B[31m" + "Incorrect Transaction" + "\u001B[0m");
        }
        receiver = _receiver;
        sender = _sender;
        if ((transaction.equals("debit")) && (sum > 0)) {
            this.sum = sum;
        } else if ((transaction.equals("credit")) && (sum < 0)) {
            if (sender.getBalance() - sum >= 0) {
                this.sum = sum;
            }
        } else {
            System.err.println("\u001B[31m" + "Incorrect Sum" + "\u001B[0m");
        }
    }

    public int getSum() {
        return sum;
    }

    public User getReceiver() {
        return receiver;
    }

    public User getSender() {
        return sender;
    }

    public UUID getId() {
        return id;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setSum(int sum) {
        if ((transaction.equals("debit")) && (sum > 0)) {
            this.sum = sum;
        } else if ((transaction.equals("credit")) && (sum < 0)) {
            if (sender.getBalance() - sum >= 0) {
                this.sum = sum;
            }
        } else {
            System.out.println("\u001B[31m" + "Incorrect Sum" + "\u001B[0m");
        }
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setReceiver(User _receiver) {
        receiver = _receiver;
    }

    public void setSender(User _sender) {
        sender = _sender;
    }

    public void setTransaction(String transaction) {
        if (transaction.equals("debit") || transaction.equals("credit")) {
            this.transaction = transaction;
        } else {
            System.out.println("\u001B[31m" + "Incorrect Transaction" + "\u001B[0m");
        }
    }
}