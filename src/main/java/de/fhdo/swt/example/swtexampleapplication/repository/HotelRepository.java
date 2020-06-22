package de.fhdo.swt.example.swtexampleapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fhdo.swt.example.swtexampleapplication.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}