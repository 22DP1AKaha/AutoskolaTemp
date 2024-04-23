package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Autoskola.entity.Client;
import com.example.Autoskola.repository.ClientRepository;

@Controller
public class RegistrationController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/registreties")
    public String register() {
        return "register";
    }
    public String showRegistrationForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Lietotājs ar šādu e-pastu jau eksistē.");
        }
        return "registreties";
    }

    @PostMapping("/registreties")
    public String register(@RequestParam("E-pasts") String username, @RequestParam("parole") String password, 
                           @RequestParam("vards") String name, @RequestParam("uzvards") String surname, 
                           @RequestParam("vecums") int age, @RequestParam("personaskods") String personCode, 
                           Model model) {
        boolean isRegistrationSuccessful = registerNewClient(username, password, name, surname, age, personCode);
        if (isRegistrationSuccessful) {
            return "redirect:/ienakt";
        } else {
            model.addAttribute("error", "Lietotājs ar šādu e-pastu jau eksistē.");
            return "redirect:/registreties";
        }
    }

    private boolean registerNewClient(String username,  String password, String name, String surname, int age, String personCode) {
        if (clientRepository.findByUsername(username) == null) {
            Client newClient = new Client(name, surname, age, personCode, username, password);
            clientRepository.save(newClient);
            return true;
        }
        return false;
    }
}
