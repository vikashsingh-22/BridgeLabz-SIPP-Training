package ControlFlow.Level3;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year (>=1582): ");
        int year = scanner.nextInt();

        if (year < 1582) {
            System.out.println("Year must be 1582 or later (Gregorian calendar).");
            
        }

        

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " is a Leap Year (Version 2)");
        } else {
            System.out.println(year + " is not a Leap Year (Version 2)");
        }

        scanner.close();
    }
}
