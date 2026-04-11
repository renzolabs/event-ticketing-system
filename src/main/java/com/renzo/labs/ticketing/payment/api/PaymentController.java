package com.renzo.labs.ticketing.payment.api;

import com.renzo.labs.ticketing.payment.application.PaymentService;
import com.renzo.labs.ticketing.payment.domain.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@Valid @RequestBody CreatePaymentRequest request) {
        Payment payment = paymentService.createPayment(request.getBookingId(), request.getAmount());
        return ResponseEntity.ok(PaymentResponse.from(payment));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PaymentResponse> updatePaymentStatus(@PathVariable Long id,
                                                     @RequestBody UpdatePaymentStatusRequest request) {
        Payment payment = paymentService.updatePaymentStatus(id, request.getStatus());
        return ResponseEntity.ok(PaymentResponse.from(payment));
    }
}
