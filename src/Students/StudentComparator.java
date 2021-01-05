package Students;

import java.util.Comparator;
import java.util.List;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        return (int)(o1.evaluateAge()- o2.evaluateAge());
    }
}
