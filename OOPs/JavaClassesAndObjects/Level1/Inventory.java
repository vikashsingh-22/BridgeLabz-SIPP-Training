class EmployeeDetails {
    String name;
    int id;
    double salary;

    EmployeeDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: ₹" + salary);
    }

    public static void main(String[] args) {
        EmployeeDetails emp = new EmployeeDetails("Arjun Raghav", 101, 55000);
        emp.displayDetails();
    }
}
