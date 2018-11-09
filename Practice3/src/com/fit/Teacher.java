package com.fit;

public class Teacher extends Person{
    private static int currentId = 0;
    public Teacher(String name, String surname){
        super(name, surname);
        this.id = currentId++;
    }
}
