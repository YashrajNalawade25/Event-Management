package com.eventManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventManagement.dto.EventRequest;
import com.eventManagement.entities.Event;
import com.eventManagement.helper.CurrentUserUtil;
import com.eventManagement.service.event.EventService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;
    
    @Autowired
    private CurrentUserUtil currentUserUtil;

    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@RequestBody EventRequest eventRequest) {
        String currentUserEmail = currentUserUtil.getCurrentUserEmail();
        if (currentUserEmail == null) {
            return ResponseEntity.badRequest().body("Invalid user");
        }

        Event event = new Event();
        event.setName(eventRequest.getName());
        event.setEventStart(eventRequest.getEventStart());
        event.setEventEnd(eventRequest.getEventEnd());
        event.setLocation(eventRequest.getLocation());
        event.setDescription(eventRequest.getDescription());
        event.setTicketDetail(eventRequest.getTicketDetail());
        event.setCapacity(eventRequest.getCapacity());
        event.setOrganizerEmail(currentUserEmail);  // Adjust this field to match your Event entity
        eventService.addEvent(event);

        return ResponseEntity.ok("Event created successfully");
    }

    @GetMapping("/listing")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        if (events.isEmpty()) {
            return ResponseEntity.noContent().build();  // Returns 204 if no events found
        }
        return ResponseEntity.ok(events);  // Returns the list of events in the response body
    }
}
