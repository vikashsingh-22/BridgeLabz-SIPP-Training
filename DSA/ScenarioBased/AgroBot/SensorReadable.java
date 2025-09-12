package ScenarioBased.AgroBot;

interface SensorReadable {
    double readSoilMoisture();
    boolean isWaterLevelSufficient();
}
