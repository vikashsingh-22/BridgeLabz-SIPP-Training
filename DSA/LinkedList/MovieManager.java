package LinkedList;

import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = this.next = null;
    }
}

class MovieList {
    Movie head = null, tail = null;

    // Add at beginning
    public void addAtBeginning(Movie newMovie) {
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at end
    public void addAtEnd(Movie newMovie) {
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(Movie newMovie, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newMovie);
            return;
        }

        Movie current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            addAtEnd(newMovie);
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            current.next.prev = newMovie;
            current.next = newMovie;
        }
    }

    // Remove by title
    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Movie removed.");
    }

    // Search by director or rating
    public void search(String director, double rating) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if ((director != null && current.director.equalsIgnoreCase(director)) ||
                (rating >= 0 && current.rating == rating)) {
                System.out.println("Found: " + current.title + " (" + current.year + "), Director: " +
                                   current.director + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No matching movies found.");
    }

    // Update rating
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Display forward
    public void displayForward() {
        Movie current = head;
        if (current == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies (Forward):");
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        Movie current = tail;
        if (current == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies (Reverse):");
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    // Helper to print a movie
    private void printMovie(Movie m) {
        System.out.println("Title: " + m.title + ", Director: " + m.director +
                ", Year: " + m.year + ", Rating: " + m.rating);
    }
}

public class MovieManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList list = new MovieList();

        while (true) {
            System.out.println("\n--- Movie Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Title");
            System.out.println("5. Search by Director or Rating");
            System.out.println("6. Update Rating by Title");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            String title, director;
            int year, pos;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    System.out.print("Rating: ");
                    rating = sc.nextDouble();
                    list.addAtBeginning(new Movie(title, director, year, rating));
                    break;

                case 2:
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    System.out.print("Rating: ");
                    rating = sc.nextDouble();
                    list.addAtEnd(new Movie(title, director, year, rating));
                    break;

                case 3:
                    System.out.print("Position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    System.out.print("Rating: ");
                    rating = sc.nextDouble();
                    list.addAtPosition(new Movie(title, director, year, rating), pos);
                    break;

                case 4:
                    System.out.print("Enter title to remove: ");
                    title = sc.nextLine();
                    list.removeByTitle(title);
                    break;

                case 5:
                    System.out.print("Enter director to search (or press Enter to skip): ");
                    director = sc.nextLine();
                    System.out.print("Enter rating to search (or -1 to skip): ");
                    rating = sc.nextDouble();
                    sc.nextLine();
                    list.search(director.isEmpty() ? null : director, rating);
                    break;

                case 6:
                    System.out.print("Enter title to update: ");
                    title = sc.nextLine();
                    System.out.print("Enter new rating: ");
                    rating = sc.nextDouble();
                    list.updateRating(title, rating);
                    break;

                case 7:
                    list.displayForward();
                    break;

                case 8:
                    list.displayReverse();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
