package SortingAlgorithms.CountingSort;

public class StudentAgeSorter {

    public static void main(String[] args) {
        int[] ages = {15, 12, 18, 10, 14, 12, 13, 17, 11, 10};
        

        System.out.println("Original Student Ages:");
        printArray(ages);

        countingSort(ages, 10, 18);  // Age range is 10 to 18

        System.out.println("\nSorted Student Ages (Ascending):");
        printArray(ages);
    }
    public static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int age : arr) {
            count[age - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements into output array based on cumulative count
        for (int i = arr.length - 1; i >= 0; i--) {
            int age = arr[i];
            output[count[age - min] - 1] = age;
            count[age - min]--;
        }

        // Copy sorted result back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

   
    public static void printArray(int[] arr) {
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }
}