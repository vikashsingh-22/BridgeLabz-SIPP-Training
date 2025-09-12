package ScenarioBased.MovieTime;

public class TimeUtil {
    public static int timeToMinutes(String timeStr) {
        try {
            String[] parts = timeStr.split(" ");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid time format. Use 'HH:MM AM/PM'");
            }
            String[] timeParts = parts[0].split(":");
            if (timeParts.length != 2) {
                throw new IllegalArgumentException("Invalid time format. Use 'HH:MM AM/PM'");
            }
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            String period = parts[1].toUpperCase();

            if (hours < 1 || hours > 12 || minutes < 0 || minutes > 59) {
                throw new IllegalArgumentException("Invalid time values.");
            }
            if (!period.equals("AM") && !period.equals("PM")) {
                throw new IllegalArgumentException("Period must be AM or PM.");
            }

            if (period.equals("PM") && hours != 12) {
                hours += 12;
            } else if (period.equals("AM") && hours == 12) {
                hours = 0;
            }
            return hours * 60 + minutes;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid time format. Use 'HH:MM AM/PM'");
        }
    }

    public static String minutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        String period = hours < 12 ? "AM" : "PM";
        if (hours == 0) {
            hours = 12;
        } else if (hours > 12) {
            hours -= 12;
        }
        return String.format("%d:%02d %s", hours, mins, period);
    }
}