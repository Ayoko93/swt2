package de.fhdo.fak.controller;

import de.fhdo.fak.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {


    @GetMapping("/bookings")
    public String showBookingForm(Model model){



        return "bookings";
    }


}
