package JavaConstructors.Level1;

public class Library {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public Library(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;  
    }

    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
