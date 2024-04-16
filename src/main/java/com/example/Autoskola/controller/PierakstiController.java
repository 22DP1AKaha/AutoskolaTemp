package com.example.Autoskola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Autoskola.entity.Pieraksti;
import com.example.Autoskola.service.PierakstiService;

@Controller
public class PierakstiController {

    @Autowired
    private PierakstiService pierakstiService;

    @GetMapping("/pieraksti")
    public String pieraksti(Model model) {
        List<Pieraksti> pieraksti = pierakstiService.findAll();
        model.addAttribute("pieraksti", pieraksti);
        return "pieraksti.html";
    }
}
