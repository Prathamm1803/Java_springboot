public class ProcessVsThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        Thread t1 = new Thread(()->{
            System.out.println("Task1 is running..." + Thread.currentThread().getName());
        });
        
        Thread t2 = new Thread(()->{
            System.out.println("Task2 is running..." + Thread.currentThread().getName());
        });
        
        t1.start();
        t2.start();
        
        System.out.println("Main Method Finished!");
    }
}