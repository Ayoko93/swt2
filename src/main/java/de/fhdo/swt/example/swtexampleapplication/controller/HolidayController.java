package de.fhdo.swt.example.swtexampleapplication.controller;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import de.fhdo.swt.example.swtexampleapplication.entity.Holidays;
import de.fhdo.swt.example.swtexampleapplication.entity.RecommendedHotels;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolidayController {

    @GetMapping("/")
    public String showHolidaysForm(Holiday holiday, Model model){
        model.addAttribute("holidays", new Holidays());
        model.addAttribute("recommendations", new RecommendedHotels());
        return "index";
    }



}
