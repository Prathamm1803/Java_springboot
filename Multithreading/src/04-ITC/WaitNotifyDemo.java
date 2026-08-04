class Printer {
    synchronized void print(String message) {
        System.out.println(Thread.currentThread().getName() + " started printing " + message);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished printing " + message);
    }
}
public class WaitNotifyDemo {
    public static void main(String[] args) {
        Printer printer1 = new Printer();
        Printer printer2 = new Printer();

        Thread t1 = new Thread(() -> printer1.print("Document-A"));
        Thread t2 = new Thread(() -> printer1.print("Document-B"));
        Thread t3 = new Thread(() -> printer2.print("Document-C"));

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}