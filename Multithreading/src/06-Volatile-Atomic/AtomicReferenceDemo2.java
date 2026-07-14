import java.util.concurrent.atomic.AtomicReference;

class Student {
    private final String name;
    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class AtomicReferenceDemo2 {
    public static void main(String[] args) {

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Student charlie = new Student("Charlie");

        AtomicReference<Student> reference = new AtomicReference<>(alice);
        // Successful update
        reference.compareAndSet(alice, bob);

        // This fails because the current value is Bob, not Alice
        boolean success = reference.compareAndSet(alice, charlie);
        System.out.println("Update Successful : " + success);

        System.out.println("Current Student : " + reference.get().getName());
    }
}