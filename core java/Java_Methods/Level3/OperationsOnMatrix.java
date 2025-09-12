package Java_Methods.Level3;
import java.util.*;

public class OperationsOnMatrix {
   

    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10);
        return matrix;
    }

    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] - b[i][j];
        return result;
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int common = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < common; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    public static void printMatrix(String message, int[][] matrix) {
        System.out.println(message);
        for (int[] row : matrix) {
            for (int elem : row)
                System.out.print(elem + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows for matrices A and B: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns for matrices A and B: ");
        int cols = sc.nextInt();

        int[][] matrixA = createRandomMatrix(rows, cols);
        int[][] matrixB = createRandomMatrix(rows, cols);

        printMatrix("Matrix A:", matrixA);
        printMatrix("Matrix B:", matrixB);

        int[][] sum = addMatrices(matrixA, matrixB);
        printMatrix("Sum (A + B):", sum);

        int[][] diff = subtractMatrices(matrixA, matrixB);
        printMatrix("Difference (A - B):", diff);

        System.out.print("Enter number of columns for matrix B (for multiplication): ");
        int multCols = sc.nextInt();
        int[][] matrixBForMultiplication = createRandomMatrix(cols, multCols);

        printMatrix("Matrix B for multiplication:", matrixBForMultiplication);

        int[][] product = multiplyMatrices(matrixA, matrixBForMultiplication);
        printMatrix("Product (A x B):", product);
    }
}


