import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker extends Thread {

    private final Lock lock;

    Worker(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if(lock.tryLock(3100, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(getName() + " acquired lock");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(getName() + " could not acquire lock");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class LocksDemo {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Worker t1 = new Worker("Thread-1", lock);
        Worker t2 = new Worker("Thread-2", lock);

        t1.start();
        t2.start();
    }
}