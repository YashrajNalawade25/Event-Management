package com.eventManagement.service.event;

import com.eventManagement.entities.Event;
import java.util.List;

public interface IEventService {
    Event addEvent(Event event);
    Event getEventById(int id);
    List<Event> getAllEvents();
}
