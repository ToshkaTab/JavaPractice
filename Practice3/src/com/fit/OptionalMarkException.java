package com.fit;

public class OptionalMarkException extends Exception {
    private int mark;

    public int getMark() {
        return mark;
    }


    public OptionalMarkException(String message, int mark){
        super(message);
        this.mark = mark;
    }
}