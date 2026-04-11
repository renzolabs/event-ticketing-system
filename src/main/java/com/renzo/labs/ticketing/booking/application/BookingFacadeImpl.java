package com.renzo.labs.ticketing.booking.application;

import com.renzo.labs.ticketing.booking.domain.Booking;
import com.renzo.labs.ticketing.payment.application.PaymentService;
import com.renzo.labs.ticketing.payment.domain.Payment;
import com.renzo.labs.ticketing.payment.domain.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BookingFacadeImpl implements BookingFacade {

    private final BookingService bookingService;
    private final PaymentService paymentService;

    @Override
    @Transactional
    public Booking createBookingWithPayment(Long userId, Long eventId, Integer quantity, BigDecimal amount) {
        Booking booking = bookingService.createBooking(userId, eventId, quantity);
        
        Payment payment = paymentService.createPayment(booking.getId(), amount);
        
        paymentService.updatePaymentStatus(payment.getId(), PaymentStatus.SUCCESS);
        
        return booking;
    }
}
