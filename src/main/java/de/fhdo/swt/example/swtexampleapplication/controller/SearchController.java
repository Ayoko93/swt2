package de.fhdo.swt.example.swtexampleapplication.controller;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import de.fhdo.swt.example.swtexampleapplication.entity.HolidayFinder;
import de.fhdo.swt.example.swtexampleapplication.entity.User;
import de.fhdo.swt.example.swtexampleapplication.misc.SessionManager;
import de.fhdo.swt.example.swtexampleapplication.service.HolidayService;
import de.fhdo.swt.example.swtexampleapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
public class SearchController {

    @Autowired
    private HolidayService service;

    @GetMapping("/search")
    public String showSearchPage(Model model) {
        return "search";
    }


    @PostMapping("/search")
    public String showSearchPage(HttpServletRequest request,
                                 @RequestParam("search_min_cost") String minConst,
                                 @RequestParam("search_max_cost") String maxCost,
                                 @RequestParam("search_continent") String continent,
                                 @RequestParam("search_country") String country,
                                 @RequestParam("search_city") String city,
                                 @RequestParam("search_start_date") String startDate,
                                 @RequestParam("search_end_date") String endDate,
                                 @RequestParam("search_person") String person) {


        double minC = (minConst.isEmpty()) ? 0 : Double.parseDouble(minConst);
        double maxC = (maxCost.isEmpty()) ? 0 : Double.parseDouble(maxCost);
        int countPerson = (person.isEmpty()) ? 0 : Integer.parseInt(person);


        ArrayList<Holiday> selectedHolidays = new HolidayFinder().serchForHolidays(service, minC, maxC, continent, country, city, startDate, endDate, countPerson);

        return "search";
    }
}
