package JavaConstructors.InstanceVsClass.ProductInventory;

public class ProductInventory {
    private String productName;
    private double price;

    private static int totalProducts = 0;

    // Constructor
    public ProductInventory(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; 
    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        ProductInventory p1 = new ProductInventory("Laptop", 50000);
        ProductInventory p2 = new ProductInventory("Smartphone", 20000);

        p1.displayProductDetails();
        System.out.println("----");
        p2.displayProductDetails();
        System.out.println("----");
        ProductInventory.displayTotalProducts();
    }
}
