import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockDemo {
    private final Lock unFairLock = new ReentrantLock();
    void access() {
        unFairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Lock acquired");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " Lock unlocked...");
            unFairLock.unlock();
        }
    }
    public static void main(String[] args) {
        UnfairLockDemo demo = new UnfairLockDemo();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                demo.access();
            }
        };
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        // Observation -> Thread is running in unfair Or arbitary manner
        // Fairnedd kb hogi? First come first serve
    }
}

