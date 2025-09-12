// Q6_Vehicle.java
// Sample Program 6: Vehicle Registration System
// Demonstrates static, this, final, and instanceof best practices

public class Q6_Vehicle {
    private static double registrationFee = 5000.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Q6_Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void main(String[] args) {
        Q6_Vehicle vehicle1 = new Q6_Vehicle("Amit", "Car", "MH12AB1234");
        Object obj = vehicle1;
        if (obj instanceof Q6_Vehicle) {
            ((Q6_Vehicle) obj).displayDetails();
        }
        Q6_Vehicle.updateRegistrationFee(6000.0);
        System.out.println("Updated Registration Fee: " + registrationFee);
    }
}
