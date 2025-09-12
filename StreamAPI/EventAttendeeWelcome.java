package StreamAPI;

import java.util.*;

public class EventAttendeeWelcome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> attendees = new ArrayList<>();

        System.out.print("Enter number of attendees: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter attendee name: ");
            attendees.add(sc.nextLine());
        }

        System.out.println("\nWelcome Messages:");
        attendees.forEach(a -> System.out.println("Welcome, " + a + "!"));
    }
}

