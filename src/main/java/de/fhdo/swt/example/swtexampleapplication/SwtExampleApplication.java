package de.fhdo.swt.example.swtexampleapplication;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import de.fhdo.swt.example.swtexampleapplication.entity.HolidayProfile;
import de.fhdo.swt.example.swtexampleapplication.entity.Hotel;
import de.fhdo.swt.example.swtexampleapplication.entity.Rating;
import de.fhdo.swt.example.swtexampleapplication.entity.User;
import de.fhdo.swt.example.swtexampleapplication.service.EntityService;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories("de.fhdo.swt.example.swtexampleapplication.repository")
@EntityScan("de.fhdo.swt.example.swtexampleapplication.entity")
public class SwtExampleApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SwtExampleApplication.class, args);
	}

	@Autowired
	private EntityService<Hotel> hotelService;
	@Autowired
	private EntityService<Holiday> holidayService;
	@Autowired
	private EntityService<HolidayProfile> holidayProfileService;
	@Autowired
	private EntityService<Rating> ratingService;
	@Autowired
	private EntityService<User> userService;

	private void resetTestData() {
		hotelService.deleteAll();
		holidayService.deleteAll();
		holidayProfileService.deleteAll();
		ratingService.deleteAll();
		userService.deleteAll();

		Hotel hotel = new Hotel("Amerika", "Mexiko", "Akumal",
				"Quantina Roo 10", "Bahia Principe Luxury Akumal", "Ein Hauch von Luxus und Exklusivität direkt am Strand: " +
				"der perfekte Ort für alle, die erstklassigen Service in einem Hotel am Meeresufer suchen. Der dazugehörige Golfplatz und die modernen Ferienchalets bietet Exklusivität on top.");
		hotel.setImagePath("/img/Luxury_Bahia_Principe.jfif");

		Hotel hotel2 = new Hotel("Afrika", "Ägypten", "Hurghada", "Street 5", "Albatros White Beach", "White Beach Resort ist ein modernes Resort erbaut auf mehr als 80.000m² Grundfläche. " +
				"In einer ruhigen Umgebung und mit Blick auf das Meer werden Sie Ihren Traumurlaub genießen können. ");
		hotel2.setImagePath("/img/Albatros_White_Beach.jpg");

		hotelService.save(hotel);
		hotelService.save(hotel2);

		Holiday holiday1 = new Holiday();
		holiday1.setCurrency("Euro");
		holiday1.setPricePerDay(160);
		holiday1.setPriceModel("ABC");
		holiday1.setTravelAgency("ABC Travel");
		holiday1.setStartDate(Date.from(Instant.now()));
		holiday1.setEndDate(Date.from(Instant.now()));
		holiday1.setTravelDuration(14);

		Holiday holiday2 = new Holiday();
		holiday2.setCurrency("Euro");
		holiday2.setPricePerDay(150);
		holiday2.setPriceModel("ABC");
		holiday2.setTravelAgency("ABC Travel");
		holiday2.setStartDate(Date.from(Instant.now()));
		holiday2.setEndDate(Date.from(Instant.now()));

		holiday2.setTravelDuration(10);

		Holiday holiday3 = new Holiday();
		holiday3.setHotel(hotel);
		holiday3.setCurrency("Euro");
		holiday3.setPricePerDay(140);
		holiday3.setPriceModel("all-inclusive");
		holiday3.setTravelAgency("DER Touristik");
		holiday3.setStartDate(Date.from(Instant.now()));
		holiday3.setEndDate(Date.from(Instant.now()));
		holiday3.setTravelDuration(20);

		holidayService.save(holiday1);
		holidayService.save(holiday2);
		holidayService.save(holiday3);

		hotel.addHoliday(holiday1);
		hotel2.addHoliday(holiday2);
		hotelService.save(hotel);
		hotelService.save(hotel2);

		User user = new User("Preuschoff", "Jan","preuschoffjan@gmail.com", "123456");
		userService.save(user);
	}

	@Override
	public void run(String... args) throws Exception {
		resetTestData();
	}
}
