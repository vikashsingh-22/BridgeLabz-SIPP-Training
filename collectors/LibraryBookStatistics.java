package collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

public class LibraryBookStatistics {

    // Helper record for the example
    record Book(String genre, int pages) {}

    public static void main(String[] args) {
        System.out.println("5. Library Book Statistics");

        List<Book> books = Arrays.asList(
                new Book("Fiction", 350),
                new Book("Science", 500),
                new Book("Fiction", 420),
                new Book("Fantasy", 650),
                new Book("Science", 480),
                new Book("Fantasy", 700)
        );

        // Groups books by genre and provides a summary of page counts for each genre
        // using Collectors.summarizingInt().
        Map<String, IntSummaryStatistics> pageStatsByGenre = books.stream()
                .collect(Collectors.groupingBy(
                        Book::genre,
                        Collectors.summarizingInt(Book::pages)
                ));

        System.out.println("Book page statistics by genre:");
        pageStatsByGenre.forEach((genre, stats) -> {
            System.out.println("  Genre: " + genre);
            System.out.println("    Total Pages: " + stats.getSum());
            System.out.println("    Average Pages: " + stats.getAverage());
            System.out.println("    Maximum Pages: " + stats.getMax());
        });
    }
}
