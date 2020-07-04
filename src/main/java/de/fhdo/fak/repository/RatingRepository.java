package de.fhdo.fak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fhdo.fak.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}