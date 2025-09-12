package AlgorithmRuntime;

import java.util.*;

public class SortingPerformanceComparison {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            System.out.println("\nDataset Size: " + size);

            int[] original = generateRandomArray(size);

            // Bubble Sort
            if (size <= 10000) { // Skip for large data
                int[] bubbleArray = Arrays.copyOf(original, original.length);
                long start = System.currentTimeMillis();
                bubbleSort(bubbleArray);
                long end = System.currentTimeMillis();
                System.out.println("Bubble Sort Time: " + (end - start) + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible (>1 hr)");
            }

            // Merge Sort
            int[] mergeArray = Arrays.copyOf(original, original.length);
            long startMerge = System.currentTimeMillis();
            mergeSort(mergeArray, 0, mergeArray.length - 1);
            long endMerge = System.currentTimeMillis();
            System.out.println("Merge Sort Time: " + (endMerge - startMerge) + " ms");

            // Quick Sort
            int[] quickArray = Arrays.copyOf(original, original.length);
            long startQuick = System.currentTimeMillis();
            quickSort(quickArray, 0, quickArray.length - 1);
            long endQuick = System.currentTimeMillis();
            System.out.println("Quick Sort Time: " + (endQuick - startQuick) + " ms");
        }
    }

    // Bubble Sort - O(N²)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort - O(N log N)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    // Quick Sort - O(N log N) average case
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Last element as pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Generate random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(1_000_000);
        return arr;
    }
}
