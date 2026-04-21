package com.renzo.labs.ticketing.shared.api;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Generic API response wrapper for successful responses.
 *
 * @param <T> the type of data in the response
 */
@Getter
@Builder
public class ApiResponse<T> {

    private final T data;
    private final String message;
    private final LocalDateTime timestamp;

    /**
     * Creates a success response with data only.
     *
     * @param data the response data
     * @param <T>  the type of data
     * @return ApiResponse with data and default message
     */
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .data(data)
                .message("Success")
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * Creates a success response with data and custom message.
     *
     * @param data    the response data
     * @param message the success message
     * @param <T>     the type of data
     * @return ApiResponse with data and custom message
     */
    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .data(data)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
