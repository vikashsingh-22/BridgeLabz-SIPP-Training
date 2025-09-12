import java.util.Scanner;

public class FrequencyWithUniqueCharacters {

    public static char[] uniqueCharacters(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (Exception e) {}

        char[] unique = new char[len];
        int count = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[count++] = ch;
            }
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    public static String[][] charFrequencies(String text) {
        int[] freq = new int[256];

        for (int i = 0;; i++) {
            try {
                char ch = text.charAt(i);
                freq[ch]++;
            } catch (Exception e) {
                break;
            }
        }

        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[][] frequencies = charFrequencies(input);

        System.out.println("Character\tFrequency");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i][0] + "\t\t" + frequencies[i][1]);
        }
    }
}
