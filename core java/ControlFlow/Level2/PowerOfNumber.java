package ControlFlow.Level2;

import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the base number: ");
        int number = sc.nextInt();
        
        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        if (power >= 0) {
            int result = 1;
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println(number + " raised to the power " + power + " is: " + result);
        } else {
            System.out.println("Power must be a non-negative integer.");
        }

        sc.close();
    }
}
