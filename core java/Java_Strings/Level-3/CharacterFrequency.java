import java.util.Scanner;

public class CharacterFrequency {

    public static String[][] getCharFrequencies(String text) {
        int[] freq = new int[256]; 

        for (int i = 0;; i++) {
            try {
                char ch = text.charAt(i);
                freq[ch]++;
            } catch (Exception e) {
                break; 
            }
        }
        String[][] result = new String[256][2];
        boolean[] added = new boolean[256];
        int index = 0;

        for (int i = 0;; i++) {
            try {
                char ch = text.charAt(i);
                if (!added[ch]) {
                    result[index][0] = String.valueOf(ch);
                    result[index][1] = String.valueOf(freq[ch]);
                    added[ch] = true;
                    index++;
                }
            } catch (Exception e) {
                break;
            }
        }

        String[][] trimmedResult = new String[index][2];
        for (int i = 0; i < index; i++) {
            trimmedResult[i][0] = result[i][0];
            trimmedResult[i][1] = result[i][1];
        }

        return trimmedResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[][] frequencies = getCharFrequencies(input);

        System.out.println("Character\tFrequency");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i][0] + "\t\t" + frequencies[i][1]);
        }
    }
}
