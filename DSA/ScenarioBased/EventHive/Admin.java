package ScenarioBased.EventHive;

import java.util.HashMap;
import java.util.Map;

public class Admin implements EventManager {
    private Map<String, Event> events;

    public Admin() {
        this.events = new HashMap<>();
    }

    @Override
    public void createEvent(String eventId, String name, String date, int availableTickets) {
        events.put(eventId, new Event(eventId, name, date, availableTickets));
    }

    @Override
    public void updateEvent(String eventId, String name, String date, int availableTickets) {
        Event event = events.get(eventId);
        if (event != null) {
            event.updateEvent(name, date, availableTickets);
        }
    }

    @Override
    public void removeEvent(String eventId) {
        events.remove(eventId);
    }

    public Event getEvent(String eventId) {
        return events.get(eventId);
    }
}