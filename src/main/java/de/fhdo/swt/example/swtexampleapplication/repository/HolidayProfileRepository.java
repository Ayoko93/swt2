package de.fhdo.swt.example.swtexampleapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fhdo.swt.example.swtexampleapplication.entity.HolidayProfile;

public interface HolidayProfileRepository extends JpaRepository<HolidayProfile, Long> {
}
