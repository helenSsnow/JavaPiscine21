import static jdk.nashorn.internal.objects.NativeString.substring;

public class Program {
    public static void main(String[] args) throws InterruptedException {

		if(args.length !=1)
			System.err.println("Incorrect args");
        String arg = args[0];
        String subArg = arg.substring(0, arg.lastIndexOf("=") + 1);
        int count = Integer.parseInt (arg.substring(arg.lastIndexOf("=") + 1));
        if(arg.lastIndexOf("=") == -1 || subArg.equals("--count=") == false
            || count < 0){
            System.err.println("Incorrect args");
        }
        else{
            Hen hen = new Hen(count);
            Egg egg = new Egg(count);

            hen.start();
            egg.start();

            hen.join();
            egg.join();

            for (int i = 0; i < count; i++){
                System.out.println("Human");
            }
        }
    }
}
class Hen extends Thread{
    int count;

    Hen(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < count; i++) {
            System.out.println("Hen");
        }
    }
}
class Egg extends Thread{
    int count;

    Egg(int count) {
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 0; i < count; i++) {
            System.out.println("Egg");
        }
    }
}
