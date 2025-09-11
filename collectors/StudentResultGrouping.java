package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentResultGrouping {

    // Helper record for the example
    record Student(String name, String grade) {}

    public static void main(String[] args) {
        System.out.println("1. Student Result Grouping");

        List<Student> students = Arrays.asList(
                new Student("Alice", "A"),
                new Student("Bob", "B"),
                new Student("Charlie", "A"),
                new Student("David", "C"),
                new Student("Eve", "B"),
                new Student("Frank", "A")
        );

        // Groups students by their grade using Collectors.groupingBy(),
        // then collects the names into a list for each grade group.
        Map<String, List<String>> namesByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        Student::grade,
                        Collectors.mapping(Student::name, Collectors.toList())
                ));

        System.out.println("Student names grouped by grade: " + namesByGrade);
    }
}
