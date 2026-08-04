class RaceCounter {
    int cnt = 0;
    void increment() {
        cnt++;
    }
}
public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        RaceCounter counter = new RaceCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: "+ counter.cnt);
    }
}