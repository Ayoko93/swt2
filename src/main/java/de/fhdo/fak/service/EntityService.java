package de.fhdo.fak.service;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

/**
 * An interface for services being the interface to repositories.
 * @param <T> the type of data the repository holds
 * @author Jan Preuschoff
 */
public interface EntityService<T> {
	/**
	 * Finds a specifiy table entry of type {@code T} by it's id.
	 * @param id the id of the table entry
	 * @return the table entry the id belongs to
	 */
	public T find(long id);

	/**
	 * Finds all data of type {@code T} and returns them in an iterable
	 * container.
	 * @return all instances of {@code T} found in the database
	 */
	public Iterable<T> findAll();

	/**
	 * Save a valid instance of type {@code T} in the database. This method may
	 * be used to add as well as update an entity.
	 * @param entity the entity to save.
	 */
	public void save(@Valid T entity);

	/**
	 * Save an iterable container of valid instances of type {@code T} in the
	 * database. This method may be used to add as well as update entities.
	 * @param entities the container of entities to save.
	 */
	public void saveAll(@Valid Iterable<T> entities);

	/**
	 * Deletes the given entity from the database.
	 * @param entity the entity to delete
	 */
	public void delete(T entity);

	/**
	 * Deletes the entity the given id belongs to from the database.
	 * @param id the id of the entity to delete
	 */
	public void delete(long id);

	/**
	 * Delete all entities from the database.
	 */
	public void deleteAll();

	/**
	 * Deletes all entities inside the iterable object from the database.
	 * @param entities the entities to delete
	 */
	public void deleteAll(Iterable<T> entities);

	/**
	 * Deletes all entities the id of which is in {@code ids} using
	 * {@code #delete(long)}.
	 * @param ids the ids of the entities to delete.
	 * @throws IllegalArgumentException if {@code ids} is {@code null}
	 */
	public default void deleteAll(Collection<Long> ids) {
		if(ids == null)
			throw new IllegalArgumentException("The list of ids is null is "
					+ "null");
		ids.forEach(this::delete);
	}

	/**
	 * Deletes all objects for which {@link Predicate#test(Object)
	 * predicate.test()} returns {@code true}.
	 * @param predicate the predicate to determine the entities to delete
	 */
	public default void deleteIf(Predicate<T> predicate) {
		deleteAll(StreamSupport.stream(findAll().spliterator(), false)
				.filter(predicate).collect(Collectors.toList()));
	}
}