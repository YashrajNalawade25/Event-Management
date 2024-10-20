package com.eventManagement.dto;

import java.time.LocalDateTime;

public class EventRequest {
    private String name;
    private LocalDateTime eventStart;
    private LocalDateTime eventEnd;
    private String location;
    private String description;
    private String ticketDetail;
    private String capacity;

    // Constructors
    public EventRequest() {
    }

    public EventRequest(String name, LocalDateTime eventStart, LocalDateTime eventEnd, String location, 
                        String description, String ticketDetail, String capacity) {
        this.name = name;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.location = location;
        this.description = description;
        this.ticketDetail = ticketDetail;
        this.capacity = capacity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEventStart() {
        return eventStart;
    }

    public void setEventStart(LocalDateTime eventStart) {
        this.eventStart = eventStart;
    }

    public LocalDateTime getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(LocalDateTime eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTicketDetail() {
        return ticketDetail;
    }

    public void setTicketDetail(String ticketDetail) {
        this.ticketDetail = ticketDetail;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
