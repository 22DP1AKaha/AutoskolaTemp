package com.example.Autoskola.controller;

import com.example.Autoskola.entity.Instructor;
import com.example.Autoskola.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/instruktori")
    public String showInstructors(Model model) {
        List<Instructor> instructors = instructorService.findAll();
        model.addAttribute("instructors", instructors);
        return "instructors"; 
    }
}
