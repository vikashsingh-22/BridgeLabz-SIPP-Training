package ControlFlow.Level2;

import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age and height: ");
        int age1 = sc.nextInt();
        int height1 = sc.nextInt();

        System.out.print("Enter Akbar's age and height: ");
        int age2 = sc.nextInt();
        int height2 = sc.nextInt();

        System.out.print("Enter Anthony's age and height: ");
        int age3 = sc.nextInt();
        int height3 = sc.nextInt();

        String youngest;
        int minAge = Math.min(age1, Math.min(age2, age3));
        if (minAge == age1) youngest = "Amar";
        else if (minAge == age2) youngest = "Akbar";
        else youngest = "Anthony";

        String tallest;
        int maxHeight = Math.max(height1, Math.max(height2, height3));
        if (maxHeight == height1) tallest = "Amar";
        else if (maxHeight == height2) tallest = "Akbar";
        else tallest = "Anthony";

        System.out.println("Youngest friend is: " + youngest);
        System.out.println("Tallest friend is: " + tallest);

        sc.close();
    }
}

