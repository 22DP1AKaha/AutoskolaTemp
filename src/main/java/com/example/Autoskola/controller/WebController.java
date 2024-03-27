package com.example.Autoskola.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index"; 
    }

    @GetMapping("/par")
    public String about() {
        return "about"; 
    }

    @GetMapping("/kontakti")
    public String contacts() {
        return "contacts"; 
    }

    @GetMapping("/ienakt")
    public String login() {
        return "login"; 
    }

    @GetMapping("/registreties")
    public String register() {
        return "register";
    }
}
