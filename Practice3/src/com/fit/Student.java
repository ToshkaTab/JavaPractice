package com.fit;

public class Student extends Person {
    private static int currentId = 0;
    public Student(String name, String surname){
        super(name, surname);
        this.id = currentId++;
    }
}
