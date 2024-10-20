package com.eventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventManagement.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
