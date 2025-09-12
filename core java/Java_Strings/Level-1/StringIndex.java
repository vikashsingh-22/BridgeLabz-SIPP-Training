import java.util.Scanner;
public class StringIndex{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.next();
        handleException(input);

        scanner.close();
    }

    public static void generateException(String text) {
        System.out.println("Character at invalid index: " + text.charAt(text.length()));
    }
    public static void handleException(String text) {
        try {
            System.out.println("Character at invalid index: " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
