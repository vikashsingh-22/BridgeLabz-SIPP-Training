// Problem Statement:
// A school maintains student marks in an array. Implement Bubble Sort to sort the student marks in ascending order.
// Hint:
// Traverse through the array multiple times.
// Compare adjacent elements and swap if needed.
// Repeat the process until no swaps are required.

package SortingAlgorithms.Bubblesort;

public class StudentMarks {
    public static void main(String[] args) {
        int[] marks = {85, 70, 95, 60, 80, 90};
        bubbleSort(marks);
        
        System.out.println("Sorted student marks:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Traverse through all elements in the array
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if elements are in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }
    
}
