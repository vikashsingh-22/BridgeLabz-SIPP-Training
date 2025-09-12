import java.util.Random;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        int numberOfStudents = 10;
        int[][] scores = generateScores(numberOfStudents);
        int[][] totals = calculateTotalAveragePercentage(scores);
        String[] grades = calculateGrades(totals);
        displayScorecard(scores, totals, grades);
    }

    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            scores[i][0] = 40 + random.nextInt(61); 
            scores[i][1] = 40 + random.nextInt(61); 
            scores[i][2] = 40 + random.nextInt(61); 
        }
        return scores;
    }

    public static int[][] calculateTotalAveragePercentage(int[][] scores) {
        int[][] result = new int[scores.length][3]; 
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            int average = Math.round(total / 3.0f);
            int percentage = Math.round((total / 300.0f) * 100);
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    public static String[] calculateGrades(int[][] data) {
        String[] grades = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            int percentage = data[i][2];
            if (percentage >= 80) grades[i] = "A";
            else if (percentage >= 70) grades[i] = "B";
            else if (percentage >= 60) grades[i] = "C";
            else if (percentage >= 50) grades[i] = "D";
            else if (percentage >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, int[][] totals, String[] grades) {
    }
}
