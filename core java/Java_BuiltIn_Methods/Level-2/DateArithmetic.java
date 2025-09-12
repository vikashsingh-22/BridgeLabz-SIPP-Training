import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = scanner.nextLine();

        LocalDate date = LocalDate.parse(input);
        LocalDate updatedDate = date
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Final date after operations: " + updatedDate.format(formatter));
    }
}
