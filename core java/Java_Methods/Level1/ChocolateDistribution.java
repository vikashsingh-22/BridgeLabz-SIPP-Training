package Java_Methods.Level1;

import java.util.Scanner;

public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = sc.nextInt();
        System.out.print("Enter number of children: ");
        int numberOfChildren = sc.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        System.out.println("Each child gets: " + result[1] + " chocolates");
        System.out.println("Remaining chocolates: " + result[0]);
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int remainder = number % divisor;
        int quotient = number / divisor;
        return new int[]{remainder, quotient};
    }
}
