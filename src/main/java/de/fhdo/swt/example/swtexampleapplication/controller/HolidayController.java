package de.fhdo.swt.example.swtexampleapplication.controller;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import de.fhdo.swt.example.swtexampleapplication.service.HolidayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HolidayController {
    @Autowired
    private HolidayService service;

    @GetMapping("/")
    public String showHolidaysForm(Holiday holiday, Model model){
        Iterable<Holiday> data = service.findAll();
        model.addAttribute("holidays", data);
        model.addAttribute("recommended", data);
        return "index";
    }

    @GetMapping("/holiday/{id}")
    public String showHolidaysForm(Holiday holiday, Model model, @PathVariable long id){
        Holiday data = service.find(id);

        model.addAttribute("holiday", data);
        return "holiday-detail";
    }

}
