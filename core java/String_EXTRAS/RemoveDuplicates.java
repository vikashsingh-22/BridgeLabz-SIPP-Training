package String_EXTRAS;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Without Duplicates: " + removeDuplicates(str));
    }

    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256];
        for (char c : str.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }
        return result.toString();
    }
}
