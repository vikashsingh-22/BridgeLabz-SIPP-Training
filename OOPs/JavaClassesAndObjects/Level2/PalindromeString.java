package JavaClassesAndObjects.Level2;

class PalindromeString {
    String text;

   
    PalindromeString(String text) {
        this.text = text;
    }

    
    boolean isPalindrome() {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = cleanText.length() - 1;

        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    void displayResult() {
        System.out.println("Text: " + text);
        System.out.println("Is Palindrome: " + isPalindrome());
    }

    public static void main(String[] args) {
        PalindromeString checker = new PalindromeString("Madam");
        checker.displayResult();
    }
}
