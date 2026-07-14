import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class LikeCounter {
    AtomicReference<Integer> totalCount = new AtomicReference<>(0);

    Integer currentCount;
    Integer finalCount;

    void like() {
        while(true) {
            //We will capture the latest value of totalCount
            currentCount = totalCount.get();

            //Increment  like counter by 1
            finalCount = currentCount + 1;

            //Check again
            if (totalCount.compareAndSet(currentCount, finalCount)) {
                return;
            };
            //If a thread reaches here, domeone else must have updated their counter value
            //Re-try
            System.out.println("Conflict detected... retrying!");
        }
    }

    int get () {
        return totalCount.get();
    }
}

public class CASRetryDemo {
    public static void main (String[] args) {
        LikeCounter likeCounter = new LikeCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
        Thread t7 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
        Thread t8 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
        Thread t9 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
        Thread t10 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                likeCounter.like();
            }
        });
    
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try {
            Thread.sleep(3000);
        } catch(Exception e) {}

        System.out.println("Total Likes: " + likeCounter.get());

    }
}