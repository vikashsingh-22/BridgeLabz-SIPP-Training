package AlgorithmRuntime;

import java.util.*;

public class SearchDataStructureComparison {

    public static void main(String[] args) {
        int[] sizes = {1000, 100_000, 1_000_000};
        Random rand = new Random();

        for (int size : sizes) {
            int target = rand.nextInt(size); // random target to search

            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            System.out.println("\nDataset Size: " + size + " | Target: " + target);

            // Array search (Linear)
            long startArray = System.nanoTime();
            boolean foundInArray = linearSearch(array, target);
            long endArray = System.nanoTime();
            System.out.println("Array Search: " + (endArray - startArray) / 1_000_000.0 + " ms");
                        System.out.println("**************************************************************************");
System.out.println();

            // HashSet search
            long startHash = System.nanoTime();
            boolean foundInHash = hashSet.contains(target);
            long endHash = System.nanoTime();
            System.out.println("HashSet Search: " + (endHash - startHash) / 1_000_000.0 + " ms");
            System.out.println("**************************************************************************");
            System.out.println();

            // TreeSet search
            long startTree = System.nanoTime();
            boolean foundInTree = treeSet.contains(target);
            long endTree = System.nanoTime();
            System.out.println("TreeSet Search: " + (endTree - startTree) / 1_000_000.0 + " ms");
        }
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}
