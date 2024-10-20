package com.eventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventManagement.entities.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer>{

	Organizer findByEmail(String email);

}
