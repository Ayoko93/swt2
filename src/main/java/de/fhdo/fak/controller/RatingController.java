package de.fhdo.fak.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.fhdo.fak.entity.Hotel;
import de.fhdo.fak.entity.Rating;
import de.fhdo.fak.entity.User;
import de.fhdo.fak.misc.SessionManager;
import de.fhdo.fak.service.HotelService;
import de.fhdo.fak.service.RatingService;
import de.fhdo.fak.service.UserService;

@Controller
public class RatingController {
	@Autowired
	private RatingService service;
	@Autowired
	private HotelService hotels;
	@Autowired
	private UserService users;

	@PostMapping("/rate")
	public String ratePost(Model model,
			@RequestParam("hotel") String hotelid,
			@RequestParam("rating") String ratingString,
			@RequestParam(value = "comment", required = false,
			defaultValue = "") String comment) {
		User user = SessionManager.instance.getUser();
        if(user == null) {
            model.addAttribute("errormsg", "Bitte loggen Sie sich ein und "
                    + "schreiben Sie die Bewertung erneut.");
            return "user-error";
		}
		
		Hotel hotel;
		try {
			long id = Long.parseLong(hotelid);
			hotel = hotels.find(id);
		} catch(NumberFormatException | NoSuchElementException e) {
			return "error";
		}

		int stars;
		try {
			stars = Integer.parseInt(ratingString);
		} catch(NumberFormatException e) {
			return "error";
		}

		Rating rating = new Rating(stars, comment.isEmpty() ? null : comment,
				user, hotel);
		hotel.addRating(rating);
		user.addRating(rating);

		service.save(rating);
		hotels.save(hotel);
		users.save(user);

		return "redirect:/bookings";
	}
}
