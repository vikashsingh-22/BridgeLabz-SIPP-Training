package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenueSummary {

    // Helper record for the example
    record Order(String customer, double total) {}

    public static void main(String[] args) {
        System.out.println("3. Order Revenue Summary");

        List<Order> orders = Arrays.asList(
                new Order("CustomerA", 100.50),
                new Order("CustomerB", 25.00),
                new Order("CustomerA", 75.25),
                new Order("CustomerC", 150.75),
                new Order("CustomerB", 50.00)
        );

        // Groups orders by customer and sums the total revenue for each using
        // Collectors.summingDouble().
        Map<String, Double> revenueByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::customer,
                        Collectors.summingDouble(Order::total)
                ));

        System.out.println("Total revenue by customer: " + revenueByCustomer);
    }
}

