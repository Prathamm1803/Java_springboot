class Printer {
    synchronized void printNumbers() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " : "
                            + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class ObjectLockDemo {
    public static void main(String[] args) {
        Printer p1 = new Printer();
        Printer p2 = new Printer();

        Thread t1 = new Thread(p1::printNumbers, "Thread-1");
        Thread t2 = new Thread(p2::printNumbers, "Thread-2");

        t1.start();
        t2.start();

    }

}