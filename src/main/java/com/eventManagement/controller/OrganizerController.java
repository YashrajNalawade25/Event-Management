package com.eventManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventManagement.entities.Organizer;
import com.eventManagement.service.organizer.OrganizerService;

@RestController
@CrossOrigin
public class OrganizerController {

	@Autowired
	private OrganizerService organizerService;
	
	@PostMapping("/register")
	public Organizer register(@RequestBody Organizer organizer) {
		return this.organizerService.registerOrganizer(organizer);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Organizer organizer) {
		System.out.println(organizer);
		
		return this.organizerService.verify(organizer);
	}
	
}
