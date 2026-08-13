import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface calculator {
    int calculate(int a, int b);
}

public class LambdaDemo {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Task running...");
        task.run();
        
        calculator add = (a, b) -> a + b;
        calculator mul = (a, b) -> a * b;

        System.out.println("3 + 5 = " + add.calculate(3, 5));
        System.out.println("3 * 5 = " + mul.calculate(3, 5));

        calculator max = (a, b) -> {
            if (a > b) return a;
            else return b;
        };

        System.out.println("Max(3, 5) = " + max.calculate(3, 5));

        List<String> names = Arrays.asList("Aman", "Pratham", "Vansh");
        names.forEach((name) -> System.out.println(name));
    }
}