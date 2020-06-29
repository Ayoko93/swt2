package de.fhdo.swt.example.swtexampleapplication.service;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fhdo.swt.example.swtexampleapplication.entity.Rating;
import de.fhdo.swt.example.swtexampleapplication.repository.RatingRepository;

/**
 * A service for accessing the user repository.
 * @author Jan Preuschoff
 */
@Service
public class RatingService implements EntityService<Rating> {
	/**
	 * The repository to access.
	 */
	@Autowired
	private RatingRepository repo;

	/**
	 * Finds all ratings in the database and returns an iterable object for all
	 * of them.
	 * @return all ratings in the database
	 */
	@Override
	public Iterable<Rating> findAll() {
		return repo.findAll();
	}

	/**
	 * Finds the rating for the given id and returns it.
	 * @param id the id to look for
	 * @return the rating the id belongs to
	 * @throws NoSuchElementException if the id does not belong to a rating
	 */
	@Override
	public Rating find(long id) {
		return repo.findById(id).orElseThrow(() -> new NoSuchElementException(
				"Could not find rating with id " + id));
	}

	/**
	 * Saves all rating in the given iterable object to the database. This
	 * method may be used to add or update entities.
	 * @param ratings the ratings to save
	 * @throws IllegalArgumentException if {@code ratings} or any instance inside
	 * 									it is {@code}
	 */
	@Override
	public void saveAll(@Valid Iterable<Rating> ratings) {
		repo.saveAll(ratings);
	}

	/**
	 * Saves the given rating to the database. This method may be used to add or
	 * update the given entity.
	 * @param rating the rating to save
	 * @throws IllegalArgumentException if {@code rating} is {@code null}
	 */
	@Override
	public void save(@Valid Rating rating) {
		repo.save(rating);
	}

	/**
	 * Deletes the given rating from the database.
	 * @param rating the rating to delete
	 * @throws IllegalArgumentException if {@code rating} is {@code null}
	 */
	@Override
	public void delete(Rating rating) {
		repo.delete(rating);
	}

	/**
	 * Deletes the rating the given id belongs to from the database.
	 * @param id the id of the rating to delete
	 */
	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	/**
	 * Deletes all ratings from the database.
	 */
	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	/**
	 * Deletes all ratings in the given iterable object from the database.
	 * @param ratings the ratings to delete
	 * @throws IllegalArgumentException if {@code ratings} or any instance
	 * 									inside it is {@code null}
	 */
	@Override
	public void deleteAll(Iterable<Rating> ratings) {
		repo.deleteAll(ratings);
	}
}
