package ScenarioBased.AgroBot;

class Sprinkler extends IrrigationUnit implements SensorReadable {
    private double coverageRadius;
    
    public Sprinkler(String unitId, double coverageRadius) {
        super(unitId);
        this.coverageRadius = coverageRadius;
    }
    
    public Sprinkler(String unitId, double waterFlowRate, double coverageRadius) {
        super(unitId, waterFlowRate);
        this.coverageRadius = coverageRadius;
    }
    
    @Override
    public void startWatering() {
        if (isUnitCalibrated()) {
            System.out.println(getUnitId() + " sprinkler watering with flow rate " + 
                waterFlowRate + "L/min, covering " + coverageRadius + "m radius");
        }
    }
    
    @Override
    public double readSoilMoisture() {
        return Math.random() * 100;
    }
    
    @Override
    public boolean isWaterLevelSufficient() {
        return Math.random() > 0.3;
    }
}