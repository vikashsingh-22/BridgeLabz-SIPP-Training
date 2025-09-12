package Encapsulation;

import java.util.*;

// GPS Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Vehicle class
abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per km: ₹" + ratePerKm;
    }

    // Encapsulation for sensitive details
    protected double getRatePerKm() {
        return ratePerKm;
    }

    protected void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    protected String getDriverName() {
        return driverName;
    }

    protected void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    // GPS Implementation
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Car subclass
class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // Extra base fare
    }
}

// Bike subclass
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // No base fare
    }
}

// Auto subclass
class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // Slight base fare
    }
}

// Main class to test the application
public class RideHailingApp {
    // Polymorphic method to calculate fares
    public static void showFareDetails(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Current Location: " + vehicle.getCurrentLocation());
        System.out.println("Estimated Fare for " + distance + " km: ₹" + vehicle.calculateFare(distance));
        System.out.println("-----");
    }

    public static void main(String[] args) {
        Vehicle car = new Car("CAR001", "Ravi", 15.0);
        car.updateLocation("Connaught Place");

        Vehicle bike = new Bike("BIKE002", "Suman", 7.0);
        bike.updateLocation("Karol Bagh");

        Vehicle auto = new Auto("AUTO003", "Mohan", 10.0);
        auto.updateLocation("Lajpat Nagar");

        // Demonstrating polymorphism
        showFareDetails(car, 10.0);
        showFareDetails(bike, 5.5);
        showFareDetails(auto, 8.0);
    }
}
// The RideHailingApp class demonstrates encapsulation, polymorphism, and inheritance
// by allowing different types of vehicles to be handled uniformly while maintaining their specific behaviors.
// The GPS interface provides a way to track vehicle locations, ensuring that sensitive details are encapsulated
// and not directly accessible from outside the class. The main method showcases polymorphism by calling the
// showFareDetails method with different vehicle types, allowing for a flexible and extensible design.