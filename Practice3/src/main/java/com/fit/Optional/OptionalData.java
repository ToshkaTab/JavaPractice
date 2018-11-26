package com.fit.Optional;

import com.fit.Exceptions.OptionalIdException;
import com.fit.Exceptions.StudentIdException;
import com.fit.Exceptions.TeacherIdException;

import java.util.Arrays;

class OptionalData {
    private static Optional[] optionals = new Optional[0];
    private static Teacher[] teachers = new Teacher[0];
    private static Student[] students = new Student[0];

    public static Optional[] getOptionals(){
        return Arrays.copyOf(optionals, optionals.length);
    }
    public static Teacher[] getTeachers(){
        return Arrays.copyOf(teachers, teachers.length);
    }
    public static Student[] getStudents(){
        return Arrays.copyOf(students, students.length);
    }

    static void addOptional(Optional optional){
        if(optional == null){
            throw new NullPointerException("Ссылка на факультатив не должна быть null");
        }

        optionals = Arrays.copyOf(optionals, optionals.length + 1);
        optionals[optionals.length-1] = optional;
    }

    static void addTeacher(Teacher teacher){
        if(teacher == null){
            throw new NullPointerException("Ссылка на учителя не должна быть null");
        }

        teachers = Arrays.copyOf(teachers, teachers.length + 1);
        teachers[teachers.length-1] = teacher;
    }

    static void addStudent(Student student){
        if(student == null){
            throw new NullPointerException("Ссылка на студента не должна быть null");
        }

        students = Arrays.copyOf(students, students.length + 1);
        students[students.length-1] = student;
    }
    public static Optional getOptional(int optionalId) throws OptionalIdException {
        for(Optional opt : optionals){
            if(opt.getId() == optionalId){
                return opt;
            }
        }
        throw new OptionalIdException(optionalId);
    }
    public static Student getStudent(int studentId)throws StudentIdException{
        for(Student st : students){
            if(st.getId() == studentId){
                return st;
            }
        }
        throw new StudentIdException(studentId);
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
            throw new TeacherIdException(teacherId);
        }
        teacherOptionals = Arrays.copyOf(teacherOptionals, index);
        return teacherOptionals;
    }
}
