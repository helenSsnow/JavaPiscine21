

public class Program {
    public static void main(String[] args) {
        User alex = new User("Alex", 3000);
        User boris = new User("Boris", 5000);
        User anna = new User("Anna", 1000);
        System.out.println(alex.getId());
        System.out.println(boris.getId());
        System.out.println(anna.getId());

    }
}