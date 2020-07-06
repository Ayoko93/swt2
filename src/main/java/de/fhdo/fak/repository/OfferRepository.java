package de.fhdo.fak.repository;

import de.fhdo.fak.entity.Booking;
import de.fhdo.fak.entity.Offer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
	public Iterable<Offer> findByBooking(Booking booking);
}
