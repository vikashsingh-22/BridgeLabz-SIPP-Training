import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }
}

class University {
    private String universityName;
    private List<Department> departments; 
    private List<Faculty> faculties;      

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showDetails() {
        System.out.println("University: " + universityName);

        System.out.println("Departments:");
        for (Department d : departments) {
            System.out.println(" - " + d.getDeptName());
        }

        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            System.out.println(" - " + f.getName());
        }
    }

    public void closeUniversity() {
        System.out.println("\nClosing " + universityName + "...");
        departments.clear(); 
        System.out.println("All departments deleted.");
    }
}

public class University_with_Faculties_and_Departments {
    public static void main(String[] args) {
        Faculty faculty1 = new Faculty("Dr. Sharma");
        Faculty faculty2 = new Faculty("Prof. Mehta");

        University uni = new University("Tech University");

        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical Engineering");

        
        uni.addFaculty(faculty1);
        uni.addFaculty(faculty2);

        
        uni.showDetails();

        uni.closeUniversity();

        System.out.println("\nFaculties still available independently:");
        System.out.println(faculty1.getName());
        System.out.println(faculty2.getName());
    }
}
