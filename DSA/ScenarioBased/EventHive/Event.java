package ScenarioBased.EventHive;

public class Event {
    private String eventId;
    private String name;
    private String date;
    private int availableTickets;

    public Event(String eventId, String name, String date, int availableTickets) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.availableTickets = availableTickets;
    }

    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public Ticket registerUser(User user) {
        if (availableTickets > 0) {
            availableTickets--;
            return new Ticket("TCK" + System.currentTimeMillis(), user, this);
        }
        return null;
    }

    public void updateEvent(String name, String date, int availableTickets) {
        this.name = name;
        this.date = date;
        this.availableTickets = availableTickets;
    }
}
