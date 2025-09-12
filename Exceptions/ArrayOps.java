import java.util.Scanner;

public class ArrayOps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;

        try {
            array = new int[]{10, 20, 30, 40, 50};

            System.out.print("Enter the index to retrieve: ");
            int index = scanner.nextInt();
            
            int value = array[index];
            System.out.println("Value at index " + index + ": " + value);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
