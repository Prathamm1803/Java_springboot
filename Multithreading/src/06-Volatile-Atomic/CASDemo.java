import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger value = new AtomicInteger(10);

        boolean result = value.compareAndSet(10, 20);

        System.out.println("CAS successful: " + result);
        System.out.println("Value: " + value.get());

        result = value.compareAndSet(10, 30);

        System.out.println("CAS successful: " + result);
        System.out.println("Value: " + value.get());
    }
}