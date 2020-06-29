package de.fhdo.swt.example.swtexampleapplication.service;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fhdo.swt.example.swtexampleapplication.entity.HolidayProfile;
import de.fhdo.swt.example.swtexampleapplication.repository.HolidayProfileRepository;

/**
 * A service for accessing the user repository.
 * 
 * @author Jan Preuschoff
 */
@Service
public class HolidayProfileService implements EntityService<HolidayProfile> {
	/**
	 * The repository to access.
	 */
	@Autowired
	private HolidayProfileRepository repo;

	/**
	 * Finds all holiday profiles in the database and returns an iterable
	 * object for all of them.
	 * @return all holiday profiles in the database
	 */
	@Override
	public Iterable<HolidayProfile> findAll() {
		return repo.findAll();
	}

	/**
	 * Finds the holiday profile for the given id and returns it.
	 * @param id the id to look for
	 * @return the holiday profile the id belongs to
	 * @throws NoSuchElementException if the id does not belong to a holiday
	 * 								  profile
	 */
	@Override
	public HolidayProfile find(long id) {
		return repo.findById(id).orElseThrow(() -> new NoSuchElementException(
				"Could not find holiday profile with id " + id));
	}

	/**
	 * Saves all holiday profiles in the given iterable object to the database.
	 * This method may be used to add or update entities.
	 * @param holidayProfiles the holiday profiles to save
	 * @throws IllegalArgumentException if {@code holidayProfiles} or any
	 * 									instance inside it is {@code}
	 */
	@Override
	public void saveAll(@Valid Iterable<HolidayProfile> holidayProfiles) {
		repo.saveAll(holidayProfiles);
	}

	/**
	 * Saves the given holiday profile to the database. This method may be
	 * used to add or update the given entity.
	 * @param holidayProfile the holiday profile to save
	 * @throws IllegalArgumentException if {@code holidayProfile} is
	 * 									{@code null}
	 */
	@Override
	public void save(@Valid HolidayProfile holidayProfile) {
		repo.save(holidayProfile);
	}

	/**
	 * Deletes the given holiday profile from the database.
	 * @param holidayProfile the rating to delete
	 * @throws IllegalArgumentException if {@code rating} is {@code null}
	 */
	@Override
	public void delete(HolidayProfile holidayProfile) {
		repo.delete(holidayProfile);
	}

	/**
	 * Deletes the holiday profile the given id belongs to from the database.
	 * @param id the id of the holiday profile to delete
	 */
	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	/**
	 * Deletes all holiday profiles from the database.
	 */
	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	/**
	 * Deletes all holiday profiles in the given iterable object from the
	 * database.
	 * @param holidayProfiles the holiday profiles to delete
	 * @throws IllegalArgumentException if {@code holidayProfiles} or any
	 * 									instance inside it is {@code null}
	 */
	@Override
	public void deleteAll(Iterable<HolidayProfile> holidayProfiles) {
		repo.deleteAll(holidayProfiles);
	}
}
