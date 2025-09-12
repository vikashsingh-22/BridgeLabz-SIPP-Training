// Q2_Book.java
// Sample Program 2: Library Management System
// Demonstrates static, this, final, and instanceof best practices

public class Q2_Book {
    private static String libraryName = "City Library";
    private final String isbn;
    private String title;
    private String author;

    public Q2_Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        Q2_Book book1 = new Q2_Book("Java Basics", "John Doe", "12345");
        Object obj = book1;
        if (obj instanceof Q2_Book) {
            ((Q2_Book) obj).displayDetails();
        }
        Q2_Book.displayLibraryName();
    }
}
