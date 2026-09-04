class sharedBuffer {
    private int val;
    private boolean avl = false;

    public synchronized void produce(int val) {
        while (avl) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.val = val;
        avl = true;
        System.out.println("Produced: " + val);
        notifyAll();
    }

    public synchronized int consume() {
        while (!avl) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        avl = false;
        System.out.println("Consumed: " + val);
        notifyAll();
        return val;
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        sharedBuffer buffer = new sharedBuffer();
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
