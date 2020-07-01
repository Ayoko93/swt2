package de.fhdo.swt.example.swtexampleapplication.controller;

import de.fhdo.swt.example.swtexampleapplication.entity.OfferFinder;
import de.fhdo.swt.example.swtexampleapplication.sorting.OfferComparatorFactory;
import de.fhdo.swt.example.swtexampleapplication.entity.Offer;
import de.fhdo.swt.example.swtexampleapplication.service.OfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class OfferController {
    @Autowired
    private OfferService service;

    @GetMapping("/")
    public String showHolidaysForm(Offer holiday, Model model,
            @RequestParam(value = "search_min_cost", required = false, defaultValue = "") String minConst,
            @RequestParam(value = "search_max_cost", required = false, defaultValue = "") String maxCost,
            @RequestParam(value = "search_continent", required = false, defaultValue = "") String continent,
            @RequestParam(value = "search_country", required = false, defaultValue = "") String country,
            @RequestParam(value = "search_city", required = false, defaultValue = "") String city,
            @RequestParam(value = "search_start_date", required = false, defaultValue = "") String startDate,
            @RequestParam(value = "search_end_date", required = false, defaultValue = "") String endDate,
            @RequestParam(value = "search_person", required = false, defaultValue = "") String person) {
        double minC = (minConst.isEmpty()) ? 0 : Double.parseDouble(minConst);
        double maxC = (maxCost.isEmpty()) ? Double.MAX_VALUE : Double.parseDouble(maxCost);
        int countPerson = (person.isEmpty()) ? 0 : Integer.parseInt(person);

        ArrayList<Offer> selectedHolidays = new OfferFinder()
                .searchForHolidays(service, minC, maxC, continent, country,
                city, startDate, endDate, countPerson);
        
        model.addAttribute("search_min_cost", minConst);
        model.addAttribute("search_max_cost", maxCost);
        model.addAttribute("search_continent", continent);
        model.addAttribute("search_country", country);
        model.addAttribute("search_city", city);
        model.addAttribute("search_start_date", startDate);
        model.addAttribute("search_end_date", endDate);
        model.addAttribute("search_person", person);
        model.addAttribute("holidays", selectedHolidays);
        model.addAttribute("recommendations", selectedHolidays);
        return "index";
    }

    @GetMapping("/holidays/{sorting}")
    public String showHolidaysForm(Offer holiday, Model model, @PathVariable String sorting) {
        Iterable<Offer> data = service.findAll();
        ArrayList<Offer> list = new ArrayList<>();
        data.forEach(h -> list.add(h));

        list.sort(OfferComparatorFactory.createComparatorByName(sorting));

        model.addAttribute("holidays", list);
        model.addAttribute("recommendations", list);
        return "index";
    }


    @GetMapping("/holiday/{id}")
    public String showHolidaysForm(Offer holiday, Model model, @PathVariable long id) {
        Offer data = service.find(id);

        model.addAttribute("holiday", data);
        return "holiday-detail";
    }
}