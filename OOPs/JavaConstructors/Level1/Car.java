package JavaConstructors.Level1;

public class Car {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate = 1000.0; 

    public Car() {
        this.customerName = "Customer";
        this.carModel = "Basic";
        this.rentalDays = 1;
    }

    public Car(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }

    public int getRentalDays() { return rentalDays; }
    public void setRentalDays(int rentalDays) { this.rentalDays = rentalDays; }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
}

    