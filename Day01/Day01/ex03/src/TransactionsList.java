import java.util.UUID;
public interface TransactionsList {
    void addTransaction(Transaction name) throws ExistsException;
    void deleteTransaction(UUID id) throws NotExistException;
    Transaction[] toArray();
}
