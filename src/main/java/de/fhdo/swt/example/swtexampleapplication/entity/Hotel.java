package de.fhdo.swt.example.swtexampleapplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * A data class for a hotel. Holds information about the place, the hotel name
 * and other information such as ratings or holidays.
 * @author Jan Preuschoff
 */
@Entity
public class Hotel {
    /**
     * The primary identifier of this hotel. Basically the primary key inside
     * the database table. Of no further use in the program.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    
    /**
     * The continent the hotel is in.
     */
    private String continent;

    /**
     * The country the hotel is in.
     */
    private String country;

    /**
     * The city the hotel is in.
     */
    private String city;
    
    /**
     * The street the hotel is in.
     */
    private String street;
    
    /**
     * The hotel name.
     */
	private String name;
    
    /**
     * A description for the hotel. May be {@code null} if none has been set.
     */
	@Nullable
	@Column(nullable = true)
    private String description;
    
    /**
     * All ratings for this hotel.
     */
    @OneToMany
    private Set<Rating> ratings = new HashSet<Rating>();
    
    /**
     * All holidays in this hotel.
     */
	@OneToMany
    private Set<Holiday> holidays = new HashSet<Holiday>();
    
    /**
     * Constructs an instance of this class.
     */
    public Hotel() {
    }

    /**
     * Constructs an instance of this class.
     * @param continent the continent this hotel is in
     * @param country   the country this hotel is in
     * @param city      the city this hotel is in
     * @param street    the street this hotel is in
     * @param name      the hotel name
     * @throws IllegalArgumentException if any of the arguments to this
     *                                  constructor is {@code null}
     */
    public Hotel(String continent, String country, String city, String street,
            String name) {
        this(continent, country, city, street, name, null);
    }

    /**
     * Constructs an instance of this class. The description is optional and
     * thus can be set to null, if the hotel should not have a description.
     * @param continent the continent this hotel is in
     * @param country   the country this hotel is in
     * @param city      the city this hotel is in
     * @param street    the street this hotel is in
     * @param name      the hotel name
     * @throws IllegalArgumentException if any of the arguments to this
     *                                  constructor except for
     *                                  {@code description} is {@code null}
     */
    public Hotel(String continent, String country, String city, String street,
            String name, @Nullable String description) {
        setContinent(continent);
        setCountry(country);
        setCity(city);
        setStreet(street);
        setName(name);
        this.description = description;
    }

    /**
     * @return the unique identifier of this hotel
     */
    public long getId() {
        return id;
    }

    /**
     * @return the continent the hotel is in
     */
    public String getContinent() {
		return continent;
	}

    /**
     * Sets the continent this hotel is in.
     * @param continent the continent this hotel is in
     * @throws IllegalArgumentException if {@code continent} is {@code null}
     */
    public void setContinent(String continent) {
        if(continent == null)
            throw new IllegalArgumentException("Continent is null");
        else
		    this.continent = continent;
	}

    /**
     * @return the country this hotel is in
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country this hotel is in.
     * @param country the country this hotel is in
     * @throws IllegalArgumentException if {@code country} is {@code null}
     */
    public void setCountry(String country) {
        if(country == null)
            throw new IllegalArgumentException("Country is null");
        else
            this.country = country;
    }

    /**
     * @return the city this hotel is in
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city this hotel is in.
     * @param continent the city this hotel is in
     * @throws IllegalArgumentException if {@code city} is {@code null}
     */
    public void setCity(String city) {
        if(city == null)
            throw new IllegalArgumentException("City is null");
        else
            this.city = city;
    }

    /**
     * @return the street this hotel is in
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street this hotel is in.
     * @param street the street this hotel is in
     * @throws IllegalArgumentException if {@code street} is {@code null}
     */
    public void setStreet(String street) {
        if(street == null)
            throw new IllegalArgumentException("Street is null");
        else
            this.street = street;
    }

    /**
     * @return the hotel name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the hotel name.
     * @param name the continent this hotel is in
     * @throws IllegalArgumentException if {@code name} is {@code null}
     */
    public void setName(String name) {
        if(name == null)
            throw new IllegalArgumentException("Name is null");
        else
            this.name = name;
    }

    /**
     * @return the description for this hotel or {@code null} if none has been
     *         set
     */
    @Nullable
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for this hotel. If {@code description} is null, the
     * current description will be removed.
     * @param continent the description for this hotel
     */
    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    /**
     * Removes the current description for this hotel.
     */
    public void removeDescription() {
        this.description = null;
    }
}