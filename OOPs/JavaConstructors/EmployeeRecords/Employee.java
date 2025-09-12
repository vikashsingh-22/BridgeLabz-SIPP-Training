package JavaConstructors.EmployeeRecords;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void updateSalary(double newSalary) {
        salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void display() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {
        Manager m = new Manager(1001, "IT", 75000);
        m.display();
        System.out.println("Salary: " + m.getSalary());
        m.updateSalary(85000);
        System.out.println("Updated Salary: " + m.getSalary());
    }
}

