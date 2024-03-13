package com.example.Autoskola.Client;

public class Client {
    private String name;
    private String surname;
    private int age;
    private String personCode;
    private int date;

    public Client(String name, String surname, int age, String personCode, int date ){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.personCode = personCode;
        this.date = date;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public int age(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String personCode(){
        return personCode;
    }

    public void setPersonCode(String personCode){
        this.personCode = personCode;
    }

    public int date(){
        return date;
    }

    public void setDate(int date){
        this.date = date;
    }

}
