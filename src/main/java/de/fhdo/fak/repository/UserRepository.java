package de.fhdo.fak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fhdo.fak.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByMailAddressAndPassword(String email, String password);
}