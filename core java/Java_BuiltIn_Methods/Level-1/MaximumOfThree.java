import java.util.Scanner;

public class MaximumOfThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = takeInput(scanner, "Enter the first number: ");
        int num2 = takeInput(scanner, "Enter the second number: ");
        int num3 = takeInput(scanner, "Enter the third number: ");

        int max = findMaximum(num1, num2, num3);

        System.out.println("The maximum of the three numbers is: " + max);

        scanner.close();
    }

    public static int takeInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}
