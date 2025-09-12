import java.util.Scanner;

public class CustomStringSplit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[] customSplit = splitTextWithoutSplit(input);
        String[] builtInSplit = input.split(" ");

        System.out.println("Custom Split Output:");
        for (String word : customSplit) {
            System.out.println(word);
        }

        System.out.println("Built-in Split Output:");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        boolean areEqual = compareStringArrays(customSplit, builtInSplit);
        System.out.println("Are both splits equal? " + areEqual);
    }
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }
    public static String[] splitTextWithoutSplit(String str) {
        int length = getLength(str);
        int spaceCount = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount + 2];
        spaceIndexes[0] = -1;
        int idx = 1;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        spaceIndexes[idx] = length;

        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            int start = spaceIndexes[i] + 1;
            int end = spaceIndexes[i + 1];
            StringBuilder word = new StringBuilder();
            for (int j = start; j < end; j++) {
                word.append(str.charAt(j));
            }
            words[i] = word.toString();
        }

        return words;
    }
    public static boolean compareStringArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }
}
