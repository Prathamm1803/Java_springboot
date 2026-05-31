class MyThread2 extends Thread {
    MyThread2(String name) {
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

        MyThread2 t1 = new MyThread2("Low");
        MyThread2 t2 = new MyThread2("Medium");
        MyThread2 t3 = new MyThread2("High");

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