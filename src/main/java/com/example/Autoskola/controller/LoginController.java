package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Autoskola.controller.Entity.Client;
import com.example.Autoskola.controller.Entity.ClientRepository;

@Controller
public class LoginController {
    @Autowired
    private ClientRepository clientRepository;

    private boolean authenticateUser(String username, String password) {
        Client existingClient = clientRepository.findByUsernameAndPassword(username, password);
        return existingClient != null; 
    }
    
    @PostMapping("/ienakt")
    public String login(@RequestParam("E-pasts") String username, @RequestParam("parole") String password) {
        boolean isAuthenticated = authenticateUser(username, password);
        if (isAuthenticated) {
            return "redirect:/";
        } else {
            return "redirect:/login?error";
        }
    }

    
}