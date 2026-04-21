package com.renzo.labs.ticketing.shared.api;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ErrorResponseTest {

    @Test
    void of_withErrorAndMessage_shouldCreateResponse() {
        String error = "Bad Request";
        String message = "Invalid input";

        ErrorResponse response = ErrorResponse.of(error, message);

        assertNotNull(response);
        assertEquals(error, response.getError());
        assertEquals(message, response.getMessage());
        assertNotNull(response.getDetails());
        assertTrue(response.getDetails().isEmpty());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void of_withDetails_shouldCreateResponse() {
        String error = "Validation Error";
        String message = "Field validation failed";
        List<String> details = Arrays.asList("Name is required", "Email is invalid");

        ErrorResponse response = ErrorResponse.of(error, message, details);

        assertNotNull(response);
        assertEquals(error, response.getError());
        assertEquals(message, response.getMessage());
        assertEquals(details, response.getDetails());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void of_withNullDetails_shouldReturnEmptyList() {
        ErrorResponse response = ErrorResponse.of("Error", "Message", null);

        assertNotNull(response.getDetails());
        assertTrue(response.getDetails().isEmpty());
    }

    @Test
    void of_shouldSetCurrentTimestamp() {
        LocalDateTime before = LocalDateTime.now().minusSeconds(1);

        ErrorResponse response = ErrorResponse.of("Error", "Message");

        LocalDateTime after = LocalDateTime.now().plusSeconds(1);
        assertNotNull(response.getTimestamp());
        assertTrue(response.getTimestamp().isAfter(before) || response.getTimestamp().equals(before));
        assertTrue(response.getTimestamp().isBefore(after) || response.getTimestamp().equals(after));
    }

    @Test
    void builder_shouldCreateResponse() {
        String error = "builder error";
        String message = "builder message";
        List<String> details = Collections.singletonList("detail");
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorResponse response = ErrorResponse.builder()
                .error(error)
                .message(message)
                .details(details)
                .timestamp(timestamp)
                .build();

        assertEquals(error, response.getError());
        assertEquals(message, response.getMessage());
        assertEquals(details, response.getDetails());
        assertEquals(timestamp, response.getTimestamp());
    }
}
