package ControlFlow.Level2;

import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            System.out.println("Multiples of " + number + " below 100 are:");
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Invalid input. Number must be > 0 and < 100.");
        }

    }
}
