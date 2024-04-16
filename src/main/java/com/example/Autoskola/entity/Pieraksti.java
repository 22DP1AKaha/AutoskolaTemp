package com.example.Autoskola.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pieraksti {
   
   private String laiks;
   private String instructor;
   private boolean pierakstits;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int pierakstaID;


  
    public Pieraksti(String laiks, String instructor, boolean pierakstits){
        this.laiks = laiks;
        this.instructor= instructor;
        this.pierakstits = pierakstits;
    }

    public String getLaiks(){
        return laiks;
    }

    public void setLaiks(String laiks){
        this.laiks = laiks;
    }

    public String getInstructor(){
        return instructor;
    }

    public void setinstructor(String instructor){
        this.instructor = instructor;
    }

    public boolean getPierakstits(){
        return pierakstits;
    }

    public void setPierakstits(boolean pierakstits){
        this.pierakstits = pierakstits;
    }

    public int getInstructorID(){
        return pierakstaID;
    }

    public Pieraksti()
    {

    }

}
