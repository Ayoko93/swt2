package de.fhdo.swt.example.swtexampleapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/login")
    public String userForm(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String createUser(Model model) {
        return "registration";
    }
}
