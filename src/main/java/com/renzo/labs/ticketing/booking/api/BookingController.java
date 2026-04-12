package com.renzo.labs.ticketing.booking.api;

import com.renzo.labs.ticketing.auth.domain.User;
import com.renzo.labs.ticketing.booking.application.BookingFacade;
import com.renzo.labs.ticketing.booking.application.BookingService;
import com.renzo.labs.ticketing.booking.domain.Booking;
import com.renzo.labs.ticketing.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final BookingFacade bookingFacade;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody CreateBookingRequest request,
                                                 Authentication authentication) {
        String email = authentication.getName();
        User user = userService.getCurrentUser(email);
        
        Booking booking = bookingFacade.createBookingWithPayment(
                user.getId(),
                request.getEventId(),
                request.getQuantity(),
                request.getAmount()
        );
        
        return ResponseEntity.ok(BookingResponse.from(booking));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingResponse>> getUserBookings(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.getUserBookings(userId);
        List<BookingResponse> bookingResponses = bookings.stream()
                .map(BookingResponse::from)
                .toList();
        return ResponseEntity.ok(bookingResponses);
    }
}
