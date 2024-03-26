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

    @PostMapping ("/register")
    public String Registration(@RequestParam("lietotajvards") String username, @RequestParam("parole") String password, @RequestParam("vards") String name, 
    @RequestParam("uzvards") String surname, @RequestParam("vecums") int age, @RequestParam("personaskods") String personCode){
        Client check = clientRepository.findByUsername(username);
        if (check == null){
            Client client = new Client(name, surname, age,personCode, username, password);
            clientRepository.save(client);
            return "redirect:/login";
        }
        else
        {
            return "redirect:/register";
        }
    }
}
