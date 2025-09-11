package collectors;

import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        System.out.println("2. Word Frequency Counter");

        String paragraph = "the quick brown fox jumps over the lazy dog the quick fox";

        // Splits the paragraph into words, converts them to lowercase, and then uses
        // Collectors.toMap() to count the frequency of each word.
        Map<String, Long> wordFrequencies = Arrays.stream(paragraph.split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.toMap(
                        // The key is the word itself.
                        Function.identity(),
                        // The initial value for a new word is 1.
                        word -> 1L,
                        // The merge function adds the counts for duplicate keys.
                        Long::sum
                ));

        System.out.println("Word frequencies: " + wordFrequencies);
    }
}
