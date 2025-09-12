package ScenarioBased.BookShelf;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        Scanner scanner = new Scanner(System.in);

        // Pre-populate some books for demonstration
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        Book book2 = new Book("1984", "George Orwell", "978-0451524935");
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", "978-0141439518");
        Book book4 = new Book("Animal Farm", "George Orwell", "978-0451524935");

        bookShelf.addBook("Fiction", book1);
        bookShelf.addBook("Fiction", book2);
        bookShelf.addBook("Romance", book3);
        bookShelf.addBook("Fiction", book4);

        while (true) {
            System.out.println("\n=== BookShelf Library System ===");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Display books in a genre");
            System.out.println("6. Display entire catalog");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                continue;
            }

            switch (choice) {
                case 1: // Add a book
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    Book newBook = new Book(title, author, isbn);
                    bookShelf.addBook(genre, newBook);
                    break;

                case 2: // Remove a book
                    System.out.print("Enter genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    bookShelf.removeBook(genre, isbn);
                    break;

                case 3: // Borrow a book
                    System.out.print("Enter genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    bookShelf.borrowBook(genre, isbn);
                    break;

                case 4: // Return a book
                    System.out.print("Enter genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    bookShelf.returnBook(genre, new Book(title, author, isbn));
                    break;

                case 5: // Display books in a genre
                    System.out.print("Enter genre: ");
                    genre = scanner.nextLine();
                    bookShelf.displayGenre(genre);
                    break;

                case 6: // Display entire catalog
                    bookShelf.displayCatalog();
                    break;

                case 7: // Exit
                    System.out.println("Exiting BookShelf Library System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}