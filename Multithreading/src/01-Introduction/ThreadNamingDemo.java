public class ThreadNamingDemo {
    public static void main(String[] args) {
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        Thread t1 = new Thread(() -> System.out.println("Running on: " + Thread.currentThread().getName()));
        Thread t2 = new Thread(() -> System.out.println("Running on: " + Thread.currentThread().getName()));

        t1.setName("Download-Thread");
        t2.setName("upload-Thread");

        t1.start();
        t2.start();
    }        
}