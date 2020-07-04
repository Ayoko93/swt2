package de.fhdo.fak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImpressumController {

    @GetMapping("/impressum")
    public String showImpressumPage(Model model)
    {
        return "impressum";

    }
}
