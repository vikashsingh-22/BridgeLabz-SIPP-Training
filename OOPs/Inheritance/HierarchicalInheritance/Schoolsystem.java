package Inheritance.HierarchicalInheritance;

// Superclass
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass: Teacher
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Role: Teacher");
        displayDetails();
        System.out.println("Subject: " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Role: Student");
        displayDetails();
        System.out.println("Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        System.out.println("Role: Staff");
        displayDetails();
        System.out.println("Department: " + department);
    }
}

// Main class
public class Schoolsystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Arjun Raghav", 20, "12th Grade");
        Staff staff = new Staff("Ms. Anjali", 35, "Administration");

        teacher.displayRole();
        System.out.println("-------------------------");
        student.displayRole();
        System.out.println("-------------------------");
        staff.displayRole();
    }
}
