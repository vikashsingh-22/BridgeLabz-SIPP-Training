package ScenarioBased.LinearandBinarySearch;

import java.util.*;

public class LostAndFound {
    private HashMap<String, LinkedList<String>> itemRegistry;
    private HashSet<String> uniqueItems;
    private Scanner scanner;

    public LostAndFound() {
        itemRegistry = new HashMap<>();
        uniqueItems = new HashSet<>();
        scanner = new Scanner(System.in);
    }

    public boolean addItem(String itemType, String itemDescription) {
        String uniqueKey = itemType + ":" + itemDescription;
        if (uniqueItems.contains(uniqueKey)) {
            return false;
        }
        uniqueItems.add(uniqueKey);
        itemRegistry.computeIfAbsent(itemType, k -> new LinkedList<>()).add(itemDescription);
        return true;
    }

    public String searchItem(String itemType, String keyword) {
        LinkedList<String> items = itemRegistry.get(itemType);
        if (items == null) {
            return "No items of type " + itemType + " found.";
        }
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            if (item.toLowerCase().contains(keyword.toLowerCase())) {
                return "Item found: " + item + " at position " + (i + 1) + " in " + itemType + " category.";
            }
        }
        return "No matching item found for keyword '" + keyword + "' in " + itemType + " category.";
    }

    public List<String> getItemsByType(String itemType) {
        return itemRegistry.getOrDefault(itemType, new LinkedList<>());
    }

    public boolean removeItem(String itemType, String itemDescription) {
        LinkedList<String> items = itemRegistry.get(itemType);
        if (items != null && items.remove(itemDescription)) {
            uniqueItems.remove(itemType + ":" + itemDescription);
            if (items.isEmpty()) {
                itemRegistry.remove(itemType);
            }
            return true;
        }
        return false;
    }

    private int displayMenu() {
        System.out.println("\nLost & Found System Menu:");
        System.out.println("1. Add new item");
        System.out.println("2. Search for an item");
        System.out.println("3. Display items by type");
        System.out.println("4. Remove an item");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void handleAddItem() {
        System.out.print("Enter item type (e.g., bags, mobiles, books): ");
        String itemType = scanner.nextLine().trim();
        System.out.print("Enter item description (e.g., Blue backpack with laptop): ");
        String itemDescription = scanner.nextLine().trim();
        
        if (itemType.isEmpty() || itemDescription.isEmpty()) {
            System.out.println("Item type and description cannot be empty!");
            return;
        }

        boolean added = addItem(itemType, itemDescription);
        System.out.println(added ? "Item added successfully!" : "Item already exists!");
    }

    private void handleSearchItem() {
        System.out.print("Enter item type to search (e.g., bags, mobiles, books): ");
        String itemType = scanner.nextLine().trim();
        System.out.print("Enter keyword to search (e.g., color, brand): ");
        String keyword = scanner.nextLine().trim();
        
        if (itemType.isEmpty() || keyword.isEmpty()) {
            System.out.println("Item type and keyword cannot be empty!");
            return;
        }

        System.out.println(searchItem(itemType, keyword));
    }

    private void handleDisplayItems() {
        System.out.print("Enter item type to display (e.g., bags, mobiles, books): ");
        String itemType = scanner.nextLine().trim();
        
        if (itemType.isEmpty()) {
            System.out.println("Item type cannot be empty!");
            return;
        }

        List<String> items = getItemsByType(itemType);
        if (items.isEmpty()) {
            System.out.println("No items found for type: " + itemType);
        } else {
            System.out.println("Items in " + itemType + " category:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }

    private void handleRemoveItem() {
        System.out.print("Enter item type (e.g., bags, mobiles, books): ");
        String itemType = scanner.nextLine().trim();
        System.out.print("Enter item description to remove: ");
        String itemDescription = scanner.nextLine().trim();
        
        if (itemType.isEmpty() || itemDescription.isEmpty()) {
            System.out.println("Item type and description cannot be empty!");
            return;
        }

        boolean removed = removeItem(itemType, itemDescription);
        System.out.println(removed ? "Item removed successfully!" : "Item not found!");
    }

    public static void main(String[] args) {
        LostAndFound lostAndFound = new LostAndFound();
        while (true) {
            int choice = lostAndFound.displayMenu();
            switch (choice) {
                case 1:
                    lostAndFound.handleAddItem();
                    break;
                case 2:
                    lostAndFound.handleSearchItem();
                    break;
                case 3:
                    lostAndFound.handleDisplayItems();
                    break;
                case 4:
                    lostAndFound.handleRemoveItem();
                    break;
                case 5:
                    System.out.println("Exiting Lost & Found System. Goodbye!");
                    lostAndFound.scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }
}
