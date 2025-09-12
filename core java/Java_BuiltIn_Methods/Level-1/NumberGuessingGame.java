import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        boolean found = false;

        System.out.println("Think of a number between 1 and 100 and I will try to guess it!");

        while (!found && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "?");
            String feedback = getUserFeedback(scanner);

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Yay! I guessed your number.");
                found = true;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else {
                System.out.println("Invalid feedback! Please enter 'low', 'high', or 'correct'.");
            }
        }

        if (!found) {
            System.out.println("Hmm... Something went wrong. Did you change your number?");
        }

        scanner.close();
    }

    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static String getUserFeedback(Scanner scanner) {
        System.out.print("Enter 'low' if my guess is too low, 'high' if it's too high, or 'correct': ");
        return scanner.nextLine().trim();
    }
}
