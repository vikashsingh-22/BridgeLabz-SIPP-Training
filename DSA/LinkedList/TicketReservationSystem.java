package LinkedList;


import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add new ticket at end
    public void addTicket(int id, String name, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, name, movie, seat, time);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        System.out.println("Ticket booked successfully.");
    }

    // Remove ticket by ID
    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head, prev = tail;
        boolean found = false;

        do {
            if (current.ticketId == id) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket not found.");
            return;
        }

        // Single ticket case
        if (head == tail && head.ticketId == id) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            tail.next = head;
        } else if (current == tail) {
            prev.next = head;
            tail = prev;
        } else {
            prev.next = current.next;
        }

        System.out.println("Ticket ID " + id + " removed.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("\nBooked Tickets:");
        do {
            printTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search ticket by customer name or movie name
    public void searchTicket(String customer, String movie) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if ((customer != null && temp.customerName.equalsIgnoreCase(customer)) ||
                (movie != null && temp.movieName.equalsIgnoreCase(movie))) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No matching tickets found.");
        }
    }

    // Count total tickets
    public void totalTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets Booked: " + count);
    }

    private void printTicket(Ticket t) {
        System.out.println("ID: " + t.ticketId + ", Name: " + t.customerName + ", Movie: " + t.movieName +
                ", Seat: " + t.seatNumber + ", Time: " + t.bookingTime);
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\n--- Ticket Reservation Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int remId = sc.nextInt();
                    system.removeTicket(remId);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Search by (1) Customer Name or (2) Movie Name: ");
                    int opt = sc.nextInt(); sc.nextLine();
                    if (opt == 1) {
                        System.out.print("Enter Customer Name: ");
                        String cust = sc.nextLine();
                        system.searchTicket(cust, null);
                    } else if (opt == 2) {
                        System.out.print("Enter Movie Name: ");
                        String mov = sc.nextLine();
                        system.searchTicket(null, mov);
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;

                case 5:
                    system.totalTickets();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
