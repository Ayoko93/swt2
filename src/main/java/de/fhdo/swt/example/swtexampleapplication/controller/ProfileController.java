package de.fhdo.swt.example.swtexampleapplication.controller;

import de.fhdo.swt.example.swtexampleapplication.entity.User;
import de.fhdo.swt.example.swtexampleapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IModel;

import javax.jws.soap.SOAPBinding;

@Controller
public class ProfileController {
    @Autowired
    private UserService service;

    @GetMapping("/profile")
    public String showUserProfilePage(Model model)
    {
        User user = service.find(0);
        model.addAttribute("profile", user);
        return "profile";

    }

}
