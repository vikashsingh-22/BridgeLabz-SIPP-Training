// Encapsulation/LibraryManagement.java
package Encapsulation;

interface Reservable {
    void reserveItem(String itemID);
    void checkAvailability();
}

// Abstract class for Library Items
abstract class LibraryItem {
    private String itemID;
    private String title;
    private String author;
    // Encapsulation: Item details are private
    // This ensures that item details are not directly accessible from outside the class.   
    // Borrower details (secured via encapsulation)
    private String borrowerName;
    private String borrowerContact;

    public LibraryItem(String itemID, String title, String author) {
        this.itemID = itemID;
        this.title = title;
        this.author = author;
    }

    // Getters (Encapsulated access)
    public String getItemID() {
        return itemID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Borrower details (secured)
    public void setBorrowerDetails(String name, String contact) {
        this.borrowerName = name;
        this.borrowerContact = contact;
    }

    public String getBorrowerInfo() {
        return borrowerName != null ? "Borrower: " + borrowerName + ", Contact: " + borrowerContact : "Not borrowed";
    }

    // Concrete method
    public void getItemDetails() {
        System.out.println("ID: " + itemID + ", Title: " + title + ", Author: " + author);
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days
}

// Book class
class Book extends LibraryItem implements Reservable {
    public Book(String itemID, String title, String author) {
        super(itemID, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21;
    }

    @Override
    public void reserveItem(String itemID) {
        System.out.println("Book with ID " + itemID + " has been reserved.");
    }

    @Override
    public void checkAvailability() {
        System.out.println("Book is available for loan.");
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemID, String title, String author) {
        super(itemID, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String itemID) {
        System.out.println("Magazine with ID " + itemID + " has been reserved.");
    }

    @Override
    public void checkAvailability() {
        System.out.println("Magazine is currently available.");
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemID, String title, String author) {
        super(itemID, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String itemID) {
        System.out.println("DVD with ID " + itemID + " has been reserved.");
    }

    @Override
    public void checkAvailability() {
        System.out.println("DVD is available in the media section.");
    }
}

// Main Class
public class LibraryManagement {
    public static void main(String[] args) {
        LibraryItem[] items = new LibraryItem[3];
        items[0] = new Book("B001", "The Alchemist", "Paulo Coelho");
        items[1] = new Magazine("M001", "National Geographic", "Various");
        items[2] = new DVD("D001", "Inception", "Christopher Nolan");

        // Demonstrate polymorphism
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                reservableItem.reserveItem(item.getItemID());
                reservableItem.checkAvailability();
            }
            System.out.println(item.getBorrowerInfo());
            System.out.println();
        }

        // Set borrower details to demonstrate encapsulation
        items[0].setBorrowerDetails("Arjun Raghav", "9876543210");
        System.out.println("Updated Borrower Info for Book: " + items[0].getBorrowerInfo());
    }
}
