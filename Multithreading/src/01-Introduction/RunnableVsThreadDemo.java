class myTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Running on: " + Thread.currentThread().getName());
    }
}
public class RunnableVsThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new myTask());
        System.out.println("Calling run()...");
        thread.run();

        
    }
}