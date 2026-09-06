import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger(0);

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count = " + counter.get());
    }
}