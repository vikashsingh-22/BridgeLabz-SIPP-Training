package Arrays_Practices.Level1;

import java.util.Scanner;

public class Even_odd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                System.out.println("Number " + nums[i] + " is positive");
                if (nums[i] % 2 == 0) {
                    System.out.println("Number is even");
                } else {
                    System.out.println("Number is odd");
                }
            } else if (nums[i] < 0) {
                System.out.println("Number " + nums[i] + " is negative");
            } else {
                System.out.println("Number is zero");
            }
        }

        if (nums[0] > nums[nums.length - 1]) {
            System.out.println("Number at index 0 is greater than number at index " + (nums.length - 1));
        } else if (nums[0] < nums[nums.length - 1]) {
            System.out.println("Number at index 0 is smaller than number at index " + (nums.length - 1));
        } else {
            System.out.println("Number at index 0 is equal to number at index " + (nums.length - 1));
        }

        sc.close();
    }
}
