package ScenarioBased.Checkout;

import java.util.*;

public class SmartCheckout {
    private Queue<Customer> queue;
    private Map<String, Item> inventory;

    public SmartCheckout() {
        queue = new LinkedList<>();
        inventory = new HashMap<>();
        inventory.put("apple", new Item("apple", 0.5, 100));
        inventory.put("banana", new Item("banana", 0.3, 150));
        inventory.put("milk", new Item("milk", 3.0, 50));
        inventory.put("bread", new Item("bread", 2.5, 30));
        inventory.put("Arihant", new Item("Arihant", 0.0, 90));
    }

    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println("Customer " + customer.getCustomerId() + " added to queue");
    }

    public void processNextCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue");
            return;
        }

        Customer customer = queue.poll();
        System.out.println("Processing customer " + customer.getCustomerId());
        double total = processPurchase(customer);
        System.out.println("Customer " + customer.getCustomerId() + " total: $" + String.format("%.2f", total));
    }

    private double processPurchase(Customer customer) {
        double total = 0.0;
        for (Map.Entry<String, Integer> itemEntry : customer.getItems()) {
            String itemName = itemEntry.getKey();
            int quantity = itemEntry.getValue();

            Item item = inventory.get(itemName);
            if (item == null) {
                System.out.println("Item " + itemName + " not found in inventory");
                continue;
            }

            if (item.getStock() >= quantity) {
                total += item.getPrice() * quantity;
                item.setStock(item.getStock() - quantity);
                System.out.println("Processed: " + quantity + " " + itemName + "(s) at $" + item.getPrice() + " each");
            } else {
                System.out.println("Insufficient stock for " + itemName + ". Available: " + item.getStock());
            }
        }
        return total;
    }

    public double getItemPrice(String itemName) {
        Item item = inventory.get(itemName);
        if (item == null) {
            System.out.println("Item " + itemName + " not found");
            return 0.0;
        }
        return item.getPrice();
    }

    public int getItemStock(String itemName) {
        Item item = inventory.get(itemName);
        if (item == null) {
            System.out.println("Item " + itemName + " not found");
            return 0;
        }
        return item.getStock();
    }

    public static void main(String[] args) {
        SmartCheckout checkout = new SmartCheckout();
        Scanner scanner = new Scanner(System.in);

        List<Map.Entry<String, Integer>> items1 = new ArrayList<>();
        items1.add(new AbstractMap.SimpleEntry<>("apple", 5));
        items1.add(new AbstractMap.SimpleEntry<>("milk", 2));
        Customer customer1 = new Customer(1, items1);

        List<Map.Entry<String, Integer>> items2 = new ArrayList<>();
        items2.add(new AbstractMap.SimpleEntry<>("banana", 10));
        items2.add(new AbstractMap.SimpleEntry<>("bread", 1));
        Customer customer2 = new Customer(2, items2);

        checkout.addCustomer(customer1);
        checkout.addCustomer(customer2);

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Process Next Customer");
            System.out.println("2. Check Item Price");
            System.out.println("3. Check Item Stock");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    checkout.processNextCustomer();
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String priceItem = scanner.nextLine();
                    System.out.println("Price of " + priceItem + ": $" + checkout.getItemPrice(priceItem));
                    break;
                case 3:
                    System.out.print("Enter item name: ");
                    String stockItem = scanner.nextLine();
                    System.out.println("Stock of " + stockItem + ": " + checkout.getItemStock(stockItem));
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}