
public class UsersArrayList implements UsersList {
    private int amount = 10;
    private int pointer = 0;
    private User[] users = new User[amount];

    @Override
    public void addUser(User name) throws ExistsException {
        if (pointer == 0) {
            users[0] = name;
            pointer++;
        } else {
            int i = 0;

            if (pointer != amount) {
                while (i < pointer) {
                    if (users[i].getId() == name.getId())
                        throw new ExistsException("User exists");
                    i++;
                }
                users[i] = name;
                pointer++;
            } else {
                amount *= 2;
                users = moreMemory(amount);
                while (i < pointer)
                    i++;
                users[i] = name;
                pointer++;
            }
        }
    }

    @Override
    public User getUserID(int id) throws UserNotFoundException {
        for (int i = 0; i < pointer; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        throw new UserNotFoundException("User not found");
    }

    private User[] moreMemory(int amount) {
        User[] newUsers = new User[amount];
        for (int i = 0; i < pointer; i++) {
            newUsers[i] = users[i];
        }
        return newUsers;
    }

    @Override
    public User getUserINDEX(int index) throws UserNotFoundException {
        if (pointer < index) {
            throw new UserNotFoundException("User not found");
        }
        return users[index];
    }

    @Override
    public int getAmountUsers() {
        return pointer;
    }

}