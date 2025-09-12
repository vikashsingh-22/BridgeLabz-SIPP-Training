package AlgorithmRuntime;

public class FibonacciComparison {

    public static void main(String[] args) {
        int[] testValues = {10, 30, 40, 45};

        for (int n : testValues) {
            System.out.println("\nFibonacci Number for n = " + n);

            // Recursive
            if (n <= 45) {
                long startRec = System.currentTimeMillis();
                int fibRec = fibonacciRecursive(n);
                long endRec = System.currentTimeMillis();
                System.out.println("Recursive: " + fibRec + " (Time: " + (endRec - startRec) + " ms)");
            } else {
                System.out.println("Recursive: Unfeasible for large n");
            }

            // Iterative
            long startItr = System.currentTimeMillis();
            int fibItr = fibonacciIterative(n);
            long endItr = System.currentTimeMillis();
            System.out.println("Iterative: " + fibItr + " (Time: " + (endItr - startItr) + " ms)");
        }
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
