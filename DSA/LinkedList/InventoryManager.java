package LinkedList;

import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManager {
    private Item head = null;

    // Add item at beginning
    public void addAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    // Add item at end
    public void addAtEnd(Item newItem) {
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add item at position
    public void addAtPosition(Item newItem, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newItem);
            return;
        }
        Item temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove by ID
    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found.");
        }
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by ID or name
    public void search(String name, int id) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if ((id != -1 && temp.id == id) || (name != null && temp.name.equalsIgnoreCase(name))) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    // Display items
    public void displayItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        System.out.println("Inventory Items:");
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    // Total inventory value
    public void totalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.printf("Total Inventory Value: ₹%.2f\n", total);
    }

    // Sort inventory
    public void sortInventory(String by, boolean ascending) {
        head = mergeSort(head, by, ascending);
        System.out.println("Inventory sorted by " + by + " (" + (ascending ? "asc" : "desc") + ").");
    }

    // Merge sort
    private Item mergeSort(Item head, String by, boolean asc) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item next = middle.next;
        middle.next = null;

        Item left = mergeSort(head, by, asc);
        Item right = mergeSort(next, by, asc);
        return merge(left, right, by, asc);
    }

    private Item merge(Item a, Item b, String by, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;
        boolean condition;
        if (by.equalsIgnoreCase("name")) {
            condition = asc ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        Item result;
        if (condition) {
            result = a;
            result.next = merge(a.next, b, by, asc);
        } else {
            result = b;
            result.next = merge(a, b.next, by, asc);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return null;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void printItem(Item item) {
        System.out.println("ID: " + item.id + ", Name: " + item.name +
                ", Qty: " + item.quantity + ", Price: ₹" + item.price);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager inv = new InventoryManager();

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search by ID or Name");
            System.out.println("7. Display All Items");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort by Name or Price");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            String name;
            int id, qty, pos;
            double price;

            switch (ch) {
                case 1: case 2: case 3:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextDouble();
                    Item newItem = new Item(name, id, qty, price);
                    if (ch == 1) inv.addAtBeginning(newItem);
                    else if (ch == 2) inv.addAtEnd(newItem);
                    else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();
                        inv.addAtPosition(newItem, pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Item ID to Remove: ");
                    id = sc.nextInt();
                    inv.removeById(id);
                    break;

                case 5:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    qty = sc.nextInt();
                    inv.updateQuantity(id, qty);
                    break;

                case 6:
                    System.out.print("Search by ID (enter -1 to skip): ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Search by Name (press Enter to skip): ");
                    name = sc.nextLine();
                    inv.search(name.isEmpty() ? null : name, id);
                    break;

                case 7:
                    inv.displayItems();
                    break;

                case 8:
                    inv.totalValue();
                    break;

                case 9:
                    System.out.print("Sort by (name/price): ");
                    String by = sc.nextLine();
                    System.out.print("Ascending? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inv.sortInventory(by, asc);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
// End of InventoryManager.java
// Note: The Item class is defined within the InventoryManager class for simplicity.
// You can also define it as a separate class if needed.
// This code demonstrates a simple inventory management system using a linked list.
// It includes functionalities to add, remove, update, search, display items, calculate total value
// and sort the inventory based on name or price.
// The main method provides a menu-driven interface for user interaction.
// The code uses encapsulation to hide the internal structure of the linked list and provides methods
// to interact with the inventory. It also demonstrates basic linked list operations such as insertion, 