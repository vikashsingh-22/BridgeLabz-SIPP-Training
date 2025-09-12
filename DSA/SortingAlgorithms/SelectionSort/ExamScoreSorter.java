package SortingAlgorithms.SelectionSort;

public class ExamScoreSorter {

    public static void main(String[] args) {
        int[] scores = {85, 72, 96, 60, 78};

        System.out.println("Original Exam Scores:");
        printArray(scores);

        selectionSort(scores);

        System.out.println("\nSorted Exam Scores (Ascending):");
        printArray(scores);
    }

    // Sorts the array using Selection Sort algorithm
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find index of the minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first unsorted element
            swap(arr, i, minIndex);
        }
    }

    // Swaps two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Prints elements of the array
    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}

