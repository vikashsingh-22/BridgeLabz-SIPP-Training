package ScenarioBased.MovieTime;


import java.util.ArrayList;
import java.util.List;

public class ShowtimeManager {
    private List<ShowTime> showtimes;

    public ShowtimeManager() {
        showtimes = new ArrayList<>();
    }

    public void addShowtime(ShowTime showtime) {
        int i = showtimes.size() - 1;
        while (i >= 0 && showtimes.get(i).getTimeInMinutes() > showtime.getTimeInMinutes()) {
            i--;
        }
        // Insert at position i+1
        showtimes.add(i + 1, showtime);
    }

    public void displayShowtimes() {
        if (showtimes.isEmpty()) {
            System.out.println("No showtimes available.");
            return;
        }
        System.out.println("\nSorted Showtimes:");
        for (ShowTime showtime : showtimes) {
            System.out.println(showtime);
        }
    }

    public List<ShowTime> getShowtimes() {
        return new ArrayList<>(showtimes); 
    }
}