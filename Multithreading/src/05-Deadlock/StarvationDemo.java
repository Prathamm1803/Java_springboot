class Printer {
    public synchronized void print(String message) {

        System.out.println(Thread.currentThread().getName() + " acquired the printer.");
        try {
            Thread.sleep(3000);      // Holds the lock for a long time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(message);
        System.out.println(Thread.currentThread().getName() + " released the printer.\n");
    }
}

class GreedyThread extends Thread {
    private final Printer printer;

    public GreedyThread(Printer printer) {
        super("Greedy Thread");
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            printer.print("Printing document " + i);
        }
    }
}

class NormalThread extends Thread {
    private final Printer printer;

    public NormalThread(Printer printer) {
        super("Normal Thread");
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print("Printing an important document.");
    }
}

public class StarvationDemo {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread greedy = new GreedyThread(printer);
        Thread normal = new NormalThread(printer);

        greedy.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        normal.start();
    }

}