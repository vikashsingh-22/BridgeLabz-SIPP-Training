package ScenarioBased.IceCream;

public class BubbleSort {
    public static void bubbleSortFlavors(FlavorSales[] flavorSales) {
        int n = flavorSales.length;
        // Bubble sort: compare adjacent elements and swap if needed
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent sales figures (descending order)
                if (flavorSales[j].getSales() < flavorSales[j + 1].getSales()) {
                    // Swap flavorSales objects
                    FlavorSales temp = flavorSales[j];
                    flavorSales[j] = flavorSales[j + 1];
                    flavorSales[j + 1] = temp;
                }
            }
        }
    }
}