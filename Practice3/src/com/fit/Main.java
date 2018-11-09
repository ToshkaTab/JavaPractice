package com.fit;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            /*new Optional("Архитектура програмного обеспечения", teachers[2],
                    sdf.parse("27.10.2018"), sdf.parse("27.11.2018"), students)*/

        //initGradesByRandom();
        initGradesByScanner();
        display(OptionalData.getOptionals());
        ClientCyclo();
    }
    private static void ClientCyclo(){
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Cписок преподавателей:");
                for (Teacher teacher : OptionalData.getTeachers()) {
                    System.out.println(String.format("%d - %s", teacher.getId(), teacher));
                }
                System.out.print("\nВведите id преподавателя: ");

                Optional[] optbyTeacher = OptionalData.getListOfOptionalsForTeacher(in.nextInt());
                System.out.println("Результат запроса: ");
                display(optbyTeacher);
            }
            catch (TeacherIdException e ){
                System.out.println(e.getMessage());
                System.out.println("Неверный id: " + e.getId());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void initGradesByRandom(){
        try {
            for (Optional optional : OptionalData.getOptionals()) {
                for (Student student : optional.getStudents()) {
                    optional.setGrade(student, (int) (Math.random() * 12 + 1));
                }
            }
        }
        catch (OptionalMarkException e){
            System.out.println(e.getMessage());
            System.out.println("Введённая оценка: " +  e.getMark());
        }
        catch (OptionalWrongStudentException e){
            System.out.println(e.getMessage());
            System.out.println("Студент: " +  e.getStudent().toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static void initGradesByScanner() {
        Scanner in = new Scanner(System.in);

        for (Optional optional : OptionalData.getOptionals()) {
            System.out.println(optional.getName() + ": ");
            for (Student student : optional.getStudents()) {
                boolean flag = true;
                while(flag){
                    System.out.print(student + ": ");
                    try {
                        optional.setGrade(student, in.nextInt());
                        flag = false;
                    } catch (OptionalMarkException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Введённая оценка: " + e.getMark());
                    } catch (OptionalWrongStudentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Студент: " + e.getStudent().toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            System.out.println("____");
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
