import java.util.Scanner;

public class BasicCalculator {
    static double add(double a, double b) {
        return a + b;
    }
    static double subtract(double a, double b) {
        return a - b;
    }
    static double multiply(double a, double b) {
        return a * b;
    }
    static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        int choice = sc.nextInt();
        System.out.println("Enter first number:");
        double num1 = sc.nextDouble();
        System.out.println("Enter second number:");
        double num2 = sc.nextDouble();

        double result = 0;

        switch (choice) {
            case 1:
                result = add(num1, num2);
                break;
            case 2:
                result = subtract(num1, num2);
                break;
            case 3:
                result = multiply(num1, num2);
                break;
            case 4:
                try {
                    result = divide(num1, num2);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    sc.close();
                    return;
                }
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        System.out.println("Result: " + result);
        sc.close();
    }
}
