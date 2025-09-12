package Inheritance.SingleInheritance;

// Superclass: Device
class Device {
    String deviceId;
    String status;

    // Constructor
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display general device status
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass: Thermostat
class Thermostat extends Device {
    double temperatureSetting;

    // Constructor
    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);  // Call to superclass constructor
        this.temperatureSetting = temperatureSetting;
    }

    // Overridden method to display thermostat-specific status
    @Override
    public void displayStatus() {
        super.displayStatus();  // Call superclass method
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class to test
public class SmartHome {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("TH123", "ON", 22.5);
        thermostat.displayStatus();
    }
}
