package com.fit.Exceptions;

public class TeacherIdException extends Exception{
    private int id;
    public int getId() {
        return id;
    }

    public TeacherIdException(int id){
        this.id = id;
    }
    @Override
    public String getMessage(){
        return "Учитель с заданным id не ведёт никакой факультатив, или не существует.";
    }
}
