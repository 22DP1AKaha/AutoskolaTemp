package com.example.Autoskola.entity;

import jakarta.persistence.Column;
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
    public boolean isActive;
    // public int MeginajumuSkaits;

    @Column(unique = true) 
    private String username;

    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientID;
    

    public Client(String name, String surname, int age, String personCode, String username, String password){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.personCode = personCode;
        this.username = username;
        this.password = password;
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

    public int getAge(){ 
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getPersonCode(){ 
        return personCode;
    }

    public void setPersonCode(String personCode){
        this.personCode = personCode;
    }
    public long getClientID(){
        return clientID;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Client(){
        
    }
}
