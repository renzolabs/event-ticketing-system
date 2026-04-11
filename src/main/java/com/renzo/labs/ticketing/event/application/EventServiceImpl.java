package com.renzo.labs.ticketing.event.application;

import com.renzo.labs.ticketing.event.domain.Event;
import com.renzo.labs.ticketing.event.infrastructure.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    @Transactional
    public Event createEvent(String name, String description, java.time.LocalDateTime date, Integer totalTickets) {
        Event event = Event.builder()
                .name(name)
                .description(description)
                .date(date)
                .totalTickets(totalTickets)
                .availableTickets(totalTickets)
                .build();

        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findByOrderByDateAsc();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    @Transactional
    public boolean checkAvailability(Long eventId, Integer quantity) {
        Event event = getEventById(eventId);
        return event.isAvailable(quantity);
    }
}
