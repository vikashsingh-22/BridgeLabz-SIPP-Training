package ScenarioBased.AgroBot;

abstract class IrrigationUnit {
    private final String unitId;
    protected double waterFlowRate;
    private boolean isCalibrated;
    
    protected IrrigationUnit(String unitId) {
        this(unitId, 1.0);
    }
    
    protected IrrigationUnit(String unitId, double waterFlowRate) {
        this.unitId = unitId;
        this.waterFlowRate = waterFlowRate;
        this.isCalibrated = false;
        calibrateUnit();
    }
    
    private void calibrateUnit() {
        this.isCalibrated = true;
    }
    
    public String getUnitId() {
        return unitId;
    }
    
    protected boolean isUnitCalibrated() {
        return isCalibrated;
    }
    
    abstract void startWatering();
    
    public void stopWatering() {
        System.out.println(unitId + " stopped watering");
    }
}