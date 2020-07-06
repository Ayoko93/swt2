package de.fhdo.fak.service;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fhdo.fak.entity.Booking;
import de.fhdo.fak.entity.User;
import de.fhdo.fak.repository.BookingRepository;

/**
 * A service for accessing the booking repository.
 * @author Jan Preuschoff
 */
@Service
public class BookingService implements EntityService<Booking> {
	/**
	 * The repository used to get bookings.
	 */
	@Autowired
	private BookingRepository repo;

	/**
	 * The service used to get the user by it's id.
	 */
	@Autowired
	private UserService service;

	/**
	 * Finds all bookings a user has made.
	 * @param user the user to look for
	 * @return all bookings the user is referenced in
	 */
	public Iterable<Booking> findForUser(User user) {
		return repo.findByUser(user);
	}

	/**
	 * Finds all bookings a user has made.
	 * @param user the id of the user to look for
	 * @return all bookings the user is referenced in
	 * @throws NoSuchElementException if there is no user having the specified
	 * 								  user id
	 */
	public Iterable<Booking> findForUser(long user) {
		return repo.findByUser(service.find(user));
	}

	/**
	 * Finds the booking having the specified id.
	 * @param id the id to look for
	 * @return the booking the id belongs to
	 * @throws NoSuchElementException if there is no booking having the
	 * 								  specified id
	 */
	@Override
	public Booking find(long id) {
		return repo.findById(id).orElseThrow(() -> new NoSuchElementException(
				"Could not find booking with id " + id));
	}

	/**
	 * Finds all bookings there are.
	 * @return all bookings in the database
	 */
	@Override
	public Iterable<Booking> findAll() {
		return repo.findAll();
	}

	/**
	 * Saves the specified booking.
	 * @throws IllegalArgumentExecption if {@code booking} is {@code null}
	 */
	@Override
	public void save(@Valid Booking booking) {
		repo.save(booking);
	}

	/**
	 * Saves all specified bookings.
	 * @param bookings the bookings to save
	 * @throws IllegalArgumentExecption if {@code bookings} or any instance in
	 * 									it is {@code null}
	 */
	@Override
	public void saveAll(@Valid Iterable<Booking> bookings) {
		repo.saveAll(bookings);
	}

	/**
	 * Deletes the specified booking from the database.
	 * @param booking the booking to delete
	 * @throws IllegalArgumentException if {@code booking} is {@code null}
	 */
	@Override
	public void delete(Booking booking) {
		repo.delete(booking);
	}

	/**
	 * Deletes the booking having the specified id from the database.
	 * @param id the id of the booking to delete
	 */
	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	/**
	 * Deletes all bookings from the database.
	 */
	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	/**
	 * Deletes all speified bookings from the database.
	 * @param bookings the bookings to delete
	 * @throws IllegalArgumentException if {@code bookings} or any instance in
	 * 									it is {@code null}
	 */
	@Override
	public void deleteAll(Iterable<Booking> entities) {
		repo.deleteAll(entities);
	}
}