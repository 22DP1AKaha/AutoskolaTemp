package com.example.Autoskola.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

     @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute Client updatedClient) {
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            client.setName(updatedClient.getName());
            client.setSurname(updatedClient.getSurname());
            client.setAge(updatedClient.getAge());
            client.setUsername(updatedClient.getUsername());
            client.setPersonCode(updatedClient.getPersonCode());
            if (updatedClient.getPassword() != null && !updatedClient.getPassword().isEmpty()) {
                client.setPassword(updatedClient.getPassword());
            }
            clientRepository.save(client);
        }
        return "redirect:/profils";
    }

    @GetMapping("/DzestProfilu")
    public String deleteProfile() {
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            clientRepository.delete(client); // Deleting the client from the database
        }
        return "redirect:/"; // Redirecting the user to the starting page
    }
}

