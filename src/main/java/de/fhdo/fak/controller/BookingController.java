package de.fhdo.fak.controller;

import de.fhdo.fak.entity.Booking;
import de.fhdo.fak.entity.Hotel;
import de.fhdo.fak.entity.Offer;
import de.fhdo.fak.entity.User;
import de.fhdo.fak.service.OfferService;
import de.fhdo.fak.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.Date;


@Controller
public class BookingController {

    @Autowired
    private RatingService service;

    @GetMapping("/bookings")
    public String showBookingForm(Model model){

        Hotel h = new Hotel();
        h.setName("djkvghyvdfjhovyjuhkiyvv");
        h.setImagePath("fvsouhifsvy<huoi<vdfpio");
        h.setDescription("ygljiuyfhöi");

        User u = new User();
        u.setFirstName("Thimo");
        u.setLastName("Whitefarmer");

        Offer o = new Offer();
        o.setPricePerDay(1234);
        o.setHotel(h);
        o.setStartDate(new Date());
        o.setEndDate(new Date());
        o.setCurrency("€");
        o.setTravelDuration(23);

        Booking b = new Booking();
        b.setUser(u);
        b.setOffer(o);

        ArrayList<Booking> list = new ArrayList<>();
        list.add(b);


        model.addAttribute("bookinglist", list);


        return "bookings";
    }


}
