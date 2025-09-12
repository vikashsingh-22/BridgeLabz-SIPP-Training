package Functional_Interfaces;

import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        int limit = 20;

        Function<String, Integer> getLength = str -> str.length();

        String message = "This is a sample message!";

        int length = getLength.apply(message);

        if (length > limit) {
            System.out.println(" Message exceeds character limit! Length = " + length);
        } else {
            System.out.println(" Message is within limit. Length = " + length);
        }
    }
}
