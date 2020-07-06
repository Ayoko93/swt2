package de.fhdo.fak.controller;

import de.fhdo.fak.misc.OfferFinder;
import de.fhdo.fak.sorting.OfferComparatorFactory;
import de.fhdo.fak.entity.Offer;
import de.fhdo.fak.service.OfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Controller
public class OfferController {
    @Autowired
    private OfferService service;

    @GetMapping("/")
    public String indexGet(Offer holiday, Model model,
            @RequestParam(value = "search_min_cost", required = false, defaultValue = "") String minConst,
            @RequestParam(value = "search_max_cost", required = false, defaultValue = "") String maxCost,
            @RequestParam(value = "search_continent", required = false, defaultValue = "") String continent,
            @RequestParam(value = "search_country", required = false, defaultValue = "") String country,
            @RequestParam(value = "search_city", required = false, defaultValue = "") String city,
            @RequestParam(value = "search_start_date", required = false, defaultValue = "") String startDate,
            @RequestParam(value = "search_end_date", required = false, defaultValue = "") String endDate,
            @RequestParam(value = "search_person", required = false, defaultValue = "") String person,
            @RequestParam(value = "sorting", required = false, defaultValue = "") String sorting) {
        double minC = (minConst.isEmpty()) ? 0 : Double.parseDouble(minConst);
        double maxC = (maxCost.isEmpty()) ? Double.MAX_VALUE : Double.parseDouble(maxCost);
        int countPerson = (person.isEmpty()) ? 0 : Integer.parseInt(person);

        ArrayList<Offer> offers = new OfferFinder().searchForOffers(service,
                minC, maxC, continent, country, city, startDate, endDate,
                countPerson);
        offers.sort(OfferComparatorFactory.create(sorting));
        
        model.addAttribute("search_min_cost", minConst);
        model.addAttribute("search_max_cost", maxCost);
        model.addAttribute("search_continent", continent);
        model.addAttribute("search_country", country);
        model.addAttribute("search_city", city);
        model.addAttribute("search_start_date", startDate);
        model.addAttribute("search_end_date", endDate);
        model.addAttribute("search_person", person);
        model.addAttribute("sorting", sorting);
        model.addAttribute("recommendations", offers);
        return "index";
    }

    @GetMapping("/offer/{id}")
    public String offerGet(Offer holiday, Model model, @PathVariable long id) {
        try {
            Offer offer = service.find(id);
            model.addAttribute("offer", offer);
            return "offer-detail";
        } catch(NoSuchElementException e) {
            return "error";
        }
    }
}