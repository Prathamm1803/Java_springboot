import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantDemo {
    private final Lock lock = new ReentrantLock();

    void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer_Method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }
    void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner_Method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReenterantDemo demo = new ReenterantDemo();
        demo.outerMethod();
    }
}
