package de.fhdo.fak.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * A data class for a booking.
 * @author Jan Preuschoff
 */
@Entity
public class Booking {
	/**
	 * The primary key of the table for this data class. Is not really used for
	 * the program.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * The user that booked the offer.
	 */
    @ManyToOne(fetch = FetchType.LAZY)
	private User user;

	/**
	 * The offer the booking is for.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	private Offer offer;

	/**
	 * Constructs an instance of this class.
	 */
	public Booking() {
	}

	/**
	 * Constructs an instance of this class.
	 * @param user  the user that booked the offer
	 * @param offer the offer the booking is for
	 */
	public Booking(User user, Offer offer) {
		this.user = user;
		this.offer = offer;
	}

	/**
	 * @return the bookings id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the user that made the booking
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user that booked the offer.
	 * @param user the user that booked the offer
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the offer the booking is for
	 */
	public Offer getOffer() {
		return offer;
	}

	/**
	 * Sets the offer the booking is for.
	 * @param offer the offer the booking is for
	 */
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
