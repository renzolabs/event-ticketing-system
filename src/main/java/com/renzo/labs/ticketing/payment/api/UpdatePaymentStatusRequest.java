package com.renzo.labs.ticketing.payment.api;

import com.renzo.labs.ticketing.payment.domain.PaymentStatus;
import lombok.Data;

@Data
public class UpdatePaymentStatusRequest {
    private PaymentStatus status;
}
