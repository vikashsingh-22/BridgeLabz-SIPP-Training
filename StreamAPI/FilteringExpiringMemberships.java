package StreamAPI;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.stream.*;

class Member {
    private String name;
    private LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() { return expiryDate; }
    @Override
    public String toString() { return name + " (Expires: " + expiryDate + ")"; }
}

public class FilteringExpiringMemberships {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Member> members = new ArrayList<>();

        System.out.print("Enter number of members: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter member name: ");
            String name = sc.nextLine();
            System.out.print("Enter expiry date (yyyy-mm-dd): ");
            LocalDate date = LocalDate.parse(sc.nextLine());
            members.add(new Member(name, date));
        }

        LocalDate now = LocalDate.now();
        List<Member> expiring = members.stream()
                .filter(m -> ChronoUnit.DAYS.between(now, m.getExpiryDate()) <= 30)
                .collect(Collectors.toList());

        System.out.println("\nMembers expiring within 30 days:");
        expiring.forEach(System.out::println);
    }
}
