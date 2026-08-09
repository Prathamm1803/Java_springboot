import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Person {
    private String name;

    public Person() {
        this.name = "Unknown";
    }

    public Person(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Person Name: " + name);
    }
}

public class MethodAndConstructorReferenceDemo {
    public static void main(String[] args) {

        System.out.println("Static Method Reference");
        BiFunction<Integer, Integer, Integer> maximum = Math::max;
        System.out.println("Maximum of 15 and 25: " + maximum.apply(15, 25));

        System.out.println("\nInstance Method Reference");
        Consumer<String> print = System.out::println;
        print.accept("Hello, Java 8!");

        System.out.println("\nInstance Method of an Arbitrary Object");
        List<String> languages = Arrays.asList("java", "sql", "spring");
        languages.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("\nConstructor Reference (No-Arg)");
        Supplier<Person> person1 = Person::new;
        person1.get().display();

        System.out.println("\nConstructor Reference (Parameterized)");
        Function<String, Person> person2 = Person::new;
        person2.apply("Pratham").display();

        System.out.println("\nConstructor Reference (ArrayList)");
        Supplier<ArrayList<String>> listSupplier = ArrayList::new;
        ArrayList<String> list = listSupplier.get();

        list.add("Java");
        list.add("Spring Boot");
        list.add("Hibernate");
        list.forEach(System.out::println);
    }
}