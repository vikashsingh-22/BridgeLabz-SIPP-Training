import java.util.Scanner;
import java.util.InputMismatchException;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");

        try {
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Access granted!");
        } catch (InputMismatchException ime) {
            System.out.println("Please enter a valid number for age.");
        } catch (InvalidAgeException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
