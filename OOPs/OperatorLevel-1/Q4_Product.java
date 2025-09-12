// Q4_Product.java
// Sample Program 4: Shopping Cart System
// Demonstrates static, this, final, and instanceof best practices

public class Q4_Product {
    private static double discount = 10.0; // percentage
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Q4_Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }

    public static void main(String[] args) {
        Q4_Product prod1 = new Q4_Product(101, "Laptop", 50000, 2);
        Object obj = prod1;
        if (obj instanceof Q4_Product) {
            ((Q4_Product) obj).displayDetails();
        }
        Q4_Product.updateDiscount(15.0);
        System.out.println("Updated Discount: " + discount + "%");
    }
}
