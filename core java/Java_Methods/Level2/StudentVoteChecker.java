package Java_Methods.Level2;
import java.util.Scanner;

public class StudentVoteChecker {

    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] studentAges = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            studentAges[i] = sc.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            boolean eligible = canStudentVote(studentAges[i]);
            if (studentAges[i] < 0) {
                System.out.println("Student " + (i + 1) + " has invalid age: " + studentAges[i]);
            } else if (eligible) {
                System.out.println("Student " + (i + 1) + " with age " + studentAges[i] + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " with age " + studentAges[i] + " cannot vote.");
            }
        }

        sc.close();
    }
}
