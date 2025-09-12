package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSalaryCategorization {

    record Employee(String department, double salary) {}

    public static void main(String[] args) {
        System.out.println(" Employee Salary Categorization");

        List<Employee> employees = Arrays.asList(
                new Employee("Sales", 50000),
                new Employee("Engineering", 80000),
                new Employee("Sales", 60000),
                new Employee("Engineering", 90000),
                new Employee("HR", 55000),
                new Employee("Engineering", 75000)
        );

        
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));

        System.out.println("Average salary by department: " + avgSalaryByDept);
    }
}

