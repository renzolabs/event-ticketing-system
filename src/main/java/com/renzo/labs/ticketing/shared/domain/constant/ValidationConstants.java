package com.renzo.labs.ticketing.shared.domain.constant;

import java.util.regex.Pattern;

/**
 * Constants for validation patterns and constraints.
 */
public final class ValidationConstants {

    private ValidationConstants() {
        // Utility class
    }

    // Email regex pattern (RFC 5322 compliant)
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*"
            + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
    public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // UUID regex pattern
    public static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}"
            + "-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    public static final Pattern UUID_PATTERN = Pattern.compile(UUID_REGEX);

    // Password constraints
    public static final int PASSWORD_MIN_LENGTH = 8;
    public static final int PASSWORD_MAX_LENGTH = 128;

    // Field length constraints
    public static final int FIELD_MIN_LENGTH = 1;
    public static final int FIELD_MAX_LENGTH = 255;
}
