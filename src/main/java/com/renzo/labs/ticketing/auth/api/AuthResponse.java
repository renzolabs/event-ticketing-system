package com.renzo.labs.ticketing.auth.api;

import lombok.Data;

@Data
public class AuthResponse {
    private String message;
    private String email;
    
    public static AuthResponse success(String message, String email) {
        AuthResponse response = new AuthResponse();
        response.setMessage(message);
        response.setEmail(email);
        return response;
    }
}
