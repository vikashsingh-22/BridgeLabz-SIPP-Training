import java.util.Scanner;

public class NestedTryCatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.print("Enter array index (0–4): ");
        int index = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        try {
            try {
                int value = numbers[index];
                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}
