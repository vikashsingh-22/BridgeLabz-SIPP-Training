package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Interface for applying discount
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Abstract base class
abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public String getItemDetails() {
        return "Item: " + itemName + ", Price: ₹" + price + ", Quantity: " + quantity;
    }
}

// VegItem class
class VegItem extends FoodItem {
    private double discountApplied = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public void applyDiscount(double percentage) {
        discountApplied = percentage;
        double discountedPrice = getPrice() * (1 - percentage / 100);
        setPrice(discountedPrice);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied: " + discountApplied + "% on Veg Item";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem {
    private final double nonVegCharge = 30.0; // extra charge for non-veg items
    private double discountApplied = 0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + nonVegCharge) * getQuantity();
    }

    @Override
    public void applyDiscount(double percentage) {
        discountApplied = percentage;
        double discountedPrice = getPrice() * (1 - percentage / 100);
        setPrice(discountedPrice);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied: " + discountApplied + "% on Non-Veg Item (₹" + nonVegCharge + " extra per item)";
    }
}

// Order processing class to demonstrate polymorphism
class OrderProcessor {
    public static void processOrder(List<FoodItem> items) {
        double totalBill = 0;
        for (FoodItem item : items) {
            System.out.println(item.getItemDetails());
            item.applyDiscount(10); // applying 10% discount to all items
            System.out.println(item.getDiscountDetails());
            double total = item.calculateTotalPrice();
            System.out.println("Total for " + item.getItemName() + ": ₹" + total);
            totalBill += total;
            System.out.println("-----");
        }
        System.out.println("Grand Total: ₹" + totalBill);
    }
}

// Main class
public class FoodDelivery {
    public static void main(String[] args) {
        List<FoodItem> orderList = new ArrayList<>();
        orderList.add(new VegItem("Paneer Tikka", 120, 2));
        orderList.add(new NonVegItem("Chicken Biryani", 180, 1));
        orderList.add(new VegItem("Veg Burger", 80, 3));
        orderList.add(new NonVegItem("Fish Curry", 200, 2));

        OrderProcessor.processOrder(orderList);
    }
}
