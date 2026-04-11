package com.renzo.labs.ticketing.payment.application;

import com.renzo.labs.ticketing.booking.domain.Booking;
import com.renzo.labs.ticketing.booking.infrastructure.BookingRepository;
import com.renzo.labs.ticketing.payment.domain.Payment;
import com.renzo.labs.ticketing.payment.domain.PaymentStatus;
import com.renzo.labs.ticketing.payment.infrastructure.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    @Override
    @Transactional
    public Payment createPayment(Long bookingId, BigDecimal amount) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = Payment.builder()
                .booking(booking)
                .amount(amount)
                .status(PaymentStatus.PENDING)
                .build();

        return paymentRepository.save(payment);
    }

    @Override
    @Transactional
    public Payment updatePaymentStatus(Long paymentId, PaymentStatus status) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus(status);
        return paymentRepository.save(payment);
    }
}
