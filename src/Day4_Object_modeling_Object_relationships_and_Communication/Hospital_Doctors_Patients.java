import java.util.ArrayList;
import java.util.List;

class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showPatients() {
        System.out.println("Doctor " + name + " is seeing patients:");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void showDoctors() {
        System.out.println("Patient " + name + " is consulting doctors:");
        for (Doctor d : doctors) {
            System.out.println(" - " + d.getName());
        }
    }
}

class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void arrangeConsultation(Doctor doctor, Patient patient) {
        doctor.addPatient(patient);
        patient.addDoctor(doctor);
        System.out.println("Consultation arranged: Dr. " + doctor.getName() + " with " + patient.getName());
    }

    public void showHospitalDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(" - " + d.getName());
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}

public class Hospital_Doctors_Patients {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

       
        Doctor doc1 = new Doctor("Dr. Verma");
        Doctor doc2 = new Doctor("Dr. Singh");

        
        Patient pat1 = new Patient("Anita");
        Patient pat2 = new Patient("Ravi");

        
        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);
        hospital.addPatient(pat1);
        hospital.addPatient(pat2);

        hospital.arrangeConsultation(doc1, pat1);
        hospital.arrangeConsultation(doc1, pat2);
        hospital.arrangeConsultation(doc2, pat1);

        System.out.println();
        hospital.showHospitalDetails();
        System.out.println();
        doc1.showPatients();
        doc2.showPatients();
        System.out.println();
        pat1.showDoctors();
        pat2.showDoctors();
    }
}
