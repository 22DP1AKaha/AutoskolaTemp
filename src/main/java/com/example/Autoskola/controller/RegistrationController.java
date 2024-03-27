package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Autoskola.controller.Entity.Client;
import com.example.Autoskola.controller.Entity.ClientRepository;

@Controller
public class RegistrationController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/registreties")
    public String register(@RequestParam("E-pasts") String username, @RequestParam("parole") String password, @RequestParam("vards") String name, 
    @RequestParam("uzvards") String surname, @RequestParam("vecums") int age, @RequestParam("personaskods") String personCode) {
        boolean isRegistrationSuccessful = registerNewClient(username, password, name, surname, age, personCode);
        if (isRegistrationSuccessful) {
            return "redirect:/ienakt";
        } else {
            return "redirect:/registreties?error";
        }
    }

    private boolean registerNewClient(String username, String password, String name, String surname, int age, String personCode) {
        Client existingClient = clientRepository.findByUsername(username);
        if (existingClient == null) {
            Client newClient = new Client(name, surname, age, personCode, username, password);
            clientRepository.save(newClient);
            return true; 
        }
        return false;
    }
}
