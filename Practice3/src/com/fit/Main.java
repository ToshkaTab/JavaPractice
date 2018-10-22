package com.fit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

            Teacher[] teachers = new Teacher[]{
                    new Teacher("Ефим", "Рабинович"),
                    new Teacher("Наталья", "Речич"),
                    new Teacher("Виктор", "Шевченко")
            };

            Student[] students = new Student[]{
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

            Optional[] optionals = new Optional[]{
                    new Optional("Алгебра", teachers[0],
                            sdf.parse("22.10.2018"), sdf.parse("22.11.2018"), students),

                    new Optional("Геометрия", teachers[0],
                            sdf.parse("23.10.2018"), sdf.parse("23.11.2018"),
                            new Student[]{students[0],students[4],students[7],students[8], students[9]}),

                    new Optional("Математический анализ", teachers[0],
                            sdf.parse("24.10.2018"), sdf.parse("24.11.2018"), students),

                    new Optional("Информатика", teachers[1],
                            sdf.parse("25.10.2018"), sdf.parse("25.11.2018"),
                            new Student[]{students[2],students[3],students[4],students[5], students[9]}),

                    new Optional("Математическое моделирование", teachers[2],
                            sdf.parse("26.10.2018"), sdf.parse("26.11.2018"), students),

                    new Optional("Архитектура програмного обеспечения", teachers[2],
                            sdf.parse("27.10.2018"), sdf.parse("27.11.2018"), students)
            };

            for(Optional optional : optionals){
                for(int i = 0; i < optional.getNumberOfStudent(); i++){
                    optional.setGrade(i, (int)(Math.random() * 12 +1));
                }
            }

            display(optionals);

            while (true) {
                System.out.println("Cписок преподавателей:");
                int index = 1;
                for(Teacher teacher : teachers){
                    System.out.println(String.format("%d) %s",index++,teacher));
                }
                System.out.print("\nВведите номер преподавателя: ");

                Optional[] optbyTeacher = Optional.getListOfOptionalsForTeacher(teachers[in.nextInt()-1]);
                System.out.println("Результат запроса: ");
                display(optbyTeacher);
            }
        }
        catch (Exception e){

        }
    }
    private static void display(Optional[] optionals){
        System.out.printf("%-40.8s%-30.13s%-24.19s%-24.22s%-15.14s%-30.8s%-8.6s%n%n","Название",
                "Преподаватель",
                "Дата начала занятий",
                "Дата окончания занятий",
                "Средняя оценка",
                "Студенты",
                "Оценки");
        for(Optional optional : optionals){
            System.out.println(optional);
        }
    }

}
