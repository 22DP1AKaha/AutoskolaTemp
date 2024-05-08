package com.example.Autoskola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Autoskola.entity.Client;
import com.example.Autoskola.entity.Contact;
import com.example.Autoskola.repository.ClientRepository;
import com.example.Autoskola.service.ContactService;
import com.example.Autoskola.service.SupportService;


@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private SupportService supportService;

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

    @GetMapping("/palidziba")
    public String support(Model model){
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null){
            return "support";
        }else{
            return "redirect:/login";
        }
    }

    @PostMapping("/sutitZinu")
    public String support(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("message") String message, RedirectAttributes redirectAttributes) {
        supportService.ReciveEmail(message, email, name);
        redirectAttributes.addFlashAttribute("success", "Message");
        
        supportService.sendEmail(email, name);
        return "redirect:/palidziba";
    }
    
}
