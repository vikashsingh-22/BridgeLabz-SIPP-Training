package ScenarioBased.AgroBot;

class DripSystem extends IrrigationUnit implements SensorReadable {
    private int numberOfEmitters;
    
    public DripSystem(String unitId, int numberOfEmitters) {
        super(unitId);
        this.numberOfEmitters = numberOfEmitters;
    }
    
    public DripSystem(String unitId, double waterFlowRate, int numberOfEmitters) {
        super(unitId, waterFlowRate);
        this.numberOfEmitters = numberOfEmitters;
    }
    
    @Override
    public void startWatering() {
        if (isUnitCalibrated()) {
            System.out.println(getUnitId() + " drip system watering through " + 
                numberOfEmitters + " emitters at " + waterFlowRate + "L/min");
        }
    }
    
    @Override
    public double readSoilMoisture() {
        return Math.random() * 100;
    }
    
    @Override
    public boolean isWaterLevelSufficient() {
        return Math.random() > 0.2;
    }
}