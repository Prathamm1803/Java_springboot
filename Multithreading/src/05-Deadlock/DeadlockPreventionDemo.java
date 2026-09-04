class ResourceA {
}

class ResourceB {
}

public class DeadlockPreventionDemo {
    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        Thread t1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Thread 1: Holding Resource A...");
                
                synchronized (resourceB) {
                    System.out.println("Thread 1: Acquired Resource B!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resourceA) { // Changed to lock resourceA first
                System.out.println("Thread 2: Holding Resource A...");
                
                synchronized (resourceB) {
                    System.out.println("Thread 2: Acquired Resource B!");
                }
            }
        });

        t1.start();
        t2.start();        
    }
}
