package String_EXTRAS;

import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Most Frequent Character: '" + mostFrequentChar(str) + "'");
    }

    public static char mostFrequentChar(String str) {
        int[] freq = new int[256];
        for (char c : str.toCharArray()) {
            freq[c]++;
        }
        int max = 0;
        char result = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                result = (char) i;
            }
        }
        return result;
    }
}

