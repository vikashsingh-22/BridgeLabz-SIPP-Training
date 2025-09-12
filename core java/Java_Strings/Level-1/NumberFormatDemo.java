import java.util.Scanner;

public class NumberFormatDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        handleException(input);
    }

    public static void generateException(String text) {
        int number = Integer.parseInt(text); 
        System.out.println("Parsed number: " + number);
    }

    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text); 
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
