package LinearandBinarySearch.StringBuilder;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";

        String result = removeDuplicates(input);

        System.out.println("String after removing duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        // To keep track of seen characters
        HashSet<Character> seen = new HashSet<>();

        // To build the final string without duplicates
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
