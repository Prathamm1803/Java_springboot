public class ThreadPriorityDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread low = new Thread(task);
        Thread normal = new Thread(task);
        Thread high = new Thread(task);

        low.setName("Low");
        normal.setName("Normal");
        high.setName("High");

        low.setPriority(Thread.MIN_PRIORITY);
        normal.setPriority(Thread.NORM_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        System.out.println(low.getName() + "Priority: " + low.getPriority());
        System.out.println(normal.getName() + "Priority: " + normal.getPriority());
        System.out.println(high.getName() + "Priority: " + high.getPriority());

        low.start();
        normal.start();
        high.start();

        low.join();
        normal.join();
        high.join();

        System.out.println("All threads finished");
    }
}