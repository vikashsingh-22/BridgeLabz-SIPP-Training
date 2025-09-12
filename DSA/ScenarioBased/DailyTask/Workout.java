package ScenarioBased.DailyTask;


public class Workout extends Task {
    private int durationMinutes;

    public Workout(String title, String description, int durationMinutes) {
        super(title, description);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void execute() {
        System.out.println("Executing Workout: " + title + " for " + durationMinutes + " minutes - " + description);
    }
}
