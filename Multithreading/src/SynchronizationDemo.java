class Counter {
    int count = 0;
    void increment() {
        synchronized (this) {
            count++;
        }
    }
    int getCount() {
        return count;
    }
}
class myThread3 extends Thread {
    private Counter counter;
    myThread3 (Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
public class SynchronizationDemo {
    public static void main(String[] args) {

        Counter counter = new Counter();

        myThread3 t1 = new myThread3(counter);
        myThread3 t2 = new myThread3(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println(e);;
        }
        System.out.println(counter.getCount());

    }
}