package com.renzo.labs.ticketing.user.api;

import com.renzo.labs.ticketing.auth.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    
    private String email;
    private Role role;
    private LocalDateTime createdAt;
    
    public static UserResponse from(final com.renzo.labs.ticketing.auth.domain.User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
