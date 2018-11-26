package com.fit.Optional;

public class Person {
    protected int id;
    protected String name;
    protected String surname;

    public int getId() {
        return id;
    }
    public String getName(){ return name;}
    public String getSurname(){
        return surname;
    }

    public Person(String name, String surname){
        if(name == null || surname == null){
            throw new NullPointerException("Ссылка не должна быть null");
        }
        this.name = name;
        this.surname = surname;
    }


    @Override
    public String toString(){
        return name + " " + surname;
    }

}
