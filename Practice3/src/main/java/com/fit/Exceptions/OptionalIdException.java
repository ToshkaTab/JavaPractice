package com.fit.Exceptions;

public class OptionalIdException  extends Exception{
    private int id;
    public int getId() {
        return id;
    }

    public OptionalIdException(int id){
        this.id = id;
    }
    @Override
    public String getMessage(){
        return "Факультатив с заданным id не существует в базе данных.";
    }
}
