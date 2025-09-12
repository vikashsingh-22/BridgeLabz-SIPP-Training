package LinearandBinarySearch.FileReader;

import java.io.*;

public class WordCountInFile {
    public static void main(String[] args) {
        String targetWord = "java"; // word to count
        int count = 0;

        try {
            FileReader fr = new FileReader("input.txt"); // read from file
            BufferedReader br = new BufferedReader(fr);  // efficient reading

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // split line into words
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { // case-insensitive match
                        count++;
                    }
                }
            }

            br.close(); // close resources
            fr.close();

            System.out.println("The word \"" + targetWord + "\" appears " + count + " times.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
