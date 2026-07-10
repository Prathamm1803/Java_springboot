class SharedResource {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {

        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " acquired Lock 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " waiting for Lock 2");

            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired Lock 2");
            }
        }
    }

    public void method2() {

        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " acquired Lock 2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " waiting for Lock 1");

            synchronized (lock1) {

                System.out.println(Thread.currentThread().getName() + " acquired Lock 1");
            }
        }
    }
}

class ThreadA extends Thread {
    private final SharedResource resource;

    public ThreadA(SharedResource resource) {
        super("Thread A");
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.method1();
    }
}

class ThreadB extends Thread {
    private final SharedResource resource;

    public ThreadB(SharedResource resource) {
        super("Thread B");
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.method2();
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        ThreadA t1 = new ThreadA(resource);
        ThreadB t2 = new ThreadB(resource);

        t1.start();
        t2.start();

    }
}