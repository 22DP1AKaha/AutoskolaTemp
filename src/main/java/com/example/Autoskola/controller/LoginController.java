package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; 

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
    
    @GetMapping("/ienakt")
    public String login() {
        return "login"; 
    }
    
    @PostMapping("/ienakt")
    public String login(@RequestParam("E-pasts") String username, @RequestParam("parole") String password, RedirectAttributes redirectAttributes) {
        boolean isAuthenticated = authenticateUser(username, password);
        if (isAuthenticated) {
            return "redirect:/"; 
        } else {
            redirectAttributes.addFlashAttribute("error", "Nepareizs e-pasts vai parole"); 
            return "redirect:/ienakt"; 
        }
    }

    @GetMapping(value = "/forgotpassword")
    public String forgotpassword() {
        return "forgotpassword";
    }
}
