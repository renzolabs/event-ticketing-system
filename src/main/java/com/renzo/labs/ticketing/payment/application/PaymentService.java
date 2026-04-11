package com.renzo.labs.ticketing.payment.application;

import com.renzo.labs.ticketing.payment.domain.Payment;
import com.renzo.labs.ticketing.payment.domain.PaymentStatus;

import java.math.BigDecimal;

public interface PaymentService {
    Payment createPayment(Long bookingId, BigDecimal amount);
    Payment updatePaymentStatus(Long paymentId, PaymentStatus status);
}
