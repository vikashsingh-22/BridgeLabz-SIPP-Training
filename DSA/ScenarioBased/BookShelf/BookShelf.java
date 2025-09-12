package ScenarioBased.BookShelf;

import java.util.*;

public class BookShelf {
    private HashMap<String, LinkedList<Book>> catalog;
    private HashSet<String> isbnSet;

    public BookShelf() {
        catalog = new HashMap<>();
        isbnSet = new HashSet<>();
    }

    public boolean addBook(String genre, Book book) {
        if (isbnSet.contains(book.getIsbn())) {
            System.out.println("Book with ISBN " + book.getIsbn() + " already exists.");
            return false;
        }

        LinkedList<Book> books = catalog.computeIfAbsent(genre, k -> new LinkedList<>());
        books.add(book);
        isbnSet.add(book.getIsbn());
        System.out.println("Added " + book.getTitle() + " to " + genre);
        return true;
    }

    public boolean removeBook(String genre, String isbn) {
        LinkedList<Book> books = catalog.get(genre);
        if (books == null) {
            System.out.println("Genre " + genre + " not found.");
            return false;
        }

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                isbnSet.remove(isbn);
                System.out.println("Removed book with ISBN " + isbn + " from " + genre);
                if (books.isEmpty()) {
                    catalog.remove(genre);
                }
                return true;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found in " + genre);
        return false;
    }

    public boolean borrowBook(String genre, String isbn) {
        LinkedList<Book> books = catalog.get(genre);
        if (books == null) {
            System.out.println("Genre " + genre + " not found.");
            return false;
        }

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Borrowed " + book.getTitle() + " from " + genre);
                return removeBook(genre, isbn);
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found in " + genre);
        return false;
    }

    public boolean returnBook(String genre, Book book) {
        return addBook(genre, book);
    }

    public void displayGenre(String genre) {
        LinkedList<Book> books = catalog.get(genre);
        if (books == null || books.isEmpty()) {
            System.out.println("No books found in " + genre);
            return;
        }

        System.out.println("Books in " + genre + ":");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Catalog is empty.");
            return;
        }

        for (Map.Entry<String, LinkedList<Book>> entry : catalog.entrySet()) {
            System.out.println("Genre: " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println("  " + book);
            }
        }
    }
}