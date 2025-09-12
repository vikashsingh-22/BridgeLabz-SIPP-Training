import java.util.Random;
import java.util.Scanner;

public class StudentVotingEligibility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] ages = generateRandomAges(n);
        String[][] result = checkVotingEligibility(ages);

        System.out.println("\nAge\tCan Vote");
        System.out.println("-----------------");
        displayResult(result);
    }

    public static int[] generateRandomAges(int count) {
        Random rand = new Random();
        int[] ages = new int[count];

        for (int i = 0; i < count; i++) {
            ages[i] = rand.nextInt(90) + 10; // Random 2-digit age (10–99)
        }

        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    public static void displayResult(String[][] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" + result[i][1]);
        }
    }
}
