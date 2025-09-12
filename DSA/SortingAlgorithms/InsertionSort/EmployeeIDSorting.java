
// Problem Statement:
// A company stores employee IDs in an unsorted array. Implement Insertion Sort to sort the employee IDs in ascending order.
// Hint:
// Divide the array into sorted and unsorted parts.
// Pick an element from the unsorted part and insert it into its correct position in the sorted part.
// Repeat for all elements.
package SortingAlgorithms.InsertionSort;

public class EmployeeIDSorting {
    public static void main(String[] args) {
        int[] employeeIDs = {102, 105, 101, 104, 103};
        insertionSort(employeeIDs);
        
        System.out.println("Sorted Employee IDs:");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
    }
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for(int i=1;i<n;i++){
            int j = i;
            
            while(j>0 && employeeIDs[j-1]>employeeIDs[j]){
                // Swap arr[j] and arr[j-1]
                int temp = employeeIDs[j];
                employeeIDs[j] = employeeIDs[j-1];
                employeeIDs[j-1] = temp;
                j--;
            }
        }
    }
}

        

