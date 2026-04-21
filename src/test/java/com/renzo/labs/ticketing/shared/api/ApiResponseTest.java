package com.renzo.labs.ticketing.shared.api;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApiResponseTest {

    @Test
    void success_withData_shouldCreateResponse() {
        String data = "test data";

        ApiResponse<String> response = ApiResponse.success(data);

        assertNotNull(response);
        assertEquals(data, response.getData());
        assertEquals("Success", response.getMessage());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void success_withDataAndMessage_shouldCreateResponse() {
        String data = "test data";
        String message = "Custom success message";

        ApiResponse<String> response = ApiResponse.success(data, message);

        assertNotNull(response);
        assertEquals(data, response.getData());
        assertEquals(message, response.getMessage());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void success_shouldSetCurrentTimestamp() {
        LocalDateTime before = LocalDateTime.now().minusSeconds(1);

        ApiResponse<String> response = ApiResponse.success("data");

        LocalDateTime after = LocalDateTime.now().plusSeconds(1);
        assertNotNull(response.getTimestamp());
        assertTrue(response.getTimestamp().isAfter(before) || response.getTimestamp().equals(before));
        assertTrue(response.getTimestamp().isBefore(after) || response.getTimestamp().equals(after));
    }

    @Test
    void builder_shouldCreateResponse() {
        String data = "builder data";
        String message = "builder message";
        LocalDateTime timestamp = LocalDateTime.now();

        ApiResponse<String> response = ApiResponse.<String>builder()
                .data(data)
                .message(message)
                .timestamp(timestamp)
                .build();

        assertEquals(data, response.getData());
        assertEquals(message, response.getMessage());
        assertEquals(timestamp, response.getTimestamp());
    }

    @Test
    void genericType_shouldWorkWithDifferentTypes() {
        ApiResponse<Integer> intResponse = ApiResponse.success(42);
        assertEquals(42, intResponse.getData());

        ApiResponse<Boolean> boolResponse = ApiResponse.success(true);
        assertEquals(true, boolResponse.getData());
    }

    private static void assertTrue(boolean condition) {
        org.junit.jupiter.api.Assertions.assertTrue(condition);
    }
}
