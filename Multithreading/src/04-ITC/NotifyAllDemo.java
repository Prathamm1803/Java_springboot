class SharedResource {
    private boolean ready = false;
    public synchronized void waitForSignal() {
        while (!ready) {
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " received the signal.");
    }

    public synchronized void sendSignal() {
        System.out.println("\n" + Thread.currentThread().getName() + " is sending the signal...\n");
        ready = true;
        notifyAll();
    }
}

class WaitingThread extends Thread {
    private final SharedResource resource;
    public WaitingThread(SharedResource resource, String name) {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.waitForSignal();
    }
}

class NotifierThread extends Thread {
    private final SharedResource resource;
    public NotifierThread(SharedResource resource) {
        super("Notifier");
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resource.sendSignal();
    }
}

public class NotifyAllDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new WaitingThread(resource, "Thread A");
        Thread t2 = new WaitingThread(resource, "Thread B");
        Thread t3 = new WaitingThread(resource, "Thread C");

        Thread notifier = new NotifierThread(resource);

        t1.start();
        t2.start();
        t3.start();

        notifier.start();
    }
}