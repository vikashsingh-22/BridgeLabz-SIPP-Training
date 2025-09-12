import java.util.Scanner;
public class LowerCaseCompare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String input = scanner.nextLine();
        String builtInLower = input.toLowerCase();
        String customLower = convertToLower(input);
        boolean isEqual = compareStrings(builtInLower, customLower);
        System.out.println("Built-in Lowercase: " + builtInLower);
        System.out.println("Custom Lowercase:   " + customLower);
        System.out.println("Are both lowercase versions equal? " + isEqual);
        scanner.close();
    }

    public static String convertToLower(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
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
