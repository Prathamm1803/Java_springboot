class sharedResource {
    public synchronized void waitForNotify(String name) {
        try {
            System.out.println(name + " is waiting...");
            wait();
            System.out.println(name + " resumed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public synchronized void notify(boolean notifyAll) {
        if (notifyAll) {
            System.out.println("Notifying all threads...");
            notifyAll();
        } else {
            System.out.println("Notifying one thread...");
            notify();
        }
    }
}

public class NotifyVsNotifyAllDemo {
    public static void main(String[] args) throws InterruptedException {
        sharedResource resource = new sharedResource();
        
        Thread t1 = new Thread(() -> resource.waitForNotify("Thread 1"));
        Thread t2 = new Thread(() -> resource.waitForNotify("Thread 2"));

        t1.start();
        t2.start();

        Thread.sleep(1000);
        resource.notify(false);

        Thread.sleep(1000);
        resource.notify(true);

        t1.join();
        t2.join();
    }
}