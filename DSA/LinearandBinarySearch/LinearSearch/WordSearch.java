package LinearandBinarySearch.LinearSearch;
public class WordSearch {
    public static String searchWordInSentences(String[] sentences, String targetWord) {
        // Iterate through each sentence in the array
        for (String sentence : sentences) {
            // Check if targetWord is in the current sentence (case-insensitive)
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                return sentence;
            }
        }
        // Return "Not Found" if word is not in any sentence
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "I love to code in Python",
            "Java is another programming language",
            "Python is great for data science",
            "Learning to code is fun"
        };
        String targetWord = "data";

        String result = searchWordInSentences(sentences, targetWord);
        System.out.println("Result: \n" + result);
    }
}