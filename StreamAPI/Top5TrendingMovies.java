package StreamAPI;

import java.util.*;
import java.util.stream.*;

class Movie {
    private String name;
    private int releaseYear;
    private double rating;

    public Movie(String name, int releaseYear, double rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public int getReleaseYear() { return releaseYear; }
    public double getRating() { return rating; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + releaseYear + ") - Rating: " + rating;
    }
}

public class Top5TrendingMovies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter movie name: ");
            String name = sc.nextLine();
            System.out.print("Enter release year: ");
            int year = sc.nextInt();
            System.out.print("Enter rating: ");
            double rating = sc.nextDouble();
            sc.nextLine();
            movies.add(new Movie(name, year, rating));
        }

        List<Movie> top5 = movies.stream()
                .filter(m -> m.getReleaseYear() >= 2020)
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nTop 5 Trending Movies:");
        top5.forEach(System.out::println);
    }
}
