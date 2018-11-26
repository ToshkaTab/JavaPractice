package com.fit.Optional;

import com.fit.Exceptions.*;
import org.apache.log4j.*;

public class Listener {
    private static final Logger log = Logger.getLogger(Listener.class);

    public static Optional[] getOptionals(){
        return OptionalData.getOptionals();
    }
    public static Teacher[] getTeachers(){
        return OptionalData.getTeachers();
    }
    public static Student[] getStudents(){
        return OptionalData.getStudents();
    }

    public static void addOptional(Optional optional){
        try{
            OptionalData.addOptional(optional);
        }
        catch (NullPointerException e){
            log.error(e.getMessage());
        }
    }
    public static void addTeacher(Teacher teacher){
        try{
            OptionalData.addTeacher(teacher);
        }
        catch (NullPointerException e){
            log.error(e.getMessage());
        }
    }
    public static void addStudent(Student student){
        try{
            OptionalData.addStudent(student);
        }
        catch (NullPointerException e){
            log.error(e.getMessage());
        }
    }
    public static boolean setGrade(Optional optional, Student student, int grade){
        try{
            optional.setGrade(student,grade);
            return true;
        }
        catch (OptionalMarkException e){
            log.error(e.getMessage() + " Введённая оценка: " +  e.getMark());
        }
        catch (OptionalWrongStudentException e){
            log.error(e.getMessage() + " Студент: " +  e.getStudent().toString());
        }
        catch (NullPointerException e){
            log.error(e.getMessage(), e);
        }
        return false;
    }
    public static boolean setGrade(int optionalId, int studentId, int grade){
        try{
            OptionalData.getOptional(optionalId).setGrade(OptionalData.getStudent(studentId),grade);
            return true;
        }
        catch (OptionalMarkException e){
            log.error(e.getMessage() + " Введённая оценка: " +  e.getMark());
        }
        catch (OptionalWrongStudentException e){
            log.error(e.getMessage() + " Студент: " +  e.getStudent().toString());
        }
        catch (OptionalIdException e){
            log.error(e.getMessage() + " id: " +  e.getId());
        }
        catch (StudentIdException e){
            log.error(e.getMessage() + " id: " +  e.getId());
        }
        catch (NullPointerException e){
            log.error(e.getMessage(), e);
        }
        return false;
    }
    public static Optional[] getListOfOptionalsForTeacher(int teacherId){
        Optional[] optionals = null;
        try{
            optionals = OptionalData.getListOfOptionalsForTeacher(teacherId);
        }
        catch (TeacherIdException e){
            log.error(e.getMessage() + " id: " +  e.getId());
        }
        return optionals;
    }
}
