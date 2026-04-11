package com.renzo.labs.ticketing.event.application;

import com.renzo.labs.ticketing.event.domain.Event;

import java.util.List;

public interface EventService {
    Event createEvent(String name, String description, java.time.LocalDateTime date, Integer totalTickets);
    List<Event> getAllEvents();
    Event getEventById(Long id);
    boolean checkAvailability(Long eventId, Integer quantity);
}
