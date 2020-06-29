package de.fhdo.swt.example.swtexampleapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fhdo.swt.example.swtexampleapplication.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByMailAddressAndPassword(String email, String password);
}