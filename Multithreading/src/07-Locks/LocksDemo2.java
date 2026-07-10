import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bankaccount {
    private static int bal = 100;
    private final Lock lock = new ReentrantLock(); //Reenterant -> implemented class of Lock interface
    //after adding synchronization, thread-2 will work after thread-1 finishes
    void withdraw(int amt) {
        System.out.println(Thread.currentThread().getName() + " Attempt to withdraw: " + amt);
       /* if (bal >= amt) {
            System.out.println(Thread.currentThread().getName() + " Proceeding to withdraw: " + amt);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            bal -= amt;
            System.out.println(Thread.currentThread().getName() + " Withdrawal completed. Remaining Balance: " + bal);
        } else {
            System.out.println(Thread.currentThread().getName() + " Insufficient Balance...");
        } */
        try {
            //trylock(without time) -> // Tries to acquire the lock instantly; if unavailable, it returns immediately.
            if (lock.tryLock(4000, TimeUnit.MILLISECONDS)) { //Waits for the lock for a limited time; acquires it if available, otherwise gives up
                try {
                    if (bal >= amt) {
                        System.out.println(Thread.currentThread().getName() + " Proceeding to withdraw: " + amt);
                        Thread.sleep(3000);
                        bal -= amt;
                        System.out.println(Thread.currentThread().getName() + " Withdrawal completed. Remaining Balance: " + bal);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " Insufficient Balance!!");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Could not acquire the lock...Will try later " + amt);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
public class LocksDemo2 {
    public static void main(String[] args) {
        Bankaccount hdfc = new Bankaccount();
//        Anonymous class implementation of
        Runnable task = new Runnable() {
            @Override
            public void run() {
                hdfc.withdraw(30);
            }
        };
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

