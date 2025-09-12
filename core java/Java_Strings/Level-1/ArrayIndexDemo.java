import java.util.Scanner;

public class ArrayIndexDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Alice", "Bob", "Charlie", "David"};
        System.out.print("Enter the index to access (0 to " + (names.length - 1) + "): ");
        int index = sc.nextInt();
        handleException(names, index);
    }

    public static void generateException(String[] array, int index) {
        System.out.println("Accessed name: " + array[index]);
    }

    public static void handleException(String[] array, int index) {
        try {
            System.out.println("Accessed name: " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
