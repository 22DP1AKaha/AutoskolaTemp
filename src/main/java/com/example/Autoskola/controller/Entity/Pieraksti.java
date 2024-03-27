package com.example.Autoskola.controller.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pieraksti {
   
   private String laiks;
   private String instructor;
   private boolean pierakstits;
   private int pierakstaID;


  
    public Pieraksts(String laiks, String instructor, boolean pierakstits, int pierakstaID){
        this.laiks = laiks;
        this.instructor= instructor;
        this.pierakstits = pierakstits;
        this.pierakstaID = pierakstaID;
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

    public void setPierakstits(boolean pierakstis){
        this.pierakstits = pierakstits;
    }

    public int getInstructorID(){
        return pierakstaID;
    }

    public void setPierakstaID(int pierakstaID){
        this.pierakstaID = pierakstaID;
    }

}
