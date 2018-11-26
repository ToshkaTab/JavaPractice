package com.fit.Exceptions;

import com.fit.Optional.Student;

public class OptionalWrongStudentException extends Exception {
    private Student student;

    public Student getStudent() {
        return student;
    }


    public OptionalWrongStudentException(String message, Student student){
        super(message);
        this.student = student;
    }
}
