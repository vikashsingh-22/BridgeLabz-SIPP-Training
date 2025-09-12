import java.util.Scanner;

public class WordMinMaxLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[] words = splitTextIntoWords(input);
        String[][] wordLengthArray = getWordLengthArray(words);
        int[] minMaxIndexes = findShortestAndLongest(wordLengthArray);

        System.out.println("\nWord\tLength");
        System.out.println("---------------");
        for (int i = 0; i < wordLengthArray.length; i++) {
            int len = Integer.parseInt(wordLengthArray[i][1]);
            System.out.println(wordLengthArray[i][0] + "\t" + len);
        }

        System.out.println("\nShortest word: " + wordLengthArray[minMaxIndexes[0]][0]);
        System.out.println("Longest word: " + wordLengthArray[minMaxIndexes[1]][0]);
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

    public static String[] splitTextIntoWords(String str) {
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

    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordLengthArray) {
        int minIndex = 0, maxIndex = 0;
        int minLength = Integer.parseInt(wordLengthArray[0][1]);
        int maxLength = minLength;

        for (int i = 1; i < wordLengthArray.length; i++) {
            int length = Integer.parseInt(wordLengthArray[i][1]);
            if (length < minLength) {
                minLength = length;
                minIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            }
        }

        return new int[] { minIndex, maxIndex };
    }
}
