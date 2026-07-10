import java.util.concurrent.*;
class PrintTask implements Runnable {
    private final int taskId;

    public PrintTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(
                "Runnable Task " + taskId +
                " executed by " +
                Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable Task " + taskId + " Finished");
    }
}

class SumTask implements Callable<Integer> {
    private final int number;
    public SumTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(
                "Callable Task " + number +
                " executed by " +
                Thread.currentThread().getName());

        Thread.sleep(3000);
        return number * number;
    }
}

public class ExecutorFrameworkDemo {
    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        System.out.println("Submitting Runnable Tasks...\n");

        executor.execute(new PrintTask(1));
        executor.execute(new PrintTask(2));
        executor.execute(new PrintTask(3));

        executor.submit(new PrintTask(4));

        System.out.println("\nSubmitting Callable Tasks...\n");

        Future<Integer> future1 =
                executor.submit(new SumTask(10));

        Future<Integer> future2 =
                executor.submit(new SumTask(20));

        Future<Integer> future3 =
                executor.submit(new SumTask(30));

        System.out.println("\nMain thread continues working...\n");

        while (!(future1.isDone() &&
                 future2.isDone() &&
                 future3.isDone())) {

            System.out.println("Waiting for Callable Tasks...");

            Thread.sleep(500);
        }

        System.out.println("\nResults");

        System.out.println("10² = " + future1.get());
        System.out.println("20² = " + future2.get());
        System.out.println("30² = " + future3.get());

        executor.shutdown();

        if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("\nExecutor Shutdown Successfully");
        }

        System.out.println("Main Thread Finished");
    }
}