package com.renzo.labs.ticketing.booking.application;

import com.renzo.labs.ticketing.auth.domain.User;
import com.renzo.labs.ticketing.booking.domain.Booking;
import com.renzo.labs.ticketing.booking.domain.BookingStatus;
import com.renzo.labs.ticketing.booking.infrastructure.BookingRepository;
import com.renzo.labs.ticketing.event.application.EventService;
import com.renzo.labs.ticketing.event.domain.Event;
import com.renzo.labs.ticketing.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final EventService eventService;

    @Override
    @Transactional
    public Booking createBooking(Long userId, Long eventId, Integer quantity) {
        User user = userService.getUserById(userId);
        Event event = eventService.getEventById(eventId);

        if (!eventService.checkAvailability(eventId, quantity)) {
            throw new RuntimeException("Not enough tickets available");
        }

        event.reduceAvailableTickets(quantity);

        Booking booking = Booking.builder()
                .user(user)
                .event(event)
                .quantity(quantity)
                .status(BookingStatus.CONFIRMED)
                .build();

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }
}
