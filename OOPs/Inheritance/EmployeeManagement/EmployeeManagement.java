package Inheritance.EmployeeManagement;

// Base Class
class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: ₹" + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
        System.out.println("Role: Manager\n");
    }
}

// Subclass: Developer
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("Role: Developer\n");
    }
}

// Subclass: Intern
class Intern extends Employee {
    String school;

    Intern(String name, int id, double salary, String school) {
        super(name, id, salary);
        this.school = school;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("School: " + school);
        System.out.println("Role: Intern\n");
    }
}

// Main Class to test
public class EmployeeManagement {
    public static void main(String[] args) {
        Employee emp1 = new Manager("Arjun", 101, 80000, 5);
        Employee emp2 = new Developer("Ravi", 102, 60000, "Java");
        Employee emp3 = new Intern("Sneha", 103, 15000, "GLA University");

        emp1.displayDetails();
        emp2.displayDetails();
        emp3.displayDetails();
    }
}

