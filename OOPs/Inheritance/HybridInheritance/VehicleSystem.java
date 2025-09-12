package Inheritance.HybridInheritance;

// Superclass
class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface
interface Refuelable {
    void refuel();
}

// Subclass - ElectricVehicle
class ElectricVehicle extends Vehicle {

    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println(model + " is charging...");
    }
}

// Subclass - PetrolVehicle implements Vehicle + Refuelable (Hybrid Inheritance)
class PetrolVehicle extends Vehicle implements Refuelable {

    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is being refueled with petrol...");
    }
}

// Main class to test
public class VehicleSystem {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle(250, "Tesla Model S");
        PetrolVehicle honda = new PetrolVehicle(180, "Honda Civic");

        System.out.println("Electric Vehicle Info:");
        tesla.displayInfo();
        tesla.charge();

        System.out.println("\nPetrol Vehicle Info:");
        honda.displayInfo();
        honda.refuel();
    }
}

// This code demonstrates hybrid inheritance by combining a superclass (Vehicle) with an interface (Refuelable).
// The ElectricVehicle class inherits from Vehicle, while the PetrolVehicle class inherits from Vehicle and implements the Refuelable interface.
// This allows PetrolVehicle to have both the properties of a Vehicle and the ability to be refueled, showcasing a hybrid inheritance structure.
// The main method creates instances of both ElectricVehicle and PetrolVehicle, displaying their information and demonstrating their specific functionalities (charging for ElectricVehicle and refueling for PetrolVehicle).
// This structure allows for easy extension in the future, such as adding more vehicle types (like DieselVehicle or HybridVehicle) while maintaining a clear hierarchy and interface for refueling.
