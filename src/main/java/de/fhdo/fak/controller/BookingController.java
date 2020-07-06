package de.fhdo.fak.controller;

import de.fhdo.fak.entity.Booking;
import de.fhdo.fak.entity.Offer;
import de.fhdo.fak.entity.User;
import de.fhdo.fak.misc.SessionManager;
import de.fhdo.fak.service.BookingService;
import de.fhdo.fak.service.OfferService;
import de.fhdo.fak.service.UserService;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookingController {
    @Autowired
    private BookingService service;
    @Autowired
    private OfferService offers;
    @Autowired
    private UserService users;

    @GetMapping("/bookings")
    public String bookingsGet(Model model) {
        User user = SessionManager.instance.getUser();
        if(user == null) {
            model.addAttribute("errormsg", "Bitte loggen Sie sich ein, um "
                    + "diese Seite zu sehen.");
            return "user-error";
        } else {
            model.addAttribute("bookinglist", service.findForUser(user));
            return "bookings";
        }
    }

    @PostMapping("/book")
    public String bookPost(Model model,
            @RequestParam("offer") String offerid) {
        User user = SessionManager.instance.getUser();
        if(user == null) {
            model.addAttribute("errormsg", "Bitte loggen Sie sich ein und "
                    + "buchen Sie das Angebot erneut.");
            return "user-error";
        }

        Offer offer;
        try {
            long id = Long.parseLong(offerid);
            offer = offers.find(id);
        } catch(NumberFormatException | NoSuchElementException e) {
            return "error";
        }

        if(offer.isBooked())
            return "error";

        Booking booking = new Booking(user, offer);
        user.addBooking(booking);
        offer.setBooking(booking);

        service.save(booking);
        users.save(user);
        offers.save(offer);

        return "redirect:/bookings";
    }
}
