import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        Function<Integer, Integer> sq = x -> x * x;
        System.out.println("square of 5: " + sq.apply(5));

        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 8 even: " + isEven.test(8));
        System.out.println("Is 7 even: " + isEven.test(7));

        Consumer<String> greet = name -> System.out.println("Hello, " + name + "!");
        greet.accept("Aman");

        Supplier<String> message = () -> "Keep learning Java!";
        System.out.println(message.get());
    }
}

