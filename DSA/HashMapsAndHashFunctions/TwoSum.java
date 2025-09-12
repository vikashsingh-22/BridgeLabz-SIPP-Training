package HashMapsAndHashFunctions;
import java.util.*;

public class TwoSum {

    // Returns indices of the two numbers that add up to the target
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current number with its index
            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // If no valid pair is found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]); // Output: 0, 1
    }
}
// This code defines a method `twoSum` that finds two indices in an array such that the numbers at those indices add up to a given target.
// It uses a HashMap to store the numbers and their indices, allowing for efficient lookups.
// The main method demonstrates how to use the `twoSum` function with an example array and target value.
// If a valid pair is found, it returns their indices; otherwise, it returns `-1, -1` to indicate no valid pair exists.
// The time complexity is O(n) due to the single pass through the array, and the space complexity is also O(n) for storing the elements in the HashMap.
// This implementation is efficient and straightforward, making it suitable for solving the Two Sum problem in competitive programming and interviews.
