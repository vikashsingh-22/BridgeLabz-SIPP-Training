package HashMapsAndHashFunctions;

import java.util.*;

public class LongestConsecutiveSequence {

    // Returns the length of the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            // Only start a sequence if 'num - 1' is not in the set
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(nums);
        System.out.println("Length of longest consecutive sequence: " + result);
    }
}
