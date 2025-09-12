package ControlFlow.Level3;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in centimeters: ");
        double heightCm = scanner.nextDouble();

        double heightMeters = heightCm / 100; 
        double bmi = weight / (heightMeters * heightMeters);

        System.out.printf("Your BMI is: %.2f\n", bmi);

        if (bmi < 18.5) {
            System.out.println("You are Underweight.");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("You have Normal weight.");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("You are Overweight.");
        } else {
            System.out.println("You are Obese.");
        }

        scanner.close();
    }
}

