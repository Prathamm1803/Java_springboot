import java.util.concurrent.atomic.AtomicReference;

class User {
    String name;

    User (String name) {
        this.name = name;
    }
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {

        AtomicReference<User> user = new AtomicReference<> (new User("Pratham"));
        System.out.println ("Before: " + user.get().name);

        user.set(new User("Rahul"));

        System.out.println("After: " + user.get().name);
    }
}