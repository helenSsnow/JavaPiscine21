public class Conversation {

    private int count = 1;

    public synchronized void printEgg() throws InterruptedException {
        while (count % 2 == 0){
            wait();
        }
        count++;
        System.out.println("Egg");
        notify();
    }

    public synchronized void printHen() throws InterruptedException {
        while (count % 2 == 1){
            wait();
        }
        count++;
        System.out.println("Hen");
        notify();
    }
}
