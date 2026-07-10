class Worker extends Thread {
    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("----------------------------------");
        System.out.println("Current Thread : " + Thread.currentThread().getName());
        System.out.println("Thread ID      : " + Thread.currentThread().threadId());
        System.out.println("Is Alive?      : " + Thread.currentThread().isAlive());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " Finished.");
        System.out.println("----------------------------------");
    }
}

public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {

        Worker t1 = new Worker("Download Thread");

        // getName()
        System.out.println("Default Name : " + t1.getName());

        // setName()
        t1.setName("Worker Thread");

        System.out.println("Updated Name : " + t1.getName());

        // currentThread()
        System.out.println("\nMain Thread : " + Thread.currentThread().getName());

        // isAlive() before start
        System.out.println("\nIs Worker Alive? " + t1.isAlive());

        // start()
        t1.start();

        // isAlive() after start
        System.out.println("Is Worker Alive? " + t1.isAlive());

        // join()
        t1.join();

        // isAlive() after completion
            System.out.println("\nIs Worker Alive? " + t1.isAlive());

        System.out.println("\nMain Thread Finished.");
    }
}