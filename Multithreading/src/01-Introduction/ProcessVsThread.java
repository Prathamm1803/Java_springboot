public class ProcessVsThread {
    public static void main(String[] args) {
        System.out.println("Current Process ID : " + ProcessHandle.current().pid());
        System.out.println("Current Thread     : " + Thread.currentThread().getName());
        System.out.println("Thread ID          : " + Thread.currentThread().threadId());

        Thread worker1 = new Thread(() -> {
            System.out.println(
                    "Worker 1 -> " +
                    Thread.currentThread().getName() +
                    " | ID : " +
                    Thread.currentThread().threadId()
            );
        });

        Thread worker2 = new Thread(() -> {
            System.out.println(
                    "Worker 2 -> " +
                    Thread.currentThread().getName() +
                    " | ID : " +
                    Thread.currentThread().threadId()
            );
        });

        worker1.start();
        worker2.start();

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nProgram Finished.");
    }
}