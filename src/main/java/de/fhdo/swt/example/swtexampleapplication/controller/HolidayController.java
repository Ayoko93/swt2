package de.fhdo.swt.example.swtexampleapplication.controller;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import de.fhdo.swt.example.swtexampleapplication.entity.Holidays;
import de.fhdo.swt.example.swtexampleapplication.entity.RecommendedHotels;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HolidayController {

    @GetMapping("/")
    public String showHolidaysForm(Holiday holiday, Model model){
        model.addAttribute("holidays", new Holidays());
        model.addAttribute("recommendations", new RecommendedHotels());
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
