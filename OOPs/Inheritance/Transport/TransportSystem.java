package Inheritance.Transport;

// Superclass
class Vehicle {
    int maxSpeed;
    String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Vehicle Info:");
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass: Car
class Car extends Vehicle {
    int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
        System.out.println("Type: Car\n");
    }
}

// Subclass: Truck
class Truck extends Vehicle {
    int loadCapacity; // in tons

    public Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println("Type: Truck\n");
    }
}

// Subclass: Motorcycle
class Motorcycle extends Vehicle {
    boolean hasCarrier;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed, fuelType);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
        System.out.println("Type: Motorcycle\n");
    }
}

// Main class to demonstrate polymorphism
public class TransportSystem {
    public static void main(String[] args) {
        // Polymorphic array of Vehicle
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new Motorcycle(150, "Petrol", true);

        // Display info for all vehicles
        for (Vehicle v : vehicles) {
            v.displayInfo(); // Polymorphic behavior
        }
    }
}

