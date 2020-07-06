package de.fhdo.fak;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.fhdo.fak.entity.Offer;
import de.fhdo.fak.entity.Rating;
import de.fhdo.fak.entity.Booking;
import de.fhdo.fak.entity.Hotel;
import de.fhdo.fak.entity.User;
import de.fhdo.fak.service.BookingService;
import de.fhdo.fak.service.HotelService;
import de.fhdo.fak.service.OfferService;
import de.fhdo.fak.service.RatingService;
import de.fhdo.fak.service.UserService;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories("de.fhdo.fak.repository")
@EntityScan("de.fhdo.fak.entity")
public class FAKApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(FAKApplication.class, args);
	}

	@Autowired
	private HotelService hotelService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private RatingService ratingService;
	@Autowired
	private UserService userService;
	@Autowired
	private BookingService bookingService;

	@SuppressWarnings("unused")
	private void resetTestData() {
		hotelService.deleteAll();
		offerService.deleteAll();
		ratingService.deleteAll();
		userService.deleteAll();
		bookingService.deleteAll();

		Hotel hotel1 = new Hotel();
		hotel1.setContinent("Nordamerika");
		hotel1.setCountry("Mexiko");
		hotel1.setCity("Akumal");
		hotel1.setStreet("Quantina Roo 10");
		hotel1.setName("Bahia Principe Luxury Akumal");
		hotel1.setImagePath("/img/Luxury_Bahia_Principe.jfif");
		hotel1.setDescription("Ein Hauch von Luxus und Exklusivität direkt am "
				+ "Strand: der perfekte Ort für alle, die erstklassigen "
				+ "Service in einem Hotel am Meeresufer suchen. Der "
				+ "dazugehörige Golfplatz und die modernen Ferienchalets "
				+ "bietet Exklusivität on top.");

		Hotel hotel2 = new Hotel();
		hotel2.setContinent("Afrika");
		hotel2.setCountry("Ägypten");
		hotel2.setCity("Hurghada");
		hotel2.setStreet("Street 5");
		hotel2.setName("Albatros White Beach");
		hotel2.setImagePath("/img/Albatros_White_Beach.jpg");
		hotel2.setDescription("White Beach Resort ist ein modernes Resort "
				+ "erbaut auf mehr als 80.000m² Grundfläche. In einer ruhigen "
				+ "Umgebung und mit Blick auf das Meer werden Sie Ihren "
				+ "Traumurlaub genießen können. ");

		Hotel hotel3 = new Hotel();
		hotel3.setContinent("Asien");
		hotel3.setCountry("Vereinigte Arabische Emirate");
		hotel3.setCity("Abu Dhabi");
		hotel3.setStreet("Street 5");
		hotel3.setName("Jumeirah at Etihad Towers Hotel");
		hotel3.setImagePath("/img/Etihad_Towers.jpg");
		hotel3.setDescription("Jumeirah at Etihad Towers - erleben Sie "
				+ "modernsten Luxus, authentische Gastfreundschaft und "
				+ "Service nach Ihren persönlichen Wünschen an der ersten "
				+ "Adresse Abu Dhabis, der Corniche.");	

		hotelService.save(hotel1);
		hotelService.save(hotel2);
		hotelService.save(hotel3);

		Offer offer1 = new Offer();
		offer1.setCurrency("Euro");
		offer1.setPricePerDay(160);
		offer1.setPriceModel("ABC");
		offer1.setTravelAgency("ABC Travel");
		offer1.setStartDate(Date.from(Instant.now()));
		offer1.setEndDate(Date.from(Instant.now()));
		offer1.setTravelDuration(14);

		Offer offer2 = new Offer();
		offer2.setCurrency("Euro");
		offer2.setPricePerDay(150);
		offer2.setPriceModel("ABC");
		offer2.setTravelAgency("ABC Travel");
		offer2.setStartDate(Date.from(Instant.now()));
		offer2.setEndDate(Date.from(Instant.now()));
		offer2.setTravelDuration(10);

		Offer offer3 = new Offer();
		offer3.setHotel(hotel1);
		offer3.setCurrency("Euro");
		offer3.setPricePerDay(140);
		offer3.setPriceModel("all-inclusive");
		offer3.setTravelAgency("DER Touristik");
		offer3.setStartDate(Date.from(Instant.now()));
		offer3.setEndDate(Date.from(Instant.now()));
		offer3.setTravelDuration(20);

		Offer offer4 = new Offer();
		offer4.setHotel(hotel1);
		offer4.setCurrency("Euro");
		offer4.setPricePerDay(170);
		offer4.setPriceModel("all-inclusive");
		offer4.setTravelAgency("ITS Reisen");
		offer4.setStartDate(Date.from(Instant.now()));
		offer4.setEndDate(Date.from(Instant.now()));
		offer4.setTravelDuration(7);

		offerService.save(offer1);
		offerService.save(offer2);
		offerService.save(offer3);
		offerService.save(offer4);

		hotel1.addOffer(offer1);
		hotel1.addOffer(offer3);
		hotel2.addOffer(offer2);
		hotel3.addOffer(offer4);

		hotelService.save(hotel1);
		hotelService.save(hotel2);
		hotelService.save(hotel3);

		User user = new User("Preuschoff", "Jan","preuschoffjan@gmail.com", "123456");
		userService.save(user);

		Booking booking1 = new Booking(user, offer2);
		Booking booking2 = new Booking(user, offer3);
		bookingService.save(booking1);
		bookingService.save(booking2);
		
		offer2.setBooking(booking1);
		offer3.setBooking(booking2);
		offerService.save(offer2);
		offerService.save(offer3);

		user.addBooking(booking1);
		user.addBooking(booking2);

		Rating rating1 = new Rating(5, user, hotel1);
		Rating rating2 = new Rating(1, "Absoluter Mist.", user, hotel2);

		user.addRating(rating1);
		user.addRating(rating2);
		hotel1.addRating(rating1);
		hotel2.addRating(rating2);

		ratingService.save(rating1);
		ratingService.save(rating2);
		hotelService.save(hotel1);
		hotelService.save(hotel2);

		userService.save(user);
	}

	@Override
	public void run(String... args) throws Exception {
		resetTestData();
	}
}
