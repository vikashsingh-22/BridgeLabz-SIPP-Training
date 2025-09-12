package StreamAPI;

import java.util.*;
import java.time.LocalDateTime;

public class LoggingTransactions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> transactionIds = new ArrayList<>();

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter transaction ID: ");
            transactionIds.add(sc.nextLine());
        }

        System.out.println("\nTransaction Logs:");
        transactionIds.forEach(id ->
                System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}

