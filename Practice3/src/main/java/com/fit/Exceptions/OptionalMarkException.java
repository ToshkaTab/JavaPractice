package com.fit.Exceptions;

public class OptionalMarkException extends Exception {
    private int mark;

    public int getMark() {
        return mark;
    }

    public OptionalMarkException(int mark){
        this.mark = mark;
    }
    @Override
    public String getMessage(){
        return "Оценка должна быть в диапазоне от 1 до 12.";
    }
}