package Java_Methods.Level3;

import java.util.Scanner;

public class NumberChecker {

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

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;
        for (int f : freq) {
            if (f > 0) count++;
        }

        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = getDigitsArray(number);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        int digitCount = countDigits(number);
        int sum = sumOfDigits(digits);
        int squareSum = sumOfSquares(digits);
        boolean isHarshad = isHarshadNumber(number, digits);
        int[][] freq = digitFrequency(digits);

        System.out.println("Total Digits: " + digitCount);
        System.out.println("Sum of Digits: " + sum);
        System.out.println("Sum of Squares of Digits: " + squareSum);
        System.out.println("Is Harshad Number: " + isHarshad);

        System.out.println("Digit Frequencies:");
        for (int[] row : freq) {
            System.out.println("Digit: " + row[0] + ", Frequency: " + row[1]);
        }
    }
}

