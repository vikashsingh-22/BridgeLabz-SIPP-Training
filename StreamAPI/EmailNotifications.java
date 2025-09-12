package StreamAPI;

import java.util.*;

public class EmailNotifications {
    static void sendEmailNotification(String email) {
        System.out.println("Email sent to: " + email);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();

        System.out.print("Enter number of emails: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter email: ");
            emails.add(sc.nextLine());
        }

        System.out.println("\nSending Notifications:");
        emails.forEach(email -> sendEmailNotification(email));
    }
}
