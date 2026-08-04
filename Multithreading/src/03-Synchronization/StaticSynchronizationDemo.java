class Bank {
    static synchronized void printMessage(String threadName) {
        System.out.println(threadName + " entered");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " leaving");
    }
}

public class StaticSynchronizationDemo {
    public static void main(String[] args) {
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();

        Thread t1 = new Thread(() -> bank1.printMessage("Thread-1"));
        Thread t2 = new Thread(() -> bank2.printMessage("Thread-2"));

        t1.start();
        t2.start();
    }
}