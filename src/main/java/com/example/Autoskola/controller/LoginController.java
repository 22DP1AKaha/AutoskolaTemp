package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Autoskola.entity.Client;
import com.example.Autoskola.repository.ClientRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private HttpSession session;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/ienakt")
    public String login() {
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            return "redirect:/profile";
        } else {
            return "login";
        }
    }

    @PostMapping("/ienakt")
    public String login(@RequestParam("E-pasts") String username, @RequestParam("parole") String password, RedirectAttributes redirectAttributes) {
        Client client = clientRepository.findByUsername(username);

        if (client != null && client.getPassword().equals(password)) {
            client.isActive = true;
            clientRepository.save(client);
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Nepareizs e-pasts vai parole");
            return "redirect:/ienakt";
        }
    }

    @GetMapping("/iziet")
    public String logout() {
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            session.invalidate();
            client.isActive = false;
            clientRepository.save(client);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/forgotpassword")
    public String forgotpassword() {
        return "forgotpassword";
    }
}
