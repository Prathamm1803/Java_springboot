import java.util.concurrent.locks.ReentrantLock;

public class StarvationDemo {
    public static final ReentrantLock lock = new ReentrantLock(false); //unfair lock to demonstrate starvation
    public static void main(String[] args) {
        Runnable task = () -> {

            String threadName = Thread.currentThread().getName();
            
            while (true) {
                lock.lock();

                try {
                    System.out.println(threadName + " acquired the lock.");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");   
        Thread t3 = new Thread(task, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
