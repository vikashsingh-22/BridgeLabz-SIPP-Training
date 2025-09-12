import java.util.*;

public class SlidingWindowMaximum {

    // Method to find maximum in each sliding window of size k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // Edge case: if input array is null or window size is 0, return empty array
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store maximums for each window
        Deque<Integer> deque = new ArrayDeque<>(); // Stores indices of elements in current window

        for (int i = 0; i < n; i++) {

            // Step 1: Remove indices that are outside the current window
            // If the index at the front is out of this window's range, remove it
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Step 2: Maintain decreasing order in deque
            // Remove indices from the back whose corresponding values are less than current value
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Step 3: Add current element's index to the deque
            deque.offerLast(i);

            // Step 4: Once the first full window is traversed, start recording max values
            // The maximum value in the current window is at the front of the deque
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        
        System.out.println(Arrays.toString(result)); // Output: [3, 3, 5, 5, 6, 7]
    }
}
