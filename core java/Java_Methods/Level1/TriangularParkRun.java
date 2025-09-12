package Java_Methods.Level1;

import java.util.Scanner;

public class TriangularParkRun {

    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first side of the triangle (in meters): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter the second side of the triangle (in meters): ");
        double side2 = sc.nextDouble();

        System.out.print("Enter the third side of the triangle (in meters): ");
        double side3 = sc.nextDouble();

        double rounds = calculateRounds(side1, side2, side3);

        System.out.printf("The athlete needs to complete %.2f rounds to run 5 km.\n", rounds);

        sc.close();
    }
}
