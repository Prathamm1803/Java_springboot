public class ThreadCreation extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
//          System.out.println("World");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
