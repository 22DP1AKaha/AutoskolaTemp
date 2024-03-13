package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Autoskola.Instructor.Instructor;
import com.example.Autoskola.Instructor.InstructorRepository;

@Controller
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;
    
    
    @GetMapping(value = "/")
    String homePage() {
        Instructor obj1  = new Instructor("John", 22);
        System.out.println(obj1.getInstructorID());
        return "index";
    }
}
