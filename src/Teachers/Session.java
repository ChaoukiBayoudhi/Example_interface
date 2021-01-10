package Teachers;

import java.time.LocalDateTime;
import java.util.Objects;

public class Session {
    private int id;
    private String name;
    private LocalDateTime date;
    private double duration;

    public Session(int id, String name, LocalDateTime date, double duration) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.duration = duration;
    }

    public Session() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session)) return false;
        Session session = (Session) o;
        return id == session.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
