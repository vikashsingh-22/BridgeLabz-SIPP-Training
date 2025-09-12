package String_EXTRAS;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

            System.out.println(str + " is palindrome? " + isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) == str.charAt(right--))
                return true;
        }
        return false;
    }
}

