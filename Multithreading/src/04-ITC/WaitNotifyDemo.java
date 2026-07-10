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
        System.out.println(Thread.currentThread().getName() + " is sending the signal.");
        ready = true;
        notify();
    }
}

class WaitingThread extends Thread {
    private final SharedResource resource;
    public WaitingThread(SharedResource resource, String name) {
        this.resource = resource;
        this.setName(name);
    }

    @Override
    public void run() {
        resource.waitForSignal();
    }

}

class NotifyingThread extends Thread {
    private final SharedResource resource;
    public NotifyingThread(SharedResource resource, String name) {
        this.resource = resource;
        this.setName(name);
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

public class WaitNotifyDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        WaitingThread t1 = new WaitingThread(resource, "Waiting Thread");
        NotifyingThread t2 = new NotifyingThread(resource, "Notifier Thread");

        // t1.setName("Waiting Thread");
        // t2.setName("Notifier Thread");

        t1.start();
        t2.start();
    }
}