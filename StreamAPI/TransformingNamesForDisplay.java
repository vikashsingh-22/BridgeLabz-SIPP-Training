package StreamAPI;

import java.util.*;
import java.util.stream.*;

public class TransformingNamesForDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter customer name: ");
            names.add(sc.nextLine());
        }

        List<String> transformed = names.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nNames in uppercase (sorted):");
        transformed.forEach(System.out::println);
    }
}
