package Teachers;

import Teachers.Teacher;
import Teachers.TeacherComparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
    //classic version
    public void sortTeachers()
    {

        lstTeachers.sort(new TeacherComparator());
        //or

        //Collections.sort(lstTeachers,new TeacherComparator());
    }
    //since java 8 version
    public void sortTeachers_V2()
    {
        lstTeachers.sort(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if(o1.calculAvg() > o2.calculAvg())
                    return 1;
                else if(o1.calculAvg() < o2.calculAvg())
                    return -1;
                else return 0;
            }
        });
    }


    public List<Teacher> sortTeachersByName()
    {
        //return lstTeachers.stream()
        //       .sorted(Comparator.comparing(o -> o.getName()))
        //        .collect(Collectors.toList());

        //or
        return lstTeachers.stream()
                .sorted(Comparator.comparing(Teacher::getName))
                .collect(Collectors.toList());
    }public List<Teacher> sortTeachersByNameReversed()
    {
        return lstTeachers.stream()
                .sorted(Comparator.comparing(Teacher::getName)
                .reversed())
                .collect(Collectors.toList());
    }
    public void showAllAvgAbsence()
    {
        System.out.println("Id Enseignant   :   pourcentage abscences");

        lstTeachers.forEach(x->System.out.println(x.getId() + " : "+x.calculAvg()));
    }
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    public void addAbscenceSession() throws NotFoundException, ExistException, ParseException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Id de l'enseignant ? ");
        final int id=sc.nextInt();
        Optional<Teacher> res=lstTeachers.stream()
                .filter(t->t.getId()==id)
                .findFirst();
        if(res.isEmpty())
            throw new NotFoundException("L'enseignant avec id "+ id+ " n'est pas trouvé");
        Teacher teacher=res.get();
        System.out.println("Id séance ? ");
        int idSession = sc.nextInt();
        Session session=new Session();
        session.setId(idSession);
        if(lstTeachers.contains(session))
            throw new ExistException("Cette séances existe déjà");
        System.out.println("Nom séance ? ");
        String name= sc.nextLine();
        System.out.println("Date de la séance ('yyyy-MM-dd HH:mm')");
        String date = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime date1= LocalDateTime.parse(date,formatter);
        double duration=sc.nextDouble();
        session.setName(name);
        session.setDate(date1);
        session.setDuration(duration);
        int status;
        do {
            System.out.println("1- Assurée\t2- Non assurée ?");
            status = sc.nextInt();
        }while(status<1||status>2);
        int teacherIndex=lstTeachers.indexOf(teacher);
        if(status ==1)
            lstTeachers.get(teacherIndex).getTaughtSessions().add(session);
        else
            lstTeachers.get(teacherIndex).getAbsentSessions().add(session);

        System.out.println("Session Ajoutée avec succès...");
    }

}
