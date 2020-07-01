package de.fhdo.swt.example.swtexampleapplication.repository;

import de.fhdo.swt.example.swtexampleapplication.entity.Offer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
