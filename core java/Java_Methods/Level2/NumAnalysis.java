package Java_Methods.Level2;

import java.util.Scanner;

public class NumAnalysis {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        if (num1 < num2) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.println("Number " + numbers[i] + " is Positive and Even.");
                } else {
                    System.out.println("Number " + numbers[i] + " is Positive and Odd.");
                }
            } else {
                System.out.println("Number " + numbers[i] + " is Negative.");
            }
        }

        int result = compare(numbers[0], numbers[4]);
        if (result == 1) {
            System.out.println("First element is greater than last element.");
        } else if (result == -1) {
            System.out.println("First element is less than last element.");
        } else {
            System.out.println("First and last elements are equal.");
        }

        sc.close();
    }
}
