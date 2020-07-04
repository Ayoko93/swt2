package de.fhdo.fak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fhdo.fak.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}