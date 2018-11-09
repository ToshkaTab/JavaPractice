package com.fit;

public class TeacherIdException extends Exception{
    private int id;

    public int getId() {
        return id;
    }
    
    public TeacherIdException(String message, int id){
        super(message);
        this.id = id;
    }
}
