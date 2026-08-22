import java.util.List;
public  class IntermediateAndTerminalOperationsDemo {
    public static void main(String[] args) {
        List<Integer> num = List.of(5, 2, 8, 2, 1, 9, 5, 7);

        List<Integer> res = num.stream()
                .distinct()
                .sorted()
                .skip(1)
                .limit(4)
                .peek(n -> System.out.println("Processing: " + n))
                .toList();
        System.out.println(res);

        long cnt = num.stream().count();
        int sum = num.stream()
                .reduce(0, Integer::sum);

        num.stream().findFirst()
                .ifPresent(System.out::println);

        Boolean anyEven = num.stream()
                .anyMatch(n -> n % 2 == 0);

        Boolean allPositive = num.stream()
                .allMatch(n -> n > 0);

        num.stream().forEach(System.out::println);
    }
}
