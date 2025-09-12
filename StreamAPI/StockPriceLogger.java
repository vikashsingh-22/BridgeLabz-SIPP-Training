package StreamAPI;

import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> stockPrices = new ArrayList<>();

        System.out.print("Enter number of stock prices: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter stock price: ");
            stockPrices.add(sc.nextDouble());
        }

        System.out.println("\nStock Price Log:");
        stockPrices.forEach(price -> System.out.println("Stock Price: " + price));
    }
}
