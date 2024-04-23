package com.example.Autoskola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Autoskola.entity.Client;
import com.example.Autoskola.repository.ClientRepository;
import org.springframework.ui.Model;



@Controller
public class WebController {
    @Autowired
    private ClientRepository clientRepository;
    private Client client; 
    

    @GetMapping("/")
    public String home() {
        client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            if(client.isActive = false) {
                return "index";
            }
            else {
                return "index_loggedIn";
            }
        }
        return "index"; 
    }

    @GetMapping("/par")
    public String about(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "about"; 
    }   


}
