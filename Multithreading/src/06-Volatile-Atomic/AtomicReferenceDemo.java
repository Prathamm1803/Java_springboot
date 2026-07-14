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

public class AtomicReferenceDemo {
    public static void main(String[] args) {

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        AtomicReference<Student> reference = new AtomicReference<>(student1);
        System.out.println("Current Student : " + reference.get().getName());

        boolean updated = reference.compareAndSet(student1, student2);

        System.out.println("Updated Successfully : " + updated);
        System.out.println("Current Student : " + reference.get().getName());
    }
}