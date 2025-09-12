package Inheritance.MultiLevelInheritance;

// Base class
class Course {
    String courseName;
    int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// First level subclass
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Is Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Second level subclass
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; 

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: ₹" + (fee - (fee * discount / 100)));
    }
}

// Main class to test
public class CourseHierarchy {
    public static void main(String[] args) {
        PaidOnlineCourse poc = new PaidOnlineCourse(
            "Java Programming",
            40,
            "Coursera",
            true,
            4999.00,
            20.0
        );

        poc.displayInfo();
    }
}
