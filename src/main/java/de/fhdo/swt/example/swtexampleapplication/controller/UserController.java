package de.fhdo.swt.example.swtexampleapplication.controller;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import de.fhdo.swt.example.swtexampleapplication.entity.User;
import de.fhdo.swt.example.swtexampleapplication.misc.SessionManager;
import de.fhdo.swt.example.swtexampleapplication.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/profile")
    public String showUserProfilePage(Model model) {
        Long uid = (Long)SessionManager.instance.get("user");
        if(uid == null)
            return "no-account";

        User user;
        try {
            user = service.find(uid);
        } catch(NoSuchElementException e) {
            return "no-account";
        }

        model.addAttribute("profile", user);
        return "profile";
    }

    @GetMapping("/logout")
    public String logout() {
        SessionManager.instance.set("user", null);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest request,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        Iterator<User> user = service.findByLogin(email, password).iterator();
        if(user.hasNext()) {
            SessionManager.instance.set("user", user.next().getId());
            request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE,
                    HttpStatus.FOUND);
            return "redirect:profile";
        } else
            return "login";
    }

    @GetMapping("/registration")
    public String registerGet(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerPost(HttpServletRequest request,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("password") String password,
            @RequestParam("email") String email) {
        User user = new User(lastName, firstName, email, password);
        service.save(user);
        SessionManager.instance.set("user", user.getId());
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.FOUND);
        return "redirect:profile";
    }
}
