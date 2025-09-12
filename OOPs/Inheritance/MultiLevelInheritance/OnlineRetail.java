package Inheritance.MultiLevelInheritance;
import java.time.LocalDate;

// Base class: Order
class Order {
    String orderId;
    LocalDate orderDate;

    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Subclass: ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped (Tracking: " + trackingNumber + ")";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

// Subclass: DeliveredOrder (extends ShippedOrder)
class DeliveredOrder extends ShippedOrder {
    LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered on " + deliveryDate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

// Main class to test the hierarchy
public class OnlineRetail {
    public static void main(String[] args) {
        Order order = new Order("ORD101", LocalDate.of(2025, 6, 28));
        ShippedOrder shipped = new ShippedOrder("ORD102", LocalDate.of(2025, 6, 25), "TRK123456");
        DeliveredOrder delivered = new DeliveredOrder("ORD103", LocalDate.of(2025, 6, 20), "TRK654321", LocalDate.of(2025, 6, 26));

        System.out.println("=== Basic Order ===");
        order.displayInfo();

        System.out.println("\n=== Shipped Order ===");
        shipped.displayInfo();

        System.out.println("\n=== Delivered Order ===");
        delivered.displayInfo();
    }
}
