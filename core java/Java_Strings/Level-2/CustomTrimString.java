import java.util.Scanner;

public class CustomTrimString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] trimIndexes = getTrimIndexes(input);
        String customTrimmed = customSubstring(input, trimIndexes[0], trimIndexes[1]);
        String builtinTrimmed = input.trim();
        System.out.println("\nCustom Trimmed String: \"" + customTrimmed + "\"");
        System.out.println("Built-in Trimmed String: \"" + builtinTrimmed + "\"");
        boolean isEqual = compareStrings(customTrimmed, builtinTrimmed);
        System.out.println("\nDo both strings match? " + isEqual);
    }

    public static int[] getTrimIndexes(String str) {
        int start = 0;
        int end = 0;
        int length = 0;
        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
            end = length - 1;
        }
        while (start < length && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String customSubstring(String str, int start, int end) {
        StringBuilder result = new StringBuilder();

        for (int i = start; i <= end; i++) {
            result.append(str.charAt(i));
        }

        return result.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        int len1 = 0, len2 = 0;
        try {
            while (true) s1.charAt(len1++);
        } catch (IndexOutOfBoundsException e) {}
        try {
            while (true) s2.charAt(len2++);
        } catch (IndexOutOfBoundsException e) {}
        if (len1 != len2) return false;

        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
