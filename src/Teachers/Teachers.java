package Teachers;

import Teachers.Teacher;
import Teachers.TeacherComparator;

import java.util.ArrayList;
import java.util.List;

public class Teachers {
    private List<Teacher> lstTeachers=new ArrayList<>();
    public void addTeacher(Teacher t) throws Exception
    {
        if(lstTeachers.contains(t))
            throw new Exception(t.getId() + " existe déjà");
        lstTeachers.add(t);
    }
    public void showAllTeachers() throws Exception
    {
        if(lstTeachers.isEmpty())
            throw new Exception("La liste est vide");
        System.out.println("La liste des enseignants :");
        lstTeachers.forEach(System.out::println);
    }
    public void sortTeachers()
    {
        lstTeachers.sort(new TeacherComparator());
    }

}
