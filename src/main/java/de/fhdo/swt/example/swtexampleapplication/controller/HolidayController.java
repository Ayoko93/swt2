package de.fhdo.swt.example.swtexampleapplication.controller;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import de.fhdo.swt.example.swtexampleapplication.service.HolidayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolidayController {
    @Autowired
    private HolidayService service;

    @GetMapping("/")
    public String showHolidaysForm(Holiday holiday, Model model){
        Iterable<Holiday> data = service.findAll();
        model.addAttribute("holidays", data);
        model.addAttribute("recommendations", data);
        return "index";
    }
}
