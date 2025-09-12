public class CircularTour {

    // Function to find the starting point for the circular tour
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;

        int totalSurplus = 0;     
        int currentSurplus = 0;   
        int start = 0;            

        for (int i = 0; i < n; i++) {
            int gain = petrol[i] - distance[i]; // Net petrol gained at this pump

            totalSurplus += gain;    // Track total surplus over all pumps
            currentSurplus += gain;  // Track current running surplus

            // If at any point surplus drops below 0, current start is not viable
            if (currentSurplus < 0) {
                start = i + 1;       // Move to next pump as starting point
                currentSurplus = 0;  // Reset current surplus
            }
        }

        // If total petrol is less than total distance, no solution exists
        return totalSurplus >= 0 ? start : -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startIndex = findStartingPoint(petrol, distance);
        System.out.println("Starting point index: " + startIndex); // Output: 1
    }
}

