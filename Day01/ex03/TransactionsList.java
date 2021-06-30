import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction name);

    void deleteTransaction(UUID id) throws TransactionNotFoundException;

    Transaction[] toArray();
}
