class MyThreads extends Thread {
    MyThreads(String name) {
        super(name);
    }
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
public class PriorityDemo {
    public static void main(String[] args) {

        MyThreads t1 = new MyThreads("Low");
        MyThreads t2 = new MyThreads("Medium");
        MyThreads t3 = new MyThreads("High");

        t1.setPriority(Thread.MIN_PRIORITY); // 1
        t2.setPriority(Thread.NORM_PRIORITY); // 5
        t3.setPriority(Thread.MAX_PRIORITY); // 10

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());

        t1.start();
        t2.start();
        t3.start();
    }
}