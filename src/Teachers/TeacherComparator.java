package Teachers;

import java.util.Comparator;

public class TeacherComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        if(o1.calculAvg()>o2.calculAvg())
            return 1;
        else
        if(o1.calculAvg()<o2.calculAvg())
            return -1;
        return 0;
    }
}
