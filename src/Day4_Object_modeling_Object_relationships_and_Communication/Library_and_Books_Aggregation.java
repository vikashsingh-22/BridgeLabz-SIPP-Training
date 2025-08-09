import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            System.out.println(" - " + b);
        }
    }
}
public class Library_and_Books_Aggregation {

    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("Clean Code", "Robert C. Martin");
        Book book3 = new Book("Effective Java", "Joshua Bloch");

        Library library1 = new Library("City Library");
        Library library2 = new Library("College Library");

        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2); 
        library2.addBook(book3);

        library1.showBooks();
        System.out.println();
        library2.showBooks();
    }
}
