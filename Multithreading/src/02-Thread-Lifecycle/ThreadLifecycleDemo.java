public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread Finsihed");
        });

        System.out.println("Before Start(): " + t1.getState()); // NEW

        t1.start();
        System.out.println("After Start(): " + t1.getState()); // RUNNABLE

        // Main thread sleeps for 100 ms
        // Gives child thread time to enter sleep()
        Thread.sleep(500);

        // Child thread is currently sleeping
        System.out.println("Child sleeping: " + t1.getState()); //TIMED WAITING

        // Main thread waits until child thread finishes
        t1.join();

        // Child thread has completed execution
        System.out.println("After Completion: " + t1.getState()); // TERMINATED
    }
}