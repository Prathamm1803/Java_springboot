class VolatileFlag {
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        VolatileFlag flag = new VolatileFlag();
        
        Thread worker = new Thread(() -> {
            System.out.println("Worker thread started.");
            while (flag.isRunning()) {
                // Simulate work
            }   
        });
        
        worker.start();
        Thread.sleep(1000);

        flag.stop();
        worker.join();
        System.out.println("Main thread finished."); 
    }    
}