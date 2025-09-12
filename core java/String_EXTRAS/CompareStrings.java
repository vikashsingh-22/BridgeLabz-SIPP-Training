package String_EXTRAS;

import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(compareStrings(str1, str2));
    }

    public static String compareStrings(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return (str1.charAt(i) < str2.charAt(i)) ? str1 + " comes before " + str2
                        : str2 + " comes before " + str1;
            }
        }
        return (str1.length() < str2.length()) ? str1 + " comes before " + str2
                : (str1.equals(str2) ? "Strings are equal" : str2 + " comes before " + str1);
    }
}

