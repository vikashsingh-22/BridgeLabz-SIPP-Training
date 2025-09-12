package Arrays_Practices.Level1;

import java.util.Scanner;

public class MatrixToArrayConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] array = new int[rows * cols];
        int index = 0;

        System.out.println("Enter the elements of the 2D matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
                array[index++] = matrix[i][j];
            }
        }

        System.out.print("1D Array: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}

