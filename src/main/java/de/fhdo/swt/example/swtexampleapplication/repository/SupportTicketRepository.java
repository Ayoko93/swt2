package de.fhdo.swt.example.swtexampleapplication.repository;

import de.fhdo.swt.example.swtexampleapplication.entity.SupportTicket;
import org.springframework.data.repository.CrudRepository;

public interface SupportTicketRepository extends CrudRepository<SupportTicket, Long> {

}
