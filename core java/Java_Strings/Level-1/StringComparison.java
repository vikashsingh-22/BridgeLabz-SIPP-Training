import java.util.*;
public class StringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();
        boolean customCompare = compareStrings(str1, str2);
        boolean builtInCompare = str1.equals(str2);
        if (customCompare == builtInCompare) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("Mismatch between custom and built-in methods.");
        }
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
