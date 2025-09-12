package ScenarioBased.DailyTask;


public class CodingSession extends Task {
    private String programmingLanguage;

    public CodingSession(String title, String description, String programmingLanguage) {
        super(title, description);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void execute() {
        System.out.println("Executing Coding Session: " + title + " in " + programmingLanguage + " - " + description);
    }
}