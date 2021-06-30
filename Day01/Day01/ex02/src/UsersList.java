public interface UsersList{
    void addUser(User name) throws ExistsException;
    User getUserID(int id) throws UserNotFoundException;
    User getUserINDEX(int index) throws UserNotFoundException;
    int getAmountUsers();
}