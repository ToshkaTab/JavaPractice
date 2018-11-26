package com.fit;

import java.util.GregorianCalendar;
import java.util.Scanner;
import org.apache.log4j.*;

import com.fit.Optional.*;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        init();
        display(Listener.getOptionals());
        System.out.println("Cписок всех студентов:");
        for(Student st : Listener.getStudents()){
            System.out.printf("%d - %s\n", st.getId(), st.toString());
        }
        newGradesByScanner();
        display(Listener.getOptionals());
        clientCyclo();
    }
    public static void init(){
        try {
            Listener.addTeacher(new Teacher("Ефим", "Рабинович"));
            Listener.addTeacher(new Teacher("Наталья", "Речич"));
            Listener.addTeacher(new Teacher("Виктор", "Шевченко"));

            Listener.addStudent(new Student("Алексей", "Иванов"));
            Listener.addStudent(new Student("Андрей", "Лебедев"));
            Listener.addStudent(new Student("Дмитрий", "Волков"));
            Listener.addStudent(new Student("Олег", "Соловьёв"));
            Listener.addStudent(new Student("Иван", "Дмитриев"));
            Listener.addStudent(new Student("Василий", "Михайлов"));
            Listener.addStudent(new Student("Анна", "Данилова"));
            Listener.addStudent(new Student("Александра", "Соколова"));
            Listener.addStudent(new Student("Анастасия", "Смирнова"));
            Listener.addStudent(new Student("Вадим", "Петров"));

            Teacher[] teachers = Listener.getTeachers();
            Student[] students = Listener.getStudents();


            Listener.addOptional(new Optional("Алгебра", teachers[0],
                    (new GregorianCalendar(2018, 10, 1)).getTime(),
                    (new GregorianCalendar(2018, 11, 1)).getTime(),
                    students));
            Listener.addOptional(new Optional("Геометрия", teachers[0],
                    (new GregorianCalendar(2018, 11, 1)).getTime(),
                    (new GregorianCalendar(2018, 11, 22)).getTime(),
                    new Student[]{students[0], students[4], students[7], students[8], students[9]}));
            Listener.addOptional(new Optional("Математический анализ", teachers[0],
                    (new GregorianCalendar(2018, 10, 4)).getTime(),
                    (new GregorianCalendar(2018, 11, 29)).getTime(),
                    students));
            Listener.addOptional(new Optional("Информатика", teachers[1],
                    (new GregorianCalendar(2018, 11, 2)).getTime(),
                    (new GregorianCalendar(2018, 11, 23)).getTime(),
                    new Student[]{students[2], students[3], students[4], students[5], students[9]}));
            Listener.addOptional(new Optional("Математическое моделирование", teachers[2],
                    (new GregorianCalendar(2019, 0, 1)).getTime(),
                    (new GregorianCalendar(2019, 0, 31)).getTime(),
                    students));

            initGradesByRandom();
            //initGradesByScanner();
        }
        catch (Exception e) {
            log.fatal("Начальный данные добавлены в базу не все!", e);
        }
    }
    private static void clientCyclo(){
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Cписок преподавателей:");
                for (Teacher teacher : Listener.getTeachers()) {
                    System.out.println(String.format("%d - %s", teacher.getId(), teacher));
                }
                System.out.print("\nВведите id преподавателя: ");

                Optional[] optbyTeacher = Listener.getListOfOptionalsForTeacher(in.nextInt());
                System.out.println("Результат запроса: ");
                display(optbyTeacher);
            }
            catch (Exception e) {
                log.warn(e.getMessage(), e);
            }
        }
    }
    private static void initGradesByRandom(){
        try {
            for (Optional optional : Listener.getOptionals()) {
                for (Student student : optional.getStudents()) {
                    Listener.setGrade(optional,student, (int) (Math.random() * 12 + 1));
                }
            }
        }
        catch (Exception e){
            log.warn("Не все оценки были сгененрированы", e);
        }
    }
    private static void initGradesByScanner() {
        Scanner in = new Scanner(System.in);

        for (Optional optional : Listener.getOptionals()) {
            System.out.println(optional.getName() + ": ");
            for (Student student : optional.getStudents()) {
                System.out.print(student + ": ");
                while(!Listener.setGrade(optional,student, in.nextInt())){
                    System.out.print(student + ": ");
                }
            }
            System.out.println("____");
        }

    }
    private static void newGradesByScanner() {
        System.out.println("Режим редактирования оценок: ");
        Scanner in = new Scanner(System.in);
        int idF;
        int idS;
        int grade;
         do{
            try {
                System.out.print("Введите id факультатива: ");
                idF = in.nextInt();
                System.out.print("Введите id студента: ");
                idS = in.nextInt();
                System.out.print("Введите оценку: ");
                grade = in.nextInt();
                Listener.setGrade(idF, idS, grade);

                System.out.println("Для выхода введите \"exit\"..");
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
            }
        }
        while(in.next() == "exit");
    }
    private static void display(Optional[] optionals){
        System.out.printf("%-5s%-40.8s%-30.13s%-24.19s%-24.22s%-15.14s%-30.8s%-8.6s%n%n","id","Название",
                "Преподаватель",
                "Дата начала занятий",
                "Дата окончания занятий",
                "Средняя оценка",
                "Студенты",
                "Оценки");
        for(Optional optional : optionals){
            System.out.printf("%-5d", optional.getId());
            System.out.println(optional);
        }
    }

}
