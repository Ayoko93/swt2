package de.fhdo.swt.example.swtexampleapplication;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import de.fhdo.swt.example.swtexampleapplication.entity.Hotel;
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
	EntityService<Hotel> hotelService;
	@Autowired
	EntityService<Holiday> holidayService;
	@Autowired
	EntityService<User> userService;

	@Override
	public void run(String... args) throws Exception {
		Hotel hotel = new Hotel("Europe", "Germany", "Dortmund",
				"ABC-Straße 5", "ABC Hotel", "Et ullamco Lorem deserunt aute. "
				+ "Aliquip ut aliquip elit excepteur fugiat ex cillum in "
				+ "occaecat. Nulla cupidatat nostrud in Lorem exercitation ut "
				+ "dolore culpa tempor exercitation mollit commodo nisi et.");
		hotelService.save(hotel);

		Holiday holiday = new Holiday();
		holiday.setHotel(hotel);
		holiday.setCurrency("Euro");
		holiday.setPricePerDay(50);
		holiday.setPriceModel("ABC");
		holiday.setTravelAgency("ABC Travel");
		holiday.setStartDate(Date.from(Instant.now()));
		holiday.setStartDate(Date.from(Instant.now()));

		holidayService.save(holiday);
		userService.save(new User("Preuschoff", "Jan",
				"preuschoffjan@gmail.com", "123456"));
	}
}
