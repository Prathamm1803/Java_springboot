class ResourceA {
}
class ResourceB {
}
public class DeadlockDemo {
    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        Thread t1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Thread 1: Holding Resource A...");
                
                try { 
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                System.out.println("Thread 1: Waiting for Resource B...");
                
                synchronized (resourceB) {
                    System.out.println("Thread 1: Acquired Resource B!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("Thread 2: Holding Resource B...");
                
                try { 
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Thread 2: Waiting for Resource A...");
                
                synchronized (resourceA) {
                    System.out.println("Thread 2: Acquired Resource A!");
                }
            }
        });

        t1.start();
        t2.start();    
    }
}
