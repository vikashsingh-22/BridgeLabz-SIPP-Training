// Q7_Patient.java
// Sample Program 7: Hospital Management System
// Demonstrates static, this, final, and instanceof best practices

public class Q7_Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Q7_Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }

    public static void main(String[] args) {
        Q7_Patient patient1 = new Q7_Patient(301, "Rahul", 45, "Fever");
        Object obj = patient1;
        if (obj instanceof Q7_Patient) {
            ((Q7_Patient) obj).displayDetails();
        }
        System.out.println("Total Patients: " + Q7_Patient.getTotalPatients());
    }
}
