package JavaConstructors.InstanceVsClass.Course;

public class Course {
    private String courseName;
    private int duration;
    private double fee;

    private static String instituteName = "Default Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course.updateInstituteName("GLA University");

        Course course1 = new Course("Java Programming", 3, 15000);
        Course course2 = new Course("Data Structures", 4, 18000);

        course1.displayCourseDetails();
        System.out.println("----");
        course2.displayCourseDetails();
    }
}
