package com.renzo.labs.ticketing.event.api;

import com.renzo.labs.ticketing.event.application.EventService;
import com.renzo.labs.ticketing.event.domain.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@Valid @RequestBody CreateEventRequest request) {
        Event event = eventService.createEvent(
                request.getName(),
                request.getDescription(),
                request.getDate(),
                request.getTotalTickets()
        );
        return ResponseEntity.ok(EventResponse.from(event));
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        List<EventResponse> eventResponses = events.stream()
                .map(EventResponse::from)
                .toList();
        return ResponseEntity.ok(eventResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(EventResponse.from(event));
    }
}
