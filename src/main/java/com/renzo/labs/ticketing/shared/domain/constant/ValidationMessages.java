package com.renzo.labs.ticketing.shared.domain.constant;

/**
 * Validation message constants for consistent error messaging.
 */
public final class ValidationMessages {

        private ValidationMessages() {
                // Utility class
        }

        public static final String REQUIRED_FIELD = "This field is required";
        public static final String INVALID_EMAIL = "Invalid email format";
        public static final String INVALID_PASSWORD = "Password must be at least "
                        + ValidationConstants.PASSWORD_MIN_LENGTH
                        + " characters";
        public static final String FIELD_TOO_SHORT = "Field must be at least " + ValidationConstants.FIELD_MIN_LENGTH
                        + " character(s)";
        public static final String FIELD_TOO_LONG = "Field must not exceed " + ValidationConstants.FIELD_MAX_LENGTH
                        + " characters";
        public static final String INVALID_UUID = "Invalid UUID format";
}
