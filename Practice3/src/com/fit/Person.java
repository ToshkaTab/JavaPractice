package com.fit;

public class Person {
    protected String name;
    protected String surname;
    public String getName(){
        return name;}
    public String getSurname(){
        return surname;
    }
    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString(){
        return name + " " + surname;
    }

}
