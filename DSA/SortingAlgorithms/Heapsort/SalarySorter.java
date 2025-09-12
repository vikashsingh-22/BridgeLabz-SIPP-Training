package SortingAlgorithms.Heapsort;

public class SalarySorter {

    public static void main(String[] args) {
        int[] salaries = {55000, 45000, 75000, 60000, 50000};

        System.out.println("Original Salary Demands:");
        printArray(salaries);

        heapSort(salaries);

        System.out.println("\nSorted Salary Demands (Ascending):");
        printArray(salaries);
    }

    // Sorts the array using Heap Sort algorithm
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);           // Move current root to end
            heapify(arr, i, 0);        // Restore max heap property on reduced heap
        }
    }

    // Maintains max heap property for subtree rooted at index i
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;               // Initialize largest as root
        int left = 2 * i + 1;          // Left child
        int right = 2 * i + 2;         // Right child

        // Check if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int salary : arr) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }
}

