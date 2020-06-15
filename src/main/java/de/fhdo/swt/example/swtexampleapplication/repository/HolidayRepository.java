package de.fhdo.swt.example.swtexampleapplication.repository;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
}
