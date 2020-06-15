package de.fhdo.swt.example.swtexampleapplication;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
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
	EntityService<Holiday> holidayService;

	@Override
	public void run(String... args) throws Exception {
		Holiday holiday = new Holiday();
		holiday.setCity("Dortmund");
		holiday.setCountry("Germany");
		holiday.setCurrency("Euro");
		holiday.setHotelName("ABC Hotel");
		holiday.setPrice(50);
		holiday.setPriceModel("ABC");
		holiday.setTravelAgency("ABC Travel");
		holiday.setStartDate(Date.from(Instant.now()));
		holiday.setStartDate(Date.from(Instant.now()));
		holiday.setDescription("Et ullamco Lorem deserunt aute. Aliquip ut "
				+ "aliquip elit excepteur fugiat ex cillum in occaecat. "
				+ "Nulla cupidatat nostrud in Lorem exercitation ut dolore "
				+ "culpa tempor exercitation mollit commodo nisi et.");

		holidayService.save(holiday);
		holidayService.findAll().forEach(e -> System.out.println(e.getHotelName()));
	}
}
