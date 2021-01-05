package Students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Students {
    private List<Student> lstStudents=new ArrayList<>();

    public void addStudent(Student st) throws Exception
    {
        if(lstStudents.contains(st))
            throw new Exception(st.getId() + " existe déjà");
        lstStudents.add(st);
    }
    public void showAllStudents() throws Exception
    {
        if(lstStudents.isEmpty())
            throw new Exception("La liste est vide");
        System.out.println("La liste des étudiants :");
        lstStudents.forEach(System.out::println);
    }
    public void sortStudents()
    {
        lstStudents.sort(new StudentComparator());//ordre ascendant
        //lstStudents.sort((new StudentComparator()).reversed());//ordre descendant
    }
    public void showAllStudentsAvg()
    {
        System.out.println("Id Etudiant   :   Moyenne");
        lstStudents.forEach(x->System.out.println(x.getId()+" : "+x.calculAvg()));
    }
}
