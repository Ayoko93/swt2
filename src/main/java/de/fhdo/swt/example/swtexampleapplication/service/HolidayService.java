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
 * @author Jan Preuschoff
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
	 * Finds a holiday by it's id.
	 * @param id the holiday's id
	 * @return the holiday the id belongs to
	 * @throws NoSuchElementException of no holiday with the given id can be
	 * 								  found
	 */
	@Override
	public Holiday find(long id) {
		return repo.findById(id).orElseThrow(
				() -> new NoSuchElementException("Could not find holiday with "
				+ "id " + id));
	}

	/**
	 * Finds all holidays in the table and returns them as a list.
	 * @return all holidays found in the corresponding table
	 */
	@Override
	public Iterable<Holiday> findAll() {
		return repo.findAll();
	}

	/**
	 * Save a valid holiday inside the database. This method may be used to add
	 * as well as update a holiday.
	 */
	@Override
	public void save(@Valid Holiday holiday) {
		repo.save(holiday);
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
	 * Deletes the given holiday from the database.
	 * @param holiday the holiday to delete
	 * @throws IllegalArgumentException if {@code holiday} is {@code null}
	 */
	@Override
	public void delete(Holiday holiday) {
		repo.delete(holiday);
	}

	/**
	 * Deletes the holiday the given id is for from the database.
	 * @param id the id of the holiday to delete
	 */
	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	/**
	 * Deletes all holidays in the given iterable object from the database.
	 * @param holidays the holidays to delete
	 * @throws IllegalArgumentException if {@code holidays} or any instance
	 * 									inside it is {@code null}
	 */
	@Override
	public void deleteAll(Iterable<Holiday> holidays) {
		repo.deleteAll(holidays);
	}

	/**
	 * Deletes all holidays from the database.
	 */
	@Override
	public void deleteAll() {
		repo.deleteAll();
	}
}
