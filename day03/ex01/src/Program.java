import static jdk.nashorn.internal.objects.NativeString.substring;

public class Program {

    public static void main(String[] args) throws InterruptedException {
    Conversation conversation = new Conversation();
	if(args.length !=1)
		 System.err.println("Incorrect sum args");
	String arg = args[0];

	String subArg = arg.substring(0, arg.lastIndexOf("=") + 1);
	int count = Integer.parseInt (arg.substring(arg.lastIndexOf("=") + 1));
	if(arg.lastIndexOf("=") == -1 || subArg.equals("--count=") == false
		|| count < 0){
		System.err.println("Incorrect args");
	}
	else{
		Hen hen = new Hen(count, conversation);
		Egg egg = new Egg(count, conversation);

		hen.start();
		egg.start();
	}
    }
}
class Hen extends Thread{
    int count;
    Conversation conversation;

    Hen(int count, Conversation conversation) {
        this.count = count;
        this.conversation = conversation;
    }

    @Override
    public void run() {
        for(int i = 0; i < count; i++) {
            try {
                conversation.printHen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Egg extends Thread{
    int count;
    Conversation conversation;

    Egg(int count, Conversation conversation) {
        this.count = count;
        this.conversation = conversation;
    }
    @Override
    public void run() {
        for(int i = 0; i < count; i++) {
            try {
                conversation.printEgg();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
