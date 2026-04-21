package com.renzo.labs.ticketing.shared.infrastructure.exception;

import java.util.List;

/**
 * Exception thrown when input validation fails.
 */
public class ValidationException extends RuntimeException {

    private final List<String> details;

    public ValidationException(String message) {
        super(message);
        this.details = List.of();
    }

    public ValidationException(String message, List<String> details) {
        super(message);
        this.details = details != null ? details : List.of();
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
        this.details = List.of();
    }

    public List<String> getDetails() {
        return details;
    }
}
