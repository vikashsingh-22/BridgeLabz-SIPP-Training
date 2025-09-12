package Java_Methods.Level3;
import java.util.Scanner;
import java.util.Arrays;

public class NumberCheckerExtension {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigitsArray(int number) {
        String str = String.valueOf(number);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = getDigitsArray(number);
        int[] reversedDigits = reverseArray(digits);
        int digitCount = countDigits(number);
        boolean isPalindrome = isPalindrome(digits);
        boolean isDuck = isDuckNumber(digits);

        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed Digits: " + Arrays.toString(reversedDigits));
        System.out.println("Total Digits: " + digitCount);
        System.out.println("Is Palindrome: " + isPalindrome);
        System.out.println("Is Duck Number: " + isDuck);
    }
}
