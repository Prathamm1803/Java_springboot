class myThread extends Thread{
    @Override
    public void run() {
            System.out.println("Thread Class: "+Thread.currentThread().getName());
    }
}
class myRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable: "+ Thread.currentThread().getName());
    }
}
public class ThreadCreationDemo {
    public static void main(String[] args) {
        myThread t1 = new myThread();
        Thread t2= new Thread(new myRunnable());
        Thread t3 = new Thread(()-> {
            System.out.println("Lambda: " + Thread.currentThread().getName());
        });
    
        t1.start();
        t2.start();
        t3.start();
    }
}
