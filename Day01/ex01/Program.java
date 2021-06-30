

public class Program {
    public static void main(String[] args) {
        User alex = new User("Alex", 3000);
        User boris = new User("Boris", 5000);
        User anna = new User("Anna", 1000);
        System.out.println(alex.getName() + " id: " + alex.getId() + ", balance: " + alex.getBalance());
        System.out.println(boris.getName() + " id: " + boris.getId() + ", balance: " + boris.getBalance());
        System.out.println(anna.getName() + " id: " + anna.getId() + ", balance: " + anna.getBalance());

    }
}