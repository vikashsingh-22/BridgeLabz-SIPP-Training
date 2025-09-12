package ScenarioBased.EventHive;

public interface EventManager {
    void createEvent(String eventId, String name, String date, int availableTickets);
    void updateEvent(String eventId, String name, String date, int availableTickets);
    void removeEvent(String eventId);
}
