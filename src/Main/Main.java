package Main;

import Students.Students;
import Students.Student;
import Teachers.Teachers;
import Teachers.Teacher;
import Teachers.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int Menu()
    {
        int choix;
        Scanner sc =new Scanner(System.in);
        System.out.println("Selectionner un choix :");
        System.out.println("1. Gestion des enseignants");
        System.out.println("2. Gestion des étudiants");
        System.out.println("3. Quitter l'application");
        do{
            System.out.print("\t\tChoix :  ");
            choix=sc.nextInt();
        }while(choix<1||choix>3);
        return choix;
    }
    public static int teacherMenu()
    {
        int choix;
        Scanner sc =new Scanner(System.in);
        System.out.println("Selectionner un choix :");
        System.out.println("1. Ajouter un enseignant");
        System.out.println("2. Afficher Les enseignants");
        System.out.println("3. Trier les enseignats par pourcentage d'abscence");
        System.out.println("4. Visualiser l'état d'abscence des enseignants");
        System.out.println("5. Retour");
        do{
            System.out.print("\t\tChoix :  ");
            choix=sc.nextInt();
        }while(choix<1||choix>5);
        return choix;
    }
    public static int studentMenu()
    {
        int choix;
        Scanner sc =new Scanner(System.in);
        System.out.println("Selectionner un choix :");
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Afficher Les étudiants");
        System.out.println("3. Trier les étudiants par âge");
        System.out.println("4. Calculer la moyenne des tous les étudiants");
        System.out.println("5. Retour");
        do{
            System.out.print("\t\tChoix :  ");
            choix=sc.nextInt();
        }while(choix<1||choix>5);
        return choix;
    }
    public static void main(String[] args)
    {
        Students students = new Students();
        Teachers teachers = new Teachers();
        Scanner sc =new Scanner(System.in);

        int choix1,choix2,choix3;
        do {
            choix1 = Menu();
            switch (choix1) {
                case 1:
                    do {
                        choix2 = teacherMenu();
                        switch (choix2) {
                            case 1:
                                try
                                {
                                    Teacher t = new Teacher();
                                    System.out.println("Id ? ");
                                    int id=sc.nextInt();
                                    System.out.println("Name ? ");
                                    String name=sc.nextLine();
                                    name=sc.nextLine();
                                    List<Session> lstTaughts=new ArrayList<>();
                                    teachers.addTeacher(t);
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                    }while(choix2!=4);
                    break;
                case 2:
                    do {
                        choix3 = studentMenu();
                        switch (choix3) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    }while(choix3!=5);
            }
        }while(choix1!=3);
    }
}
