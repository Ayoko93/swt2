package de.fhdo.swt.example.swtexampleapplication.repository;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import org.springframework.data.repository.CrudRepository;

public interface HolidayRepository extends CrudRepository<Holiday, Long> {
}
