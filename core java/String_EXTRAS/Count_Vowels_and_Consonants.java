package String_EXTRAS;

import java.util.Scanner;

public class Count_Vowels_and_Consonants{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        countVowelsAndConsonants(str);
    }


public static void countVowelsAndConsonants(String str) {
    int vowels = 0, consonants = 0;
    str = str.toLowerCase();
    for (char c : str.toCharArray()) {
        if (Character.isLetter(c)) {
            if ("aeiou".indexOf(c) != -1)
                vowels++;
            else
                consonants++;
        }
    }
    System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
}
}

