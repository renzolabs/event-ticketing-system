package com.renzo.labs.ticketing.auth.application;

import com.renzo.labs.ticketing.auth.domain.User;

public interface AuthService {
    User register(String email, String password);
    String login(String email, String password);
    void logout(jakarta.servlet.http.HttpServletResponse response);
}
