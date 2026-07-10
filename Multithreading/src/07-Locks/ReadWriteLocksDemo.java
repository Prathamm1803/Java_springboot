import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocksDemo {

    private int cnt = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            cnt++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return cnt;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLocksDemo demo = new ReadWriteLocksDemo();
        Runnable read = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + demo.getCount());
                }
            }
        };
        Runnable write = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    demo.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented");
                }
            }
        };
        Thread writeThread = new Thread(write);
        Thread readThread1 = new Thread(read);
        Thread readThread2 = new Thread(read);

        writeThread.start();
        readThread1.start();
        readThread2.start();

        writeThread.join();
        readThread1.join();
        readThread2.join();

        System.out.println("Final Count: " + demo.getCount());
    }
}
