package com.example.Autoskola.controller.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    private String name;
    private String surname;
    private int age;
    private String personCode;
    private String lietotajvards;
    private String parole;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientID;
    

    public Client(String name, String surname, int age, String personCode, String lietotajvards, String parole){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.personCode = personCode;
        this.lietotajvards = lietotajvards;
        this.parole = parole;
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
    public long getClientID(){
        return clientID;
    }
    public String getLietotajvards(){
        return lietotajvards;
    }
    public String getParole(){
        return parole;
    }

    public Client(){
        
    }

}
