import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockDemo {
    private final Lock FairLock = new ReentrantLock(true);
    void access() {
        FairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Lock acquired");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " Lock unlocked...");
            FairLock.unlock();
        }
    }
    public static void main(String[] args) {
        FairLockDemo demo = new FairLockDemo();
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
    }
}

