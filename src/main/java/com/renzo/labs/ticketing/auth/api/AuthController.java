package com.renzo.labs.ticketing.auth.api;

import com.renzo.labs.ticketing.auth.application.AuthService;
import com.renzo.labs.ticketing.auth.infrastructure.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final CookieUtil cookieUtil;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request, 
                                                jakarta.servlet.http.HttpServletResponse response) {
        try {
            authService.register(request.getEmail(), request.getPassword());
            String token = authService.login(request.getEmail(), request.getPassword());
            cookieUtil.addCookie(response, token);
            
            return ResponseEntity.ok(AuthResponse.success("Registration successful", request.getEmail()));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(AuthResponse.success(e.getMessage(), null));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request,
                                            jakarta.servlet.http.HttpServletResponse response) {
        try {
            String token = authService.login(request.getEmail(), request.getPassword());
            cookieUtil.addCookie(response, token);
            
            return ResponseEntity.ok(AuthResponse.success("Login successful", request.getEmail()));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(AuthResponse.success(e.getMessage(), null));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<AuthResponse> logout(jakarta.servlet.http.HttpServletResponse response) {
        authService.logout(response);
        return ResponseEntity.ok(AuthResponse.success("Logout successful", null));
    }
}
