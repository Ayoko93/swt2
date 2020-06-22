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
        model.addAttribute("recommendations", data);
        return "index";
    }

    @GetMapping("/holiday/{id}")
    public String showHolidaysForm(Holiday holiday, Model model, @PathVariable long id){
        RecommendedHotels hotels = new RecommendedHotels();
        Holiday h = hotels.stream().filter((h1) -> h1.getId() == id).findFirst().get();

        model.addAttribute("holiday", h);
        return "holiday-detail";
    }

}
