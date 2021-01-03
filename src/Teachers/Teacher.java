package Teachers;

import interfaces.ICalcul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Teacher implements ICalcul {
    private int id;
    private String name;
    private ArrayList<Session> taughtSessions=new ArrayList<>();
    private ArrayList<Session> AbsentSessions =new ArrayList<>();

    public Teacher() {

    }

    public Teacher(int id, String name, ArrayList<Session> taughtSessions, ArrayList<Session> absentSessions) {
        this.id = id;
        this.name = name;
        this.taughtSessions = taughtSessions;
        AbsentSessions = absentSessions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Session> getTaughtSessions() {
        return taughtSessions;
    }

    public void setTaughtSessions(ArrayList<Session> taughtSessions) {
        this.taughtSessions = taughtSessions;
    }

    public ArrayList<Session> getAbsentSessions() {
        return AbsentSessions;
    }

    public void setAbsentSessions(ArrayList<Session> absentSessions) {
        AbsentSessions = absentSessions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taughtSessions=" + taughtSessions +
                ", AbsentSessions=" + AbsentSessions +
                '}';
    }

    @Override
    public double calculAvg() {
        return this.AbsentSessions.size()/(this.taughtSessions.size()+this.AbsentSessions.size());
    }
}
