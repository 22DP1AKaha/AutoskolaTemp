package com.example.Autoskola.controller;

import com.example.Autoskola.entity.Client;
import com.example.Autoskola.entity.Contact;
import com.example.Autoskola.repository.ClientRepository;
import com.example.Autoskola.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactController {

    private final ContactService contactService;
    @Autowired
    private ClientRepository clientRepository;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    

    @GetMapping("/kontakti")
    public String showContacts(Model model) {
        Client client = clientRepository.findByIsActiveTrue();
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        if (client != null){    
            model.addAttribute("client", client);
        }
        return "contacts"; 
    }
}
