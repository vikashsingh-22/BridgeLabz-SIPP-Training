import java.util.Scanner;
public class IllegalArgumentDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();
        handleException(input);
        scanner.close();
    }

    public static void generateException(String text) {
        String result = text.substring(5, 2);  
        System.out.println("Generated substring: " + result);
    }

    public static void handleException(String text) {
        try {
            String result = text.substring(5, 2);  
            System.out.println("Generated substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
