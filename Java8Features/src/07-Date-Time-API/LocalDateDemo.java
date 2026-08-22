import java.time.LocalDate;
import java.time.Month;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
//        System.out.println(now);
        LocalDate dob = LocalDate.of(2005, 3, 18);

        int dayOfMonth = now.getDayOfMonth();
        Month month = now.getMonth();
        int year = now.getYear();

        System.out.println(dayOfMonth);
        System.out.println(month);
        System.out.println(year);
    }
}