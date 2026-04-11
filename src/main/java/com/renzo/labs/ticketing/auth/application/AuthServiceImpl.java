package com.renzo.labs.ticketing.auth.application;

import com.renzo.labs.ticketing.auth.domain.Role;
import com.renzo.labs.ticketing.auth.domain.User;
import com.renzo.labs.ticketing.auth.infrastructure.CookieUtil;
import com.renzo.labs.ticketing.auth.infrastructure.JwtProvider;
import com.renzo.labs.ticketing.auth.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CookieUtil cookieUtil;

    @Override
    @Transactional
    public User register(String email, String password) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtProvider.generateToken(email);
    }

    @Override
    public void logout(jakarta.servlet.http.HttpServletResponse response) {
        cookieUtil.clearCookie(response);
    }
}
