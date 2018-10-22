package com.fit;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Optional {
    private static Optional[] optionals = new Optional[0];
    private static int indexOptionals = 0;

    private String name;
    private Teacher teacher;
    private Date startDate;
    private Date endDate;
    private Student[] students;
    private int[] grades;


    public String getName(){
        return name;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    public Date getStartDate(){
        return startDate;
    }
    public Date getEndDate(){
        return endDate;
    }
    public int getFinalMark(int i){
        return grades[i];
    }

    public void setName(String name){
        if(name == null){
            System.exit(0);
        }
        this.name = name;
    }
    public void setTeacher(Teacher teacher){
        if(teacher == null){
            System.exit(0);
        }
        this.teacher = teacher;
    }
    public void setStartDate(Date startDate){
        if(startDate == null){
            System.exit(0);
        }
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate){
        if(endDate == null){
            System.exit(0);
        }
        this.endDate = endDate;
    }
    public void setGrade(int i, int grade){
        if(grade < 1 && grade > 12){
            System.exit(0);
        }
        this.grades[i] = grade;
    }
    public void setGrade(Student student, int grade){
        if(grade < 1 && grade > 12){
            System.exit(0);
        }
        this.grades[getStudentIndex(student)] = grade;
    }


    public Optional(String name, Teacher teacher, Date startDate, Date endDate, Student[] students){
        if(name == null || teacher == null || startDate == null || endDate == null){
            System.exit(0);
        }
        this.name = name;
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = new Student[students.length];
        int index = 0;
        for(Student student : students){
            if(student == null){
                System.exit(0);
            }
            this.students[index++] = student;
        }
        this.grades = new int[students.length];

        if(indexOptionals >= optionals.length){
            Optional[] newOptionals = new Optional[optionals.length + 1];
            int indexOptional = 0;
            for(Optional opt : optionals){
                newOptionals[indexOptional++] = opt;
            }
            optionals = newOptionals;
        }
        optionals[indexOptionals++] = this;
    }


    public static Optional[] getListOfOptionalsForTeacher(Teacher teacher){
        Optional[] teacherOptionals = new Optional[1];
        int indexArray = 0;
        for(Optional optional : optionals){
            if(optional.teacher == teacher){
                if(indexArray >= teacherOptionals.length){
                    Optional[] newOptionals = new Optional[teacherOptionals.length + 1];
                    int indexOptional = 0;
                    for(Optional opt : teacherOptionals){
                        newOptionals[indexOptional++] = opt;
                    }
                    teacherOptionals = newOptionals;
                }

                teacherOptionals[indexArray++] = optional;
            }
        }
        return teacherOptionals;
    }


    private int getStudentIndex(Student student){
        int index = -1;
        for(Student s : students){
            index++;
            if(student == s){
                return index;
            }
        }
        return -1;
    }
    public int getNumberOfStudent(){
        return students.length;
    }
    public Student getStudent(int i){
        return students[i];
    }
    public double getMeanGrade(){
        double mean = 0;
        int numOfGrades = 0;
        for(int grade : grades){
            if(grade > 0){
                mean += grade;
                numOfGrades++;
            }
        }
        mean /= numOfGrades;
        return mean;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        builder.append(String.format("%-40.39s%-30.29s%-24.23s%-24.23s%-15.14s%n", name, teacher,
                sdf.format(startDate),sdf.format(endDate),getMeanGrade()));
        int index = 0;
        for(Student student : students) {
            if(student == null) break;
            builder.append(String.format("%133s%-30.29s%2d%n", "", student, grades[index++]));
        }
        return builder.toString();
    }
}

