package regex;

import java.util.regex.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String pattern = "\\b(" + String.join("|", badWords) + ")\\b";

        String censored = input.replaceAll("(?i)" + pattern, "****");

        System.out.println(censored);
    }
}

