package com.fit;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Optional  {
    private static int currentId = 0;

    private int id;
    private String name;
    private Teacher teacher;
    private Date startDate;
    private Date endDate;
    private Student[] students;
    private int[] grades;

    public int getId() {
        return id;
    }
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
    public Student[] getStudents() {
        return Arrays.copyOf(students, students.length);
    }
    public int getFinalMark(int i){
        if(i >= grades.length || i < 0){
        throw new IllegalArgumentException("Номер студента не соответствует количеству студентов или является отрицательным");
        }
        return grades[i];
    }

    public void setName(String name){
        if(name == null){
            throw new NullPointerException("Ссылка не должна быть null");
        }
        this.name = name;
    }
    public void setTeacher(Teacher teacher){
        if(teacher == null){
            throw new NullPointerException("Ссылка не должна быть null");
        }
        this.teacher = teacher;
    }
    public void setStartDate(Date startDate){
        if(startDate == null){
            throw new NullPointerException("Ссылка не должна быть null");
        }
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate){
        if(endDate == null){
            throw new NullPointerException("Ссылка не должна быть null");
        }
        this.endDate = endDate;
    }
    public void setGrade(int i, int grade) throws OptionalMarkException {
        if(grade < 1 || grade > 12){
            throw new OptionalMarkException(grade);
        }
        if(i >= grades.length || i < 0){
            throw new IllegalArgumentException("Номер студента не соответствует количеству студентов или является отрицательным.");
        }
        this.grades[i] = grade;
    }
    public void setGrade(Student student, int grade) throws OptionalMarkException, OptionalWrongStudentException {
        if(grade < 1 || grade > 12){
            throw new OptionalMarkException(grade);
        }
        if(student == null){
            throw new NullPointerException("Ссылка не должна быть null.");
        }
        int index = getStudentIndex(student);
        if(index == -1){
            throw new OptionalWrongStudentException("Студент не посещает данный факультатив.", student);
        }
        this.grades[index] = grade;
    }

    public Optional(String name, Teacher teacher, Date startDate, Date endDate, Student[] students){
        if(name == null || teacher == null || startDate == null || endDate == null){
            throw new NullPointerException("Ссылка не должна быть null");
        }
        this.name = name;
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = new Student[students.length];
        int index = 0;
        for(Student student : students){
            if(student == null){
                throw new NullPointerException("Ссылка не должна быть null");
            }
            this.students[index++] = student;
        }
        this.grades = new int[students.length];
        this.id = currentId++;

        OptionalData.addOptional(this);
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
    public int getNumberOfStudents(){
        return students.length;
    }


    public double getMeanGrade(){
        double mean = 0;
        int numOfGrades = 0;
        for(int grade : grades){
            if(grade != 0){
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

