import java.util.Scanner;

public class AnagramChecker {

    public static boolean areAnagrams(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();

        text1 = text1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        text2 = text2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean result = areAnagrams(text1, text2);

        if (result) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are not anagrams.");
        }
    }
}
