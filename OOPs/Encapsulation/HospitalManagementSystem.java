package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Interface for medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class Patient
abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;

    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateBill();

    // Concrete method
    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    // Encapsulation: only allowed access via methods
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + name + ":");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}

// InPatient subclass
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate + 500; // Add fixed admission fee
    }
}

// OutPatient subclass
class OutPatient extends Patient {
    private int numberOfVisits;
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, int numberOfVisits, double consultationFee) {
        super(patientId, name, age);
        this.numberOfVisits = numberOfVisits;
        this.consultationFee = consultationFee;
    }
    @Override
    public double calculateBill() {
        return numberOfVisits * consultationFee; // No fixed fee for outpatients    
    }
    @Override
    public void viewRecords() {
        System.out.println("OutPatient Records for " + getPatientDetails() + ":");
        super.viewRecords(); // Call the parent method to display records
    }

// Main class to test the system
public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();

        InPatient inpatient = new InPatient(101, "Arjun", 30, 5, 2000);
        inpatient.addRecord("Surgery performed");
        inpatient.addRecord("Post-operative care ongoing");

        OutPatient outpatient = new OutPatient(102, "Rekha", 25, 3, 500);
        outpatient.addRecord("Routine check-up");
        outpatient.addRecord("Prescribed antibiotics");

        patientList.add(inpatient);
        patientList.add(outpatient);

        // Using polymorphism to display billing details
        for (Patient p : patientList) {
            System.out.println(p.getPatientDetails());
            p.viewRecords();
            System.out.println("Total Bill: ₹" + p.calculateBill());
            System.out.println("-----");
        }
    }
}

              