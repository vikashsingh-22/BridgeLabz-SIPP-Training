// Merge Sort - Sort an Array of Book Prices
// Problem Statement:
// A bookstore maintains a list of book prices in an array. Implement Merge Sort to sort the prices in ascending order.
// Hint:
// Divide the array into two halves recursively.
// Sort both halves individually.
// Merge the sorted halves by comparing elements.

package SortingAlgorithms.MergeSort;

public class BookPriceSorter {

    public static void main(String[] args) {
        double[] prices = {499.99, 299.50, 199.99, 799.00, 599.25};

        System.out.println("Original Book Prices:");
        printArray(prices);

        mergeSort(prices, 0, prices.length - 1);

        System.out.println("\nSorted Book Prices (Ascending):");
        printArray(prices);
    }

    // Recursively divides the array and sorts each half
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);       // Sort left half
            mergeSort(arr, mid + 1, right);  // Sort right half

            merge(arr, left, mid, right);    // Merge sorted halves
        }
    }

    // Merges two sorted subarrays into a single sorted segment
    public static void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge elements from both arrays in sorted order
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy any remaining elements from left array
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copy any remaining elements from right array
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // Prints the elements of the array
    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}


