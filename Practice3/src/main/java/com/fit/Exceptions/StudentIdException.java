package com.fit.Exceptions;

public class StudentIdException extends Exception{
    private int id;
    public int getId() {
        return id;
    }

    public StudentIdException(int id){
        this.id = id;
    }
    @Override
    public String getMessage(){
        return "Студент с заданным id не существует в базе данных.";
    }
}
