package String_EXTRAS;

import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        String sub = sc.nextLine();
        System.out.println("Occurrences of '" + sub + "': " + countSubstringOccurrences(str, sub));
    }

    public static int countSubstringOccurrences(String str, String sub) {
        int count = 0;
        for (int i = 0; i <= str.length() - sub.length(); i++) {
            if (str.substring(i, i + sub.length()).equals(sub))
                count++;
        }
        return count;
    }
}

