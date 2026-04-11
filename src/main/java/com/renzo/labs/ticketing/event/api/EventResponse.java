package com.renzo.labs.ticketing.event.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
    
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;
    private Integer totalTickets;
    private Integer availableTickets;
    private LocalDateTime createdAt;
    
    public static EventResponse from(com.renzo.labs.ticketing.event.domain.Event event) {
        return EventResponse.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .date(event.getDate())
                .totalTickets(event.getTotalTickets())
                .availableTickets(event.getAvailableTickets())
                .createdAt(event.getCreatedAt())
                .build();
    }
}
