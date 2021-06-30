public class Program {

    public static void main(String[] args) {
        UsersArrayList users = new UsersArrayList();
        User alex = new User("Alex", 200);
        User boris = new User("Boris",100);
        User anna = new User("Anna",1000);
        User gelb = new User("Gleb", 4900);
        User nastya = new User("Nastya", 3456);
        User lena = new User("Lena", 4564);
        User dasha = new User("Dasha",2354);
        User katya = new User("Katya",45674);
        User sasha = new User("Sasha",231);
        User kolya = new User("Kolya",3465);
        User den = new User("Den",34);
        User oleg = new User("Oleg",2344);
        try {
            users.addUser(alex);
            users.addUser(boris);
            users.addUser(anna);
            users.addUser(gelb);
            users.addUser(nastya);
            users.addUser(lena);
            users.addUser(dasha);
            users.addUser(katya);
            users.addUser(sasha);
            users.addUser(kolya);
            users.addUser(den);
            users.addUser(oleg);

            try {
                System.out.println(users.getUserID(1).getName());
                System.out.println(users.getUserID(2).getName());
                System.out.println(users.getUserID(3).getName());
                System.out.println(users.getUserID(4).getName());
                System.out.println(users.getUserID(5).getName());
                System.out.println(users.getUserID(6).getName());
                System.out.println(users.getUserID(7).getName());
                System.out.println(users.getUserID(8).getName());
                System.out.println(users.getUserID(9).getName());
                System.out.println(users.getUserID(10).getName());
                System.out.println(users.getUserID(11).getName());
                System.out.println(users.getUserID(12).getName());

                System.out.println(users.getUserINDEX(3).getName());

                System.out.println(users.getUserINDEX(6).getName());

                System.out.println(users.getUserINDEX(9).getName());
                System.out.println(users.getAmountUsers());
            }catch (UserNotFoundException e){
                System.out.println(e);
            }
        }catch (ExistsException e){
            System.out.println(e);
        }

        System.out.println("***EXCEPTION \"ExistsException\"***");

        try {
            users.addUser(alex);
        }catch (ExistsException e){
            System.out.println(e);
        }

        System.out.println("***EXCEPTION \"UserNotFoundException\"***");
            try {
                System.out.println(users.getUserID(13).getName());
            }catch (UserNotFoundException e){
                System.out.println(e);
            }

        System.out.println("***EXCEPTION \"UserNotFoundException\"***");
            try {
                System.out.println(users.getUserINDEX(13).getName());
            }catch (UserNotFoundException e){
                System.out.println(e);
            }

    }
}