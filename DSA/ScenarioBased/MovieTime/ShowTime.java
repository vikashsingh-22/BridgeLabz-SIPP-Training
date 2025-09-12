package ScenarioBased.MovieTime;

public class ShowTime {
    private String time; // Time in HH:MM AM/PM format
    private int runtime; // Time in minutes since midnight
    private String movie; // Movie title

    public ShowTime(String time, String movie) {
        this.time = time;
        this.runtime = TimeUtil.timeToMinutes(time);
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return time + " - " + movie;
    }

    public int getTimeInMinutes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTimeInMinutes'");
    }
}