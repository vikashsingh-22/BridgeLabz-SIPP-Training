package SortingAlgorithms.QuickSort;

public class ProductPriceSorter {

    public static void main(String[] args) {
        double[] prices = {799.99, 299.99, 999.50, 499.00, 199.25};

        System.out.println("Original Product Prices:");
        printArray(prices);

        quickSort(prices, 0, prices.length - 1);

        System.out.println("\nSorted Product Prices (Ascending):");
        printArray(prices);
    }

    // Recursively applies quick sort to left and right partitions
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);  // Partition the array
            quickSort(arr, low, pivotIndex - 1);         // Sort left partition
            quickSort(arr, pivotIndex + 1, high);        // Sort right partition
        }
    }

    // Partitions the array using the last element as pivot
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];  // Pivot element
        int i = low - 1;           // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);   // Swap if element is smaller than pivot
            }
        }

        swap(arr, i + 1, high);    // Place pivot at correct position
        return i + 1;
    }

    // Swaps two elements in the array
    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Prints the elements of the array
    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}
