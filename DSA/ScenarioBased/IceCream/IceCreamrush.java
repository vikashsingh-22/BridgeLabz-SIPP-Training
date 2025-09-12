package ScenarioBased.IceCream;

import java.util.Scanner;

public class IceCreamrush {
    public static void printFlavors(FlavorSales[] flavorSales) {
        
        System.out.println("Flavor\t\tSales");
        System.out.println("---------------------");
        for (FlavorSales fs : flavorSales) {
            System.out.printf("%-15s %d\n", fs.getFlavor(), fs.getSales());
        }
    }

    public static void main(String[] args) {
        FlavorSales[] flavorSales = {
            new FlavorSales("Mango Alphonso", 45),
            new FlavorSales("Kesar Pista", 60),
            new FlavorSales("Tender Coconut", 30),
            new FlavorSales("Paan", 25),
            new FlavorSales("Butterscotch", 50),
            new FlavorSales("Nolen Gur", 35),
            new FlavorSales("Gulab Jamun", 40),
            new FlavorSales("Masala Chai", 20)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Print Original Flavor Sales");
        System.out.println("2. Print Sorted Flavor Sales");
        System.out.println("3. Print Both");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                System.out.println("Original Flavor Sales:");
                printFlavors(flavorSales);
                break;
            case 2:
                BubbleSort.bubbleSortFlavors(flavorSales);
                System.out.println("Ice Cream Flavors Sorted by Sales (Descending):");
                System.out.println("Sorted Flavor Sales:");
                printFlavors(flavorSales);
                break;
            case 3:
                System.out.println("Original Flavor Sales:");
                printFlavors(flavorSales);
                BubbleSort.bubbleSortFlavors(flavorSales);
                System.out.println("\nSorted Flavor Sales:");
                printFlavors(flavorSales);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}