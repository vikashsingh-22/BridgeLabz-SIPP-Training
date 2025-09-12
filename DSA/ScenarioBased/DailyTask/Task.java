package ScenarioBased.DailyTask;

public abstract class Task {
    protected String title;
    protected String description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}