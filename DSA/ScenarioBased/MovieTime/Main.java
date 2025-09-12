// MovieTime – Theater Show Listings (Insertion Sort)
// Story: A movie theater allows users to sort upcoming showtimes. Since shows are added
// throughout the day and the existing list is almost sorted, the app uses Insertion Sort to insert
// each new show in the correct time slot.
// Concepts Involved:
// ● Insertion Sort
// ● Real-time insertion
// ● Time-based ordering
package ScenarioBased.MovieTime;

public class Main {
    public static void main(String[] args) {
        ShowtimeManager manager = new ShowtimeManager();

        ShowTime[] newShows = {
            new ShowTime("12:30 PM", "Inception"),
            new ShowTime("11:15 AM", "Interstellar"),
            new ShowTime("3:00 PM", "Dune"),
            new ShowTime("9:45 AM", "Blade Runner")
        };

        for (ShowTime show : newShows) {
            System.out.println("\nAdding show: " + show);
            manager.addShowtime(show);
            manager.displayShowtimes();
        }
    }
}