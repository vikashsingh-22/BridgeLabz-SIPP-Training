// Q3_Employee.java
// Sample Program 3: Employee Management System
// Demonstrates static, this, final, and instanceof best practices

public class Q3_Employee {
    private static String companyName = "Tech Solutions";
    private static int totalEmployees = 0;
    private final int id;
    private String name;
    private String designation;

    public Q3_Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }
    
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }

    public static void main(String[] args) {
        Q3_Employee emp1 = new Q3_Employee("Sam", 1, "Manager");
        Object obj = emp1;
        if (obj instanceof Q3_Employee) {
            ((Q3_Employee) obj).displayDetails();
        }
        Q3_Employee.displayTotalEmployees();
    }
}
