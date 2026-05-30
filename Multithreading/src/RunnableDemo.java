public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
//            System.out.println("World");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
