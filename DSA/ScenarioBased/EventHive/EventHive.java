package ScenarioBased.EventHive;

import java.util.Scanner;

public class EventHive {
    public static void main(String[] args) {
        Admin admin = new Admin();
        User user = new User("USR001", "John Doe", "john@example.com");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter command (1: create event, 2: register user, 3: update event, 4: remove event): ");
        int command = scanner.nextInt();

        switch (command) {
            case 1:
                admin.createEvent("EVT001", "Tech Conference", "2025-08-01", 100);
                System.out.println("Event created: EVT001");
                break;
            case 2:
                admin.createEvent("EVT001", "Tech Conference", "2025-08-01", 100);
                Event event = admin.getEvent("EVT001");
                Ticket ticket = user.registerForEvent(event);
                if (ticket != null) {
                    System.out.println(ticket.getTicketDetails());
                }
                break;
            case 3:
                admin.createEvent("EVT001", "Tech Conference", "2025-08-01", 100);
                admin.updateEvent("EVT001", "Tech Summit", "2025-08-02", 50);
                System.out.println("Updated event: " + admin.getEvent("EVT001").getName());
                break;
            case 4:
                admin.createEvent("EVT001", "Tech Conference", "2025-08-01", 100);
                admin.removeEvent("EVT001");
                System.out.println("Event removed: EVT001");
                break;
            default:
                System.out.println("Invalid command");
        }
        
    }
}