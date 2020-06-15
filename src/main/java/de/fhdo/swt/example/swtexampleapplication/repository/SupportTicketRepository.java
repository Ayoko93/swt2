package de.fhdo.swt.example.swtexampleapplication.repository;

import de.fhdo.swt.example.swtexampleapplication.entity.SupportTicket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportTicketRepository
		extends JpaRepository<SupportTicket, Long> {
}
