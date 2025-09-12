package JavaConstructors.AccessModifiers.Book;

class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("978-1234567890", "Java Basics", "James Gosling");
        ebook.display();
        System.out.println("Author: " + ebook.getAuthor());
        ebook.setAuthor("Joshua Bloch");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}
