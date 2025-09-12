// Q5_Student.java
// Sample Program 5: University Student Management
// Demonstrates static, this, final, and instanceof best practices

public class Q5_Student {
    private static String universityName = "National University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private String grade;

    public Q5_Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Q5_Student student1 = new Q5_Student("Rita", 201, "A");
        Object obj = student1;
        if (obj instanceof Q5_Student) {
            ((Q5_Student) obj).displayDetails();
        }
        Q5_Student.displayTotalStudents();
    }
}
