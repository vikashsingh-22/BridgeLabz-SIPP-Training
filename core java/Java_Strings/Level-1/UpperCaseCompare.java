import java.util.Scanner;
public class UpperCaseCompare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String input = sc.nextLine();
        String builtInUpper = input.toUpperCase();
        String customUpper = convertToUpper(input);
        boolean isEqual = compareStrings(builtInUpper, customUpper);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Custom Uppercase:   " + customUpper);
        System.out.println("Are both uppercase versions equal? " + isEqual);
    }

    public static String convertToUpper(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
