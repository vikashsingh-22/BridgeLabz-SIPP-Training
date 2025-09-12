package Encapsulation;

import java.util.ArrayList;

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Abstract method
    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    private final double taxRate = 0.18;

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax (18%)";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    private final double taxRate = 0.12;

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax (12%)";
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Smartphone", 30000));
        products.add(new Clothing(102, "T-Shirt", 1200));
        products.add(new Groceries(103, "Rice Bag", 1500));

        for (Product product : products) {
            product.displayDetails();

            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0.0;
            double discount = product.calculateDiscount();
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Discount: ₹" + discount);
            System.out.println("Tax: ₹" + tax);
            System.out.println("Final Price: ₹" + finalPrice);

            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }

            System.out.println("------------------------");
        }
    }
}
