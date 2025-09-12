package ScenarioBased.FoodFest;

// FoodFestMain.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FoodFestMain {
    public static void main(String[] args) {
        // Sample data: three zones with sorted stall lists (descending by footfall)
        List<List<Stall>> zoneLogs = new ArrayList<>();
        
        // Zone 1
        List<Stall> zone1 = Arrays.asList(
            new Stall(100, "S1", "Z1"),
            new Stall(80, "S2", "Z1"),
            new Stall(50, "S3", "Z1")
        );
        // Zone 2
        List<Stall> zone2 = Arrays.asList(
            new Stall(90, "S4", "Z2"),
            new Stall(80, "S5", "Z2"),
            new Stall(60, "S6", "Z2")
        );
        // Zone 3
        List<Stall> zone3 = Arrays.asList(
            new Stall(95, "S7", "Z3"),
            new Stall(70, "S8", "Z3")
        );
        
        zoneLogs.add(zone1);
        zoneLogs.add(zone2);
        zoneLogs.add(zone3);

        StallMergeSorter sorter = new StallMergeSorter();
        List<Stall> mergedList = sorter.mergeSortedStalls(zoneLogs);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display menu
            System.out.println("\nFoodFest Stall Management Menu:");
            System.out.println("1. View all stalls sorted by footfall");
            System.out.println("2. View stalls by zone");
            System.out.println("3. View stalls above footfall threshold");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nAll Stalls Sorted by Footfall (Descending):");
                    for (Stall stall : mergedList) {
                        System.out.println(stall);
                    }
                    break;

                case 2:
                    // Filter stalls by zone
                    System.out.print("Enter zone ID (e.g., Z1, Z2, Z3): ");
                    String zoneId = scanner.nextLine().trim();
                    System.out.println("\nStalls in Zone " + zoneId + ":");
                    boolean found = false;
                    for (Stall stall : mergedList) {
                        if (stall.getZoneId().equalsIgnoreCase(zoneId)) {
                            System.out.println(stall);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No stalls found for zone " + zoneId);
                    }
                    break;

                case 3:
                    System.out.print("Enter minimum footfall threshold: ");
                    int threshold;
                    try {
                        threshold = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid footfall value! Please enter a valid number.");
                        continue;
                    }
                    System.out.println("\nStasis with Footfall >= " + threshold + ":");
                    found = false;
                    for (Stall stall : mergedList) {
                        if (stall.getFootfallCount() >= threshold) {
                            System.out.println(stall);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No stalls found with footfall >= " + threshold);
                    }
                    break;

                case 4:
                    System.out.println("Exiting FoodFest Stall Management. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 4.");
                    break;
            }
        }

       
    }
}