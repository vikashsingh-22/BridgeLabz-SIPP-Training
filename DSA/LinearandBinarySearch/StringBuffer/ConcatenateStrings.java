package LinearandBinarySearch.StringBuffer;

public class ConcatenateStrings {

    public static String concatenateUsingStringBuffer(String[] input) {
        StringBuffer sb = new StringBuffer();

        for (String str : input) {
            sb.append(str); 
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = {"Hello", " ", "World", "!", " Welcome", " to", " Java."};

        String result = concatenateUsingStringBuffer(input);
        System.out.println("Concatenated String: " + result);
    }
}


