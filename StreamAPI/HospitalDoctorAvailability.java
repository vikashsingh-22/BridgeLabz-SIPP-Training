package StreamAPI;

import java.util.*;
import jaa.util.stream.*;

class Doctor {
    private String name;
    private String specialty;
    private boolean weekendAvailable;

    public Doctor(String name, String specialty, boolean weekendAvailable) {
        this.name = name;
        this.specialty = specialty;
        this.weekendAvailable = weekendAvailable;
    }

    public boolean isAvailableOnWeekend() { return weekendAvailable; }
    public String getSpecialty() { return specialty; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + specialty + ") - Weekend: " + weekendAvailable;
    }
}

public class HospitalDoctorAvailability {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Doctor> doctors = new ArrayList<>();

        System.out.print("Enter number of doctors: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter doctor name: ");
            String name = sc.nextLine();
            System.out.print("Enter specialty: ");
            String spec = sc.nextLine();
            System.out.print("Available on weekend (true/false): ");
            boolean avail = sc.nextBoolean();
            sc.nextLine();
            doctors.add(new Doctor(name, spec, avail));
        }

        List<Doctor> weekendDocs = doctors.stream()
                .filter(Doctor::isAvailableOnWeekend)
                .sorted(Comparator.comparing(Doctor::getSpecialty))
                .collect(Collectors.toList());

        System.out.println("\nDoctors available on weekends:");
        weekendDocs.forEach(System.out::println);
    }
}
