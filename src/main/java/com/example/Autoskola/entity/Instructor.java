package com.example.Autoskola.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instructorID;
    private String name;
    private int age;
    private String photoUrl;
    private String pricePerSession; 

    public Instructor() {}

    public Instructor(String name, int age, String photoUrl, String pricePerSession) {
        this.name = name;
        this.age = age;
        this.photoUrl = photoUrl;
        this.pricePerSession = pricePerSession;
    }

    public long getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(long instructorID) {
        this.instructorID = instructorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPricePerSession() {
        return pricePerSession;
    }

    public void setPricePerSession(String pricePerSession) {
        this.pricePerSession = pricePerSession;
    }

    @Override
    public String toString() {
        return "Instructor{" +
               "instructorID=" + instructorID +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", photoUrl='" + photoUrl + '\'' +
               ", pricePerSession=" + pricePerSession +
               '}';
    }
}
