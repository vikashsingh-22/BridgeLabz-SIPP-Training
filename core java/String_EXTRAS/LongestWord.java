package String_EXTRAS;

import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String sentence = sc.nextLine();
        System.out.println("Longest Word: " + findLongestWord(sentence));
    }

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length())
                longest = word;
        }
        return longest;
    }
}
