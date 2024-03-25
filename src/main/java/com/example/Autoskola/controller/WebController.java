package com.example.Autoskola.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index"; // assuming your HTML file is named index.html
    }

    @GetMapping("/par")
    public String about() {
        return "about"; // this should be the name of your about template
    }

    @GetMapping("/kontakti")
    public String contacts() {
        return "contacts"; // this should be the name of your contacts template
    }

    @GetMapping("/ienakt")
    public String login() {
        return "login"; // this should be the name of your login template
    }
}
