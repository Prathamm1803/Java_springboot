class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
public class LifeCycle {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println("After Creation: " + t1.getState()); // NEW

        t1.start();
        System.out.println("After Start(): "
                + t1.getState()); // RUNNABLE

        // Main thread sleeps for 100 ms
        // Gives child thread time to enter sleep()
        Thread.sleep(100);

        // Child thread is currently sleeping
        System.out.println("Child sleeping: " + t1.getState()); //TIMED WAITING

        // Main thread waits until child thread finishes
        t1.join();

        // Child thread has completed execution
        System.out.println("After Completion: " + t1.getState()); // TERMINATED
    }
}