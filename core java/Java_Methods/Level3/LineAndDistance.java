package Java_Methods.Level3;

import java.util.Scanner;

public class LineAndDistance { 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1 and y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2 and y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        double[] lineEquation = calculateLineEquation(x1, y1, x2, y2);

        System.out.printf("Euclidean Distance = %.4f\n", distance);
        if (Double.isInfinite(lineEquation[0])) {
            System.out.println("The line is vertical: x = " + x1);
        } else {
            System.out.printf("Equation of the line: y = %.4fx + %.4f\n", lineEquation[0], lineEquation[1]);
        }
    }

    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double m, b;
        if (x2 - x1 == 0) {
            return new double[] { Double.POSITIVE_INFINITY, Double.NaN };
        }
        m = (y2 - y1) / (x2 - x1);
        b = y1 - m * x1;
        return new double[] { m, b };
    }
}

