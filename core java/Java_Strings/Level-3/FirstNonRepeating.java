import java.util.Scanner;

public class FirstNonRepeating {
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256]; 
        for (int i = 0;; i++) {
            try {
                char ch = text.charAt(i);
                freq[ch]++;
            } catch (Exception e) {
                break; 
            }
        }

        for (int i = 0;; i++) {
            try {
                char ch = text.charAt(i);
                if (freq[ch] == 1) {
                    return ch;
                }
            } catch (Exception e) {
                break;
            }
        }

        return '\0'; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
