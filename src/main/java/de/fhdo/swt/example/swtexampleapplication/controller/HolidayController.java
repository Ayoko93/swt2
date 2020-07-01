package de.fhdo.swt.example.swtexampleapplication.controller;

import de.fhdo.swt.example.swtexampleapplication.HolidaySorting;
import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import de.fhdo.swt.example.swtexampleapplication.service.HolidayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

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


    @GetMapping("/holidays/{sorting}")
    public String showHolidaysForm(Holiday holiday, Model model, @PathVariable String sorting){
        Iterable<Holiday> data = service.findAll();
        ArrayList<Holiday> list = new ArrayList<>();
        data.forEach(h -> list.add(h));

        list.sort(HolidaySorting.createComparatorByName(sorting));

        model.addAttribute("holidays", list);
        model.addAttribute("recommendations", list);
        return "index";
    }



    @GetMapping("/holiday/{id}")
    public String showHolidaysForm(Holiday holiday, Model model, @PathVariable long id){
        Holiday data = service.find(id);

        model.addAttribute("holiday", data);
        return "holiday-detail";
    }

}
