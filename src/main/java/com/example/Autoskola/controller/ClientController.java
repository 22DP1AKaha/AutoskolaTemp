package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Autoskola.Entity.Client;
import com.example.Autoskola.Entity.ClientRepository;




@Controller
public class ClientController {

    @SuppressWarnings("rawtypes")
    @Autowired
    private ClientRepository clientRepository;
    
    
    @GetMapping(value = "/client")
    String homePage() {
        Client obj1Client  = new Client("Peter", "Smith", 18, "417212-22433");
        return "index";
    }
}
