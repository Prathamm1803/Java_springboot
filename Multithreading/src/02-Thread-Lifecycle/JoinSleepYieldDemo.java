public class JoinSleepYieldDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i == 2) {
                    System.out.println("Worker sleeping for 2 seconds...");
                    try {
                        Thread.sleep(2000);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i == 4) {
                    System.out.println("Worker yielding...");
                    Thread.yield();
                }
            }
                System.out.println("Worker Finished");
        });
        worker.setName("Worker");
        System.out.println("Main starts worker");
        worker.start();
        System.out.println("Main waiting using join()");
        worker.join();
        System.out.println("Main resumes after worker finishes");
    }
}