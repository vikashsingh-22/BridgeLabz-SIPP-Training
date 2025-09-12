package String_EXTRAS;

public class Revers_a_String {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("Reversed String: " + reverseString(str));
    }

    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--)
            reversed += str.charAt(i);
        return reversed;
    }
}
