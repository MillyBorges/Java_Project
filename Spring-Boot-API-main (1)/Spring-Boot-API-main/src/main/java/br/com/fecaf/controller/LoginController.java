package br.com.fecaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {



    @GetMapping("/titanium.html")
    public String login() {
        return "titanium.html";
    }

    @GetMapping("/home")
    public String home() {
        return "home.html";
    }
}


