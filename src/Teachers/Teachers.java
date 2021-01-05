package Teachers;

import Teachers.Teacher;
import Teachers.TeacherComparator;

import java.util.ArrayList;
import java.util.Collections;
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
        lstTeachers.forEach(x->System.out.println(x));
    }
    public void sortTeachers()
    {

        lstTeachers.sort(new TeacherComparator());
        //or

        //Collections.sort(lstTeachers,new TeacherComparator());
        //or
        //lstTeachers.Sort((t1,t2)->t1.getName().compareTo(t2.getName()))
    }
    public void showAllAvgAbsence()
    {
        System.out.println("Id Enseignant   :   pourcentage abscences");

        lstTeachers.forEach(x->System.out.println(x.getId() + " : "+x.calculAvg()));
    }

}
