package sayem_2221728_BandMember;

import java.io.Serializable;
import java.time.LocalDate;

public class EventSchedule implements Serializable {
    String eventTitle, description, time, location, giveaway;
    LocalDate date;

    public EventSchedule(String eventTitle, String description, LocalDate date, String time, String location, String giveaway) {
        this.eventTitle = eventTitle;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
        this.giveaway = giveaway;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGiveaway() {
        return giveaway;
    }

    public void setGiveaway(String giveaway) {
        this.giveaway = giveaway;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EventSchedule: ");
        sb.append("\neventTitle=").append(eventTitle);
        sb.append("\n description=").append(description);
        sb.append("\n time=").append(time);
        sb.append("\n location=").append(location);
        sb.append("\n giveaway=").append(giveaway);
        sb.append("\n date=").append(date);
        sb.append("\n");
        return sb.toString();
    }

    
}
