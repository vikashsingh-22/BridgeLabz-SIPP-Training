import java.util.Scanner;
public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        if (number < 0) {
            System.out.println("enter a positive number.");
            return;
        }
        int[] frequency = new int[10];
        int[] digits = new int[20];
        int index = 0;
        while (number != 0) {
            int digit = (int)(number % 10);
            digits[index++] = digit;
            frequency[digit]++;
            number /= 10;
        }
        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
    }
}
