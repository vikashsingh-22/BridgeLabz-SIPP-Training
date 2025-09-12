package StreamAPI;

import java.util.*;

public class IoTSensorReadings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> readings = new ArrayList<>();

        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter reading: ");
            readings.add(sc.nextDouble());
        }

        System.out.print("Enter threshold value: ");
        double threshold = sc.nextDouble();

        System.out.println("\nReadings above threshold:");
        readings.stream()
                .filter(r -> r > threshold)
                .forEach(r -> System.out.println("High reading: " + r));
    }
}
