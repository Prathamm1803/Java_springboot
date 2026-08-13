import java.util.function.*;
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 8 even: " + isEven.test(8));
        
        Consumer<String> greet = name -> System.out.println("Hello, " + name + "!");
        greet.accept("Aman");
        
        Supplier<Double> rand = () -> Math.random();
        System.out.println(rand.get());

        Function<Integer, Integer> sq = x -> x * x;
        System.out.println("square of 5: " + sq.apply(5));

        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println(isGreater.test(20, 10));

        BiConsumer<String, Integer> display = (name, age) -> System.out.println(name + " " + age);
        display.accept("Pratham", 21);

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a+b;
        System.out.println(sum.apply(5, 4));

        UnaryOperator<Integer> sqr = n -> n * n;
        System.out.println(sqr.apply(5));

        BinaryOperator<Integer> mul = (a, b) -> a * b;
        System.out.println(mul.apply(5, 4));
    }
}

