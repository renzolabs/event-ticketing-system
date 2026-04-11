package com.renzo.labs.ticketing.booking.application;

import com.renzo.labs.ticketing.booking.domain.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Long userId, Long eventId, Integer quantity);
    List<Booking> getUserBookings(Long userId);
}
