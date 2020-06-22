package de.fhdo.swt.example.swtexampleapplication.service;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import de.fhdo.swt.example.swtexampleapplication.entity.Hotel;
import de.fhdo.swt.example.swtexampleapplication.repository.HotelRepository;

/**
 * A service for finding holidays in the database.
 * @author Jan Preuschoff
 */
@Service
@Validated
public class HotelService implements EntityService<Hotel> {
	/**
	 * The repository used.
	 */
	@Autowired
	private HotelRepository repo;

	/**
	 * Finds a hotel by it's id.
	 * @param id the hotel's id
	 * @return the hotel the id belongs to
	 * @throws NoSuchElementException if no hotel with the given id can be
	 * 								  found
	 */
	@Override
	public Hotel find(long id) {
		return repo.findById(id).orElseThrow(
				() -> new NoSuchElementException("Could not find hotel with "
				+ "id " + id));
	}

	/**
	 * Finds all hotels in the table and returns them as a list.
	 * @return all hotels found in the corresponding table
	 */
	@Override
	public Iterable<Hotel> findAll() {
		return repo.findAll();
	}

	/**
	 * Save a valid hotel inside the database. This method may be used to add
	 * as well as update a hotel.
	 * @param hotel the hotel to save
	 * @throws IllegalArgumentException if {@code hotel} is {@code null}
	 */
	@Override
	public void save(@Valid Hotel hotel) {
		repo.save(hotel);
	}

	/**
	 * Save a list of valid hotels inside the database. This method may be
	 * used to add as well as update hotels.
	 * @param hotels the hotels to save
	 * @throws IllegalArgumentException if {@code hotels} or any instance in
	 * 									it is {@code null}
	 */
	@Override
	public void saveAll(@Valid Iterable<Hotel> hotels) {
		repo.saveAll(hotels);
	}

	/**
	 * Deletes the given hotel from the database.
	 * @param hotel the hotel to delete
	 * @throws IllegalArgumentException if {@code hotel} is {@code null}
	 */
	@Override
	public void delete(Hotel hotel) {
		repo.delete(hotel);
	}

	/**
	 * Deletes the hotel the given id is for from the database.
	 * @param id the id of the holiday to delete
	 */
	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	/**
	 * Deletes all hotels in the given iterable object from the database.
	 * @param hotels the hotels to delete
	 * @throws IllegalArgumentException if {@code hotels} or any instance
	 * 									inside it is {@code null}
	 */
	@Override
	public void deleteAll(Iterable<Hotel> hotels) {
		repo.deleteAll(hotels);
	}

	/**
	 * Deletes all hotels from the database.
	 */
	@Override
	public void deleteAll() {
		repo.deleteAll();
	}
}
