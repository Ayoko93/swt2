package de.fhdo.fak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fhdo.fak.entity.Booking;
import de.fhdo.fak.entity.User;

/**
 * The repository containing all bookings inside the database.
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
	/**
	 * Finds all bookings belonging to a user.
	 * @param user the user to look for
	 * @return all bookings the user has made
	 */
	List<Booking> findByUser(User user);
}