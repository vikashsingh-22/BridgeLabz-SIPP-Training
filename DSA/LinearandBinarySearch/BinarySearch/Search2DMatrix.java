package LinearandBinarySearch.BinarySearch;


public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;

        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };

        int target = 16;
        boolean found = searchMatrix(matrix, target);
        System.out.println("Target " + target + (found ? " found." : " not found."));
    }
}
