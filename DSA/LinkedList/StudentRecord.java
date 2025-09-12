package LinkedList;
import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    Student head = null;

    // Add at end
    public void addStudent(int roll, String name, int age, String grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
    }

    // Delete by Roll Number
    public void deleteStudent(int roll) {
        if (head == null) return;

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted.");
        }
    }

    // Search by Roll Number
    public void searchStudent(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Update grade
    public void updateGrade(int roll, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all students
    public void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No students to display.");
        }
        while (temp != null) {
            System.out.println("Roll: " + temp.roll + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Grade");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Roll: ");
                int roll = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Grade: ");
                String grade = sc.nextLine();
                list.addStudent(roll, name, age, grade);
            } else if (ch == 2) {
                System.out.print("Enter roll to delete: ");
                int roll = sc.nextInt();
                list.deleteStudent(roll);
            } else if (ch == 3) {
                System.out.print("Enter roll to search: ");
                int roll = sc.nextInt();
                list.searchStudent(roll);
            } else if (ch == 4) {
                System.out.print("Enter roll to update grade: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new grade: ");
                String grade = sc.nextLine();
                list.updateGrade(roll, grade);
            } else if (ch == 5) {
                list.displayAll();
            } else if (ch == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        
    }
}
