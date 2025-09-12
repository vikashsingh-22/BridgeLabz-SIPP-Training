package Inheritance.SingleInheritance;

// Superclass: Book
class Book {
    String title;
    int publicationYear;

    // Constructor for Book
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book info
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass: Author (extends Book)
class Author extends Book {
    String name;
    String bio;

    // Constructor for Author
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); 
        this.name = name;
        this.bio = bio;
    }

    // Override displayInfo to include author details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display book info
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author bookWithAuthor = new Author(
            "The Intelligent Investor",
            1949,
            "Benjamin Graham",
            "Benjamin Graham was a British-born investor."
        );

        // Display full information
        bookWithAuthor.displayInfo();
    }
}

