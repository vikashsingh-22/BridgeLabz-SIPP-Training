

class Mobile {
    String brand;
    String model;
    double price;

    Mobile(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
        Mobile phone = new Mobile("Samsung", "Galaxy S24", 79999);
        phone.displayDetails();
    }
}
