package de.fhdo.swt.example.swtexampleapplication.service;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import de.fhdo.swt.example.swtexampleapplication.repository.HolidayRepository;

/**
 * A service for finding holidays in the database.
 */
@Service
@Validated
public class HolidayService implements EntityService<Holiday> {
	/**
	 * The repository used.
	 */
	@Autowired
	private HolidayRepository repo;

	/**
	 * Finds all holidays in the table and returns them as a list.
	 * @return all holidays found in the corresponding table
	 */
	@Override
	public Iterable<Holiday> findAll() {
		return repo.findAll();
	}

	/**
	 * Finds a holiday by it's id.
	 * @param id the holiday's id
	 * @return the holiday the id belongs to
	 * @throws NoSuchElementException of no holiday with the given id can be
	 * 								  found
	 */
	@Override
	public Holiday findById(long id) {
		return repo.findById(id).orElseThrow(
				() -> new NoSuchElementException("Could not find holiday with "
				+ "id " + id));
	}

	/**
	 * Save a list of valid holidays inside the database. This method may be
	 * used to add as well as update holidays.
	 * @param holidays the holidays to save
	 * @throws IllegalArgumentException if {@code holidays} or any instance in
	 * 									it is {@code null}
	 */
	@Override
	public void saveAll(@Valid Iterable<Holiday> holidays) {
		repo.saveAll(holidays);
	}

	/**
	 * Save a valid holiday inside the database. This method may be used to add
	 * as well as update a holiday.
	 */
	@Override
	public void save(@Valid Holiday holiday) {
		repo.save(holiday);
	}
}
