import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiBasicDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Prakash", "Aman", "Pratham");
        System.out.println("Original List: ");
        names.forEach(System.out::println);

        List<String> filteredNames = names.stream().filter(name -> name.length() > 4).collect(Collectors.toList());

        System.out.println("After Filter(): ");
        filteredNames.forEach(System.out::println);

        List<String> upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("After map");
        upperCaseNames.forEach(System.out::println);
    }
}