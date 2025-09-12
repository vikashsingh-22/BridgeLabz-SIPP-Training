import java.util.Scanner;

public class FactorialRecursive {

    public static void main(String[] args) {
        int number = takeInput();
        long result = calculateFactorial(number);
        displayResult(number, result);
    }

    static int takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    static long calculateFactorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * calculateFactorial(n - 1);
    }

    static void displayResult(int number, long result) {
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
