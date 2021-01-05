package Students;

import interfaces.ICalcul;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Student implements ICalcul {
    private int id;
    private String name;
    private LocalDate birthDate;
    private ArrayList<Mark> lstMarks=new ArrayList<>();

    public Student() {

    }

    public Student(int id, String name, ArrayList<Mark> lstMarks) {
        this.id = id;
        this.name = name;
        this.lstMarks = lstMarks;
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

    public ArrayList<Mark> getLstMarks() {
        return lstMarks;
    }

    public void setLstMarks(ArrayList<Mark> lstMarks) {
        this.lstMarks = lstMarks;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public long evaluateAge()
    {

        return ChronoUnit.DAYS.between(LocalDate.now(),birthDate);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lstMarks=" + lstMarks +
                '}';
    }

    @Override
    public double calculAvg() {
        return lstMarks.stream()
                .map(x->x.getValue()*x.getCoefficient())
                .reduce(0.0d, Double::sum)/lstMarks.stream()
                .map(x->x.getCoefficient())
                .reduce(0.0d, Double::sum);
    }
}
