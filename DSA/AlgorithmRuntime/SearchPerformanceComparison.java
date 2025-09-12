package AlgorithmRuntime;


import java.util.Arrays;
import java.util.Random;

public class SearchPerformanceComparison {

    // Linear Search: O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search: O(log N), array must be sorted
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Generate array with random integers
    public static int[] generateDataset(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 2);
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        int target = -1; // target not present to simulate worst case

        for (int size : sizes) {
            int[] data = generateDataset(size);

            // Measure Linear Search time
            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long timeLinear = System.nanoTime() - startLinear;

            // Sort and measure Binary Search time
            Arrays.sort(data);
            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long timeBinary = System.nanoTime() - startBinary;

            // Print results
            System.out.println("Dataset size: " + size);
            System.out.println("Linear Search: " + timeLinear / 1e6 + " ms");
            System.out.println("Binary Search: " + timeBinary / 1e6 + " ms\n");
        }
    }
}
