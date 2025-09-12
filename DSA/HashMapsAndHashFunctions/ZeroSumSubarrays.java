package HashMapsAndHashFunctions;

import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        // Map to store the prefix sum and list of indices where that sum occurs
        Map<Integer, List<Integer>> map = new HashMap<>();

        // List to store the resulting subarray index pairs
        List<int[]> result = new ArrayList<>();

        int sum = 0; 

        // Add initial sum = 0 at index -1 to handle subarrays starting from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update the cumulative sum

            // If this sum has been seen before, then subarrays with zero sum exist
            if (map.containsKey(sum)) {
                // For each previous index with the same sum,
                // the subarray from (prev_index + 1) to current index has sum = 0
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }

            // Store the current index in the map for this sum
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2, 5, 1};

        List<int[]> subarrays = findZeroSumSubarrays(arr);

        for (int[] sub : subarrays) {
            System.out.println("Subarray found from index " + sub[0] + " to " + sub[1]);
        }
    }
}
