class SharedFlag {
    volatile boolean running = true;
}

class Worker extends Thread {
    private final SharedFlag flag;

    public Worker(SharedFlag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("Worker Started");
        while (flag.running) {
            // Busy waiting
        }
        System.out.println("Worker Stopped");
    }
}

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedFlag flag = new SharedFlag();
        Worker worker = new Worker(flag);
        worker.start();
        Thread.sleep(3000);
        System.out.println("Stopping Worker...");
        flag.running = false;
    }
}