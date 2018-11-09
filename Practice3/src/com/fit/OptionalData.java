package com.fit;

import java.util.Arrays;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OptionalData {
    private static Optional[] optionals = new Optional[0];
    private static Teacher[] teachers = new Teacher[0];
    private static Student[] students = new Student[0];

    static {
        teachers = new Teacher[]{
                new Teacher("Ефим", "Рабинович"),
                new Teacher("Наталья", "Речич"),
                new Teacher("Виктор", "Шевченко")
        };

       students = new Student[]{
                new Student("Алексей", "Иванов"),
                new Student("Андрей", "Лебедев"),
                new Student("Дмитрий", "Волков"),
                new Student("Олег", "Соловьёв"),
                new Student("Иван", "Дмитриев"),
                new Student("Василий", "Михайлов"),
                new Student("Анна", "Данилова"),
                new Student("Александра", "Соколова"),
                new Student("Анастасия", "Смирнова"),
                new Student("Вадим", "Петров")
        };
        optionals = new Optional[]{
                new Optional("Алгебра", teachers[0],
                        (new GregorianCalendar(2018,10,1)).getTime(),
                        (new GregorianCalendar(2018,11,1)).getTime(),
                        students),

                new Optional("Геометрия", teachers[0],
                        (new GregorianCalendar(2018,11,1)).getTime(),
                        (new GregorianCalendar(2018,11,22)).getTime(),
                        new Student[]{students[0], students[4], students[7], students[8], students[9]}),

                new Optional("Математический анализ", teachers[0],
                        (new GregorianCalendar(2018,10,4)).getTime(),
                        (new GregorianCalendar(2018,11,29)).getTime(),
                        students),

                new Optional("Информатика", teachers[1],
                        (new GregorianCalendar(2018,11,2)).getTime(),
                        (new GregorianCalendar(2018,11,23)).getTime(),
                        new Student[]{students[2], students[3], students[4], students[5], students[9]}),

                new Optional("Математическое моделирование", teachers[2],
                        (new GregorianCalendar(2019,0,1)).getTime(),
                        (new GregorianCalendar(2019,0,31)).getTime(),
                        students),
        };

    }

    public static Optional[] getOptionals(){
        return Arrays.copyOf(optionals, optionals.length);
    }
    public static Teacher[] getTeachers(){
        return Arrays.copyOf(teachers, teachers.length);
    }
    public static Student[] getStudents(){
        return Arrays.copyOf(students, students.length);
    }

    public static void addOptional(Optional optional){
        if(optional == null){
            throw new NullPointerException("Ссылка на факультатив не должна быть null");
        }

        optionals = Arrays.copyOf(optionals, optionals.length + 1);
        optionals[optionals.length-1] = optional;
    }

    public static void addTeacher(Teacher teacher){
        if(teacher == null){
            throw new NullPointerException("Ссылка на учителя не должна быть null");
        }

        teachers = Arrays.copyOf(teachers, teachers.length + 1);
        teachers[teachers.length-1] = teacher;
    }

    public static void addStudent(Student student){
        if(student == null){
            throw new NullPointerException("Ссылка на студента не должна быть null");
        }

        students = Arrays.copyOf(students, students.length + 1);
        students[students.length-1] = student;
    }

    public static Optional[] getListOfOptionalsForTeacher(int teacherId) throws TeacherIdException {
        Optional[] teacherOptionals = new Optional[optionals.length];
        int index = 0;

        for(Optional optional : optionals){
            if(optional.getTeacher().getId() == teacherId){
                teacherOptionals[index++] = optional;
            }
        }
        if(index == 0){
            throw new TeacherIdException("Учитель с заданным id не ведёт никакой факультатив, или не существует.",
                    teacherId);
        }
        teacherOptionals = Arrays.copyOf(teacherOptionals, index);
        return teacherOptionals;
    }
}
