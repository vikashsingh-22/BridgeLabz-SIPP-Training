package ScenarioBased.DailyTask;


public class Meeting extends Task {
    private String location;

    public Meeting(String title, String description, String location) {
        super(title, description);
        this.location = location;
    }

    @Override
    public void execute() {
        System.out.println("Executing Meeting: " + title + " at " + location + " - " + description);
    }
}
