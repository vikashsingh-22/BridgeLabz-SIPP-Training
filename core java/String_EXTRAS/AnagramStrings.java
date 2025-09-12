package String_EXTRAS;

import java.util.Scanner;

public class AnagramStrings{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println("Are Anagrams? " + areAnagrams(str1, str2));
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int[] count = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
