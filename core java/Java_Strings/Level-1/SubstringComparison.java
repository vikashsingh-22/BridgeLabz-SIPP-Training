import java.util.Scanner;

public class SubstringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String manualSubstring = createSubstring(original, start, end);
        String builtInSubstring = original.substring(start, end);
        boolean areEqual = compareStrings(manualSubstring, builtInSubstring);
        System.out.println("Manual Substring using charAt(): " + manualSubstring);
        System.out.println("Built-in Substring: " + builtInSubstring);
        System.out.println("Are both substrings equal? " + areEqual);
    }

    public static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < str.length(); i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
