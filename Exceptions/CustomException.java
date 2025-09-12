import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomException {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.print("Enter the numerator : ");
                double numerator = scanner.nextDouble();

                System.out.print("Enter the denominator : ");
                double denominator = scanner.nextDouble();

                if (denominator == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }

                double result = numerator / denominator;
                System.out.println("\nresult: " + numerator + " / " + denominator + " = " + result);

            } catch (InputMismatchException e) {
                System.err.println("\nError: Invalid input. Please enter valid numbers only.");
            } catch (ArithmeticException e) {
                System.err.println("\nError: " + e.getMessage());
            }
        }
    }
}