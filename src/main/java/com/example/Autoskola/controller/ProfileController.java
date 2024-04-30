package com.example.Autoskola.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Autoskola.entity.Client;
import com.example.Autoskola.repository.ClientRepository;
import org.springframework.ui.Model;




    
@Controller
public class ProfileController {
    @Autowired
    private ClientRepository clientRepository;
    
    @GetMapping("/profils")
    public String aboutProfile(Model model) { 
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null){    
            model.addAttribute("client", client);
            return "profile"; 
        }
        return "redirect:/"; 
    }

    @GetMapping("/RedigetProfilu")
    public String editProfile(Model model){
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null){    
            model.addAttribute("client", client);
            return "edit_profile"; 
        }
        return "redirect:/"; 
    }
}

