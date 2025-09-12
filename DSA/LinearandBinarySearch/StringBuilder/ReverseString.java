package LinearandBinarySearch.StringBuilder;

public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";

        // Step 1: Create a StringBuilder object with the input string
        StringBuilder sb = new StringBuilder(input);

        // Step 2: Reverse the string using reverse() method
        sb.reverse();

        // Step 3: Convert the reversed StringBuilder to String
        String reversed = sb.toString();

        
        System.out.println("Reversed string: " + reversed);
    }
}
