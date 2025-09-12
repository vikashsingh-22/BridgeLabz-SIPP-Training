package ControlFlow.Level3;

import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check if it is a Harshad number: ");
        int number = sc.nextInt();

        int original = number;
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        if (original % sum == 0) {
            System.out.println(original + " is a Harshad Number.");
        } else {
            System.out.println(original + " is NOT a Harshad Number.");
        }

        sc.close();
    }
}
