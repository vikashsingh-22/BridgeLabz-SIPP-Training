package ScenarioBased.AgroBot;
public class AgroBotIrrigationSystem {
    public static void main(String[] args) {
        IrrigationUnit sprinkler = new Sprinkler("SPK001", 2.5, 5.0);
        IrrigationUnit drip = new DripSystem("DRP001", 1.0, 10);
        SensorReadable sprinklerSensor = (Sprinkler)sprinkler;
        SensorReadable dripSensor = (DripSystem)drip;
        
        // Simulated command input (1: start, 2: stop, 3: read moisture, 4: check water level)
        int command = 1; // Change this value to test different cases
        
        switch (command) {
            case 1:
                sprinkler.startWatering();
                drip.startWatering();
                break;
            case 2:
                sprinkler.stopWatering();
                drip.stopWatering();
                break;
            case 3:
                System.out.println("Sprinkler soil moisture: " + 
                    sprinklerSensor.readSoilMoisture() + "%");
                System.out.println("Drip system soil moisture: " + 
                    dripSensor.readSoilMoisture() + "%");
                break;
            case 4:
                System.out.println("Sprinkler water level sufficient: " + 
                    sprinklerSensor.isWaterLevelSufficient());
                System.out.println("Drip system water level sufficient: " + 
                    dripSensor.isWaterLevelSufficient());
                break;
            default:
                System.out.println("Invalid command");
        }
    }
}