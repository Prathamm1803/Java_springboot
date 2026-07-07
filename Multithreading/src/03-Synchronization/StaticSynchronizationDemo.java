class Printer {
    static synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " : "
                            + n * i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    private int number;
    public MyThread(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    public void run() {
        Printer.printTable(number);
    }
}

public class StaticSynchronizationDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread A", 5);
        MyThread t2 = new MyThread("Thread B", 10);

        t1.start();
        t2.start();
    }
}