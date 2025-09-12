package ControlFlow.Level2;

import java.util.Scanner;

public class GreatestFactorWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();
        int greatestFactor = 1;

        if (number > 1) {
            int counter = number - 1;
            while (counter >= 1) {
                if (number % counter == 0) {
                    greatestFactor = counter;
                    break;
                }
                counter--;
            }
            System.out.println("Greatest factor (excluding itself) is: " + greatestFactor);
        } else {
            System.out.println("No proper factors for number " + number);
        }

        sc.close();
    }
}
