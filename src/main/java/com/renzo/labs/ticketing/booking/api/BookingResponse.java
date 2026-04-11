package com.renzo.labs.ticketing.booking.api;

import com.renzo.labs.ticketing.booking.domain.BookingStatus;
import com.renzo.labs.ticketing.user.api.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    
    private Long id;
    private UserResponse user;
    private EventSummary event;
    private Integer quantity;
    private BookingStatus status;
    private LocalDateTime createdAt;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventSummary {
        private Long id;
        private String name;
        private String description;
        private Integer availableTickets;
    }
    
    public static BookingResponse from(com.renzo.labs.ticketing.booking.domain.Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .user(UserResponse.from(booking.getUser()))
                .event(EventSummary.builder()
                        .id(booking.getEvent().getId())
                        .name(booking.getEvent().getName())
                        .description(booking.getEvent().getDescription())
                        .availableTickets(booking.getEvent().getAvailableTickets())
                        .build())
                .quantity(booking.getQuantity())
                .status(booking.getStatus())
                .createdAt(booking.getCreatedAt())
                .build();
    }
}
