import java.util.Scanner;
public class StringToCharArrayComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        char[] customChars = getChars(input);
        char[] builtInChars = input.toCharArray();
        boolean areEqual = compareCharArrays(customChars, builtInChars);
        System.out.print("Custom char array: ");
        printCharArray(customChars);
        System.out.print("Built-in char array: ");
        printCharArray(builtInChars);
        System.out.println("Are both character arrays equal? " + areEqual);
    }

    public static char[] getChars(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    public static void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
