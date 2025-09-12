import java.util.Scanner;

public class NaturalSumforLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid input. Not a natural number.");
            return;
        }

        int formulaSum = n * (n + 1) / 2;

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Sum using for loop: " + sum);

        if (sum == formulaSum)
            System.out.println("Both results match!");
        else
            System.out.println(" Results do not match.");
    }
}

