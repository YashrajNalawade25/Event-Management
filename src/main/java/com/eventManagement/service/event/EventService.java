package com.eventManagement.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagement.entities.Event;
import com.eventManagement.repository.EventRepository;

import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event addEvent(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event getEventById(int id) {
        return this.eventRepository.findById(id).orElse(null);
    }


}
