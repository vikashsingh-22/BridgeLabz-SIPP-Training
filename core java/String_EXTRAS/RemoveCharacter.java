package String_EXTRAS;

public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char ch = 'l';
        System.out.println("Modified String: " + removeCharacter(str, ch));
    }

    public static String removeCharacter(String str, char ch) {
        return str.replaceAll(String.valueOf(ch), "");
    }
}
