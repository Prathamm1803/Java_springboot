import java.util.concurrent.atomic.AtomicInteger;
class Counter {
    AtomicInteger count = new AtomicInteger(0);
    public void increment() {
        count.incrementAndGet();
    }
}

public class AtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count.get());
    }
}