package Encapsulation;

import java.util.ArrayList;

// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: ₹" + baseSalary);
    }
}

// Interface Department
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Fixed salary
    }

    @Override
    public void assignDepartment(String dept) {
        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {
        return "Full-Time Department: " + department;
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0); // baseSalary not used for part-time
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void assignDepartment(String dept) {
        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {
        return "Part-Time Department: " + department;
    }
}

// Main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // Create employees
        FullTimeEmployee fte = new FullTimeEmployee(1001, "Alice", 60000);
        fte.assignDepartment("HR");

        PartTimeEmployee pte = new PartTimeEmployee(1002, "Bob", 300, 20);
        pte.assignDepartment("Support");

        employees.add(fte);
        employees.add(pte);

        // Process employees using polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Calculated Salary: ₹" + emp.calculateSalary());

            if (emp instanceof Department) {
                Department dept = (Department) emp;
                System.out.println(dept.getDepartmentDetails());
            }

            System.out.println("---------------------------");
        }
    }
}
