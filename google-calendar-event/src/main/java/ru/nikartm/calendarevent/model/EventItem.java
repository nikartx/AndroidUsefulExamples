package ru.nikartm.calendarevent.model;

/**
 * @author Ivan Vodyasov on 11.07.2017.
 */

public class EventItem {
    private String id;
    private String name;
    private String description;
    private long date;

    public EventItem(String id, String name, String description, long date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getDate() {
        return date;
    }
}
