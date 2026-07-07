class Counter {
    private int cnt = 0;
    public void increment() {
        cnt++;
    }
    public int getCount() {
        return cnt;
    }
}

class MyThread extends Thread {
    private Counter counter;
    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Expected Count : 2000");
        System.out.println("Actual Count   : " + counter.getCount());
    }
}