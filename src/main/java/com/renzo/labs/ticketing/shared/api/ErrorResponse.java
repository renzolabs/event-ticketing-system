package com.renzo.labs.ticketing.shared.api;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Error response wrapper for API error responses.
 */
@Getter
@Builder
public class ErrorResponse {

    private final String error;
    private final String message;
    private final List<String> details;
    private final LocalDateTime timestamp;

    /**
     * Creates an error response with error type and message.
     *
     * @param error   the error type/code
     * @param message the error message
     * @return ErrorResponse with error details
     */
    public static ErrorResponse of(String error, String message) {
        return ErrorResponse.builder()
                .error(error)
                .message(message)
                .details(Collections.emptyList())
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * Creates an error response with error type, message, and additional details.
     *
     * @param error   the error type/code
     * @param message the error message
     * @param details additional error details
     * @return ErrorResponse with error details
     */
    public static ErrorResponse of(String error, String message, List<String> details) {
        return ErrorResponse.builder()
                .error(error)
                .message(message)
                .details(details != null ? details : Collections.emptyList())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
