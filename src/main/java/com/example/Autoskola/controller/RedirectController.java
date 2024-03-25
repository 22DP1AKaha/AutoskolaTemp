package com.example.Autoskola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RedirectController {

    @GetMapping("/register")
    public String redirectToNewPage() {
        return "register";
    }
}