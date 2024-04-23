package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Autoskola.entity.Client;
import com.example.Autoskola.repository.ClientRepository;
import java.util.List;



@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    

    @GetMapping("/profile")
    public String aboutProfile(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "profile";

    }
    public String showProfile(Model model) {
        String loggedInUsername = "testuser";

        Client client = clientRepository.findByUsername(loggedInUsername);
       

        model.addAttribute("user", client);

        return "profile";
    }
}

