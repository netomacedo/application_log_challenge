package com.example.logs_challenge.model;
import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    private String id;
    @Transient
    private String state;
    private String type;
    private String host;
    @Column(name = "event_duration")
    private Long timestamp;
    private Boolean alert;

    public Event() {}

    public Event(String id) {
        this.id = id;
    }

    public Event(String id, String state, String type, String host, Long timestamp) {
        this.id = id;
        this.state = state;
        this.type = type;
        this.host = host;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getAlert() {
        return alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        return getId().equals(event.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Event{" +
                ", id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", timestamp=" + timestamp +
                ", alert=" + alert +
                '}';
    }
}
