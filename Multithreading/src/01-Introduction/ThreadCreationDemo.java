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
        myThread t1 = new myThread(); //through thread class
        Thread t2= new Thread(new myRunnable()); //through runnable interface
        Thread t3 = new Thread(()-> { // through lambda expression
            System.out.println("Lambda: " + Thread.currentThread().getName());
        });
    
        t1.start();
        t2.start();
        t3.start();
    }
}
