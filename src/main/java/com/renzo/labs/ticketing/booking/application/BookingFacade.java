package com.renzo.labs.ticketing.booking.application;

import com.renzo.labs.ticketing.booking.domain.Booking;

import java.math.BigDecimal;

public interface BookingFacade {
    Booking createBookingWithPayment(Long userId, Long eventId, Integer quantity, BigDecimal amount);
}
