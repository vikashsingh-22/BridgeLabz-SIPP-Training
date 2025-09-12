package Encapsulation;
import java.util.ArrayList;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters and setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: ₹" + rentalRate);
    }
}

// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car class
class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of rental rate as insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + maskPolicyNumber();
    }

    private String maskPolicyNumber() {
        return "****" + policyNumber.substring(policyNumber.length() - 4);
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // Extra handling charge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + maskPolicyNumber();
    }

    private String maskPolicyNumber() {
        return "****" + policyNumber.substring(policyNumber.length() - 4);
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("KA01AB1234", 2000, "CARINS123456"));
        vehicles.add(new Bike("KA01BC5678", 500));
        vehicles.add(new Truck("KA01TR9012", 4000, "TRKINS987654"));

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            v.displayDetails();
            double rentalCost = v.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: ₹" + rentalCost);

            if (v instanceof Insurable) {
                Insurable insurable = (Insurable) v;
                double insurance = insurable.calculateInsurance();
                System.out.println("Insurance Cost: ₹" + insurance);
                System.out.println(insurable.getInsuranceDetails());
            } else {
                System.out.println("Insurance: Not applicable");
            }

            System.out.println("-----------------------------");
        }
    }
}
