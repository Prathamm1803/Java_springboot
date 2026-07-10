public class Test {
    public static void main(String[] args) {
//      ThreadCreation t1 = new ThreadCreation();
//      t1.start();

        RunnableDemo task = new RunnableDemo();
        Thread t1 = new Thread(task);
        t1.start();

        for (int i = 0; i < 1000; i++) {
//            System.out.println("Hello");
            System.out.println(Thread.currentThread().getName());
        }
    }
}


