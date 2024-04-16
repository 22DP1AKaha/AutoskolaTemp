package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Autoskola.repository.PierakstiRepository;

@Controller
public class PierakstiController {

    @Autowired
    private PierakstiRepository pierakstiRepository;

    @GetMapping("/pieraksti")
    public String pieraksti(Model model) {
        model.addAttribute("pieraksti", pierakstiRepository.findAll());
        return "pieraksti";
    }
}
