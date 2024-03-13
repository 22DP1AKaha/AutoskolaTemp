package com.example.Autoskola.Client;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    private String name;
    private String surname;
    private int age;
    private LocalDate date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String personCode;
    

    public Client(String name, String surname, int age, String personCode, LocalDate date ){
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

    public LocalDate date(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

}
