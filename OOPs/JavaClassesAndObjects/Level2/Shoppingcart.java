// package JavaClassesAndObjects.Level2;

// import java.util.*;

// class CartItem {
//     String itemName;
//     double price;
//     int quantity;

    
//     CartItem(String itemName, double price, int quantity)
//         this.itemName = itemName;
//         this.price = price;
//         this.quantity = quantity;
//     }

//     double getTotalPrice() {
//         return price * quantity;
//     }

    
//     void displayItem() {
//         System.out.println(itemName + " - ₹" + price + " x " + quantity + " = ₹" + getTotalPrice());
//     }
// }

// class Shoppingcart {
//     ArrayList<CartItem> cart = new ArrayList<>();

//     // Add item
//     void addItem(CartItem item) {
//         cart.add(item);
//         System.out.println(item.itemName + " added to cart.");
//     }

    
//     void removeItem(String itemName) {
//         cart.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
//         System.out.println(itemName + " removed from cart.");
//     }

//     void displayTotal() {
//         double total = 0;
//         System.out.println("Cart Items:");
//         for (CartItem item : cart) {
//             item.displayItem();
//             total += item.getTotalPrice();
//         }
//         System.out.println("Total Cost: ₹" + total);
//     }

//     public static void main(String[] args) {
//         Shoppingcart cart = new Shoppingcart();
//         cart.addItem(new CartItem("Laptop", 55000, 1));
//         cart.addItem(new CartItem("Mouse", 500, 2));
//         cart.displayTotal();
//         cart.removeItem("Mouse");
//         cart.displayTotal();
//     }
// }
