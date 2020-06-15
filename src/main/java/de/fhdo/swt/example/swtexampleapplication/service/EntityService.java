package de.fhdo.swt.example.swtexampleapplication.service;

import java.util.List;

import javax.validation.Valid;

/**
 * An interface for services being the interface to repositories.
 * @param <T> the type of data the repository holds
 */
public interface EntityService<T> {
	/**
	 * Finds all data of type {@code T} and returns it as a list
	 * @return all instances of {@code T} found in the database
	 */
	public List<T> findAll();

	/**
	 * Finds a specifiy table entry of type {@code T} by it's id.
	 * @param id the id of the table entry
	 * @return the table entry the id belongs to
	 */
	public T findById(long id);

	/**
	 * Save a list of valid instances of type {@code T} in the database. This
	 * method may be used to add as well as update entities.
	 * @param entities the list of entities to save.
	 */
	public void saveAll(@Valid List<T> entities);

	/**
	 * Save a valid instance of type {@code T} in the database. This method may
	 * be used to add as well as update an entity.
	 * @param entity the entity to save.
	 */
	public void save(@Valid T entity);
}