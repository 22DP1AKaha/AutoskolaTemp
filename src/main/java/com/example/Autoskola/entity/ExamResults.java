package com.example.Autoskola.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExamResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_username")
    private String ClientUsername;
    private int score;

    public ExamResults(){}

    public ExamResults(int score, String ClientUsername){
        this.score = score;
        this.ClientUsername = ClientUsername;
    }

    public String getClientUsername(){
        return ClientUsername;
    }
    public void setClientUsername(String ClientUsername){
        this.ClientUsername = ClientUsername;
    }
    
    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

}
