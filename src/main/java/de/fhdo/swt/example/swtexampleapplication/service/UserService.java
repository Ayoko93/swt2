package de.fhdo.swt.example.swtexampleapplication.service;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fhdo.swt.example.swtexampleapplication.entity.User;
import de.fhdo.swt.example.swtexampleapplication.repository.UserRepository;

/**
 * A service for accessing the user repository.
 * @author Jan Preuschoff
 */
@Service
public class UserService implements EntityService<User> {
	/**
	 * The repository to access.
	 */
	@Autowired
	private UserRepository repo;

	/**
	 * Finds all users in the database and returns an iterable object for all
	 * of them.
	 * @return all users in the database
	 */
	@Override
	public Iterable<User> findAll() {
		return repo.findAll();
	}

	/**
	 * Finds the user for the given id and returns it.
	 * @param id the id to look for
	 * @return the user the id belongs to
	 * @throws NoSuchElementException if the id does not belong to a user
	 */
	@Override
	public User find(long id) {
		return repo.findById(id).orElseThrow(() -> new NoSuchElementException(
				"Could not find user with id " + id));
	}

	/**
	 * Saves all users in the given iterable object to the database. This
	 * method may be used to add or update entities.
	 * @param users the entities to save
	 * @throws IllegalArgumentException if {@code users} or any instance inside
	 * 									it is {@code}
	 */
	@Override
	public void saveAll(@Valid Iterable<User> users) {
		repo.saveAll(users);
	}

	/**
	 * Saves the given user to the database. This method may be used to add or
	 * update the given entity.
	 * @param user the user to save
	 * @throws IllegalArgumentException if {@code user} is {@code null}
	 */
	@Override
	public void save(@Valid User user) {
		repo.save(user);
	}

	/**
	 * Deletes the given user from the database.
	 * @param user the user to delete
	 * @throws IllegalArgumentException if {@code user} is {@code null}
	 */
	@Override
	public void delete(User user) {
		repo.delete(user);
	}

	/**
	 * Deletes the user the given id belongs to from the database.
	 * @param id the id of the user to delete
	 */
	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	/**
	 * Deletes all user from the database.
	 */
	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	/**
	 * Deletes all users in the given iterable object from the database.
	 * @param users the users to delete
	 * @throws IllegalArgumentException if {@code users} or any instance inside
	 * 									it is {@code null}
	 */
	@Override
	public void deleteAll(Iterable<User> users) {
		repo.deleteAll(users);
	}
}