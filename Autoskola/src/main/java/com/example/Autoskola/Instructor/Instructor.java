package com.example.Autoskola.Instructor;

public class Instructor {
    private String name;
    private int age;
    private long instructorID;

    public Instructor() {
    }

    public Instructor(String name, int age, long instructorID) {
        this.name = name;
        this.age = age;
        this.instructorID = instructorID;
    }

    public Instructor(String name, int age) {
        this.name = name;
        this.age = age;
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

    public long getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(long instructorID) {
        this.instructorID = instructorID;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", instructorID=" + instructorID +
                '}';
    }
}
