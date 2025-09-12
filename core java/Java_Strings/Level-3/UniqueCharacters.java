import java.util.Scanner;
public class UniqueCharacters {

    public static int getLength(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (Exception e) {
        }
        return length;
    }

    public static char[] findUniqueCharacters(String text) {
        int len = getLength(text);
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
                unique[count] = ch;
                count++;
            }
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        char[] uniqueChars = findUniqueCharacters(input);
        System.out.println("Unique characters in the string:");
        for (int i = 0; i < getLength(new String(uniqueChars)); i++) {
            System.out.print(uniqueChars[i] + " ");
        }
    }
}
