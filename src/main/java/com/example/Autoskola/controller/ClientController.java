package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Autoskola.Client.Client;
import com.example.Autoskola.Instructor.Instructor;
import com.example.Autoskola.Instructor.InstructorRepository;

@Controller
public class ClientController {

    // @Autowired
    // private ClientRepository clientRepository;
    
    
    @GetMapping(value = "/")
    String homePage() {
        Client obj1Client  = new Client("Peter", "Smith", 18, "417212-22433");
        System.out.println(obj1Client.getClientID());
        return "index";
    }
}
