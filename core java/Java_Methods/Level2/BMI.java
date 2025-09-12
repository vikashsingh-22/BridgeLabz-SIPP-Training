package Java_Methods.Level2;

import java.util.Scanner;

public class BMI {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double heightMeters = data[i][1] / 100;
            double bmi = data[i][0] / (heightMeters * heightMeters);
            data[i][2] = bmi;
        }
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                status[i] = "Overweight Range";
            } else {
                status[i] = "Obese Range";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] persons = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            persons[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            persons[i][1] = sc.nextDouble();
        }

        calculateBMI(persons);
        String[] bmiStatus = getBMIStatus(persons);

        System.out.println("\nPerson\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n", i + 1, persons[i][0], persons[i][1], persons[i][2], bmiStatus[i]);
        }

        sc.close();
    }
}

