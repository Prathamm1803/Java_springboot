import java.util.concurrent.atomic.AtomicInteger;
class Counter {
    AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }
}

class Worker extends Thread {
    private final Counter counter;
    public Worker(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
    }
}

public class AtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Worker(counter);
        Thread t2 = new Worker(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count.get());
    }
}