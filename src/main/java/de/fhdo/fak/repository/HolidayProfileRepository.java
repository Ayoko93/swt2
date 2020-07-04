package de.fhdo.fak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fhdo.fak.entity.HolidayProfile;

public interface HolidayProfileRepository extends JpaRepository<HolidayProfile, Long> {
}
