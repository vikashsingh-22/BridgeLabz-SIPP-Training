package StreamAPI;

import java.util.*;
import java.util.stream.*;

class Claim {
    private String type;
    private double amount;

    public Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() { return type; }
    public double getAmount() { return amount; }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Claim> claims = new ArrayList<>();

        System.out.print("Enter number of claims: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter claim type: ");
            String type = sc.nextLine();
            System.out.print("Enter claim amount: ");
            double amount = sc.nextDouble(); sc.nextLine();
            claims.add(new Claim(type, amount));
        }

        Map<String, Double> avgClaimByType = claims.stream()
                .collect(Collectors.groupingBy(
                        Claim::getType,
                        Collectors.averagingDouble(Claim::getAmount)
                ));

        System.out.println("\nAverage claim amount by type:");
        avgClaimByType.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
