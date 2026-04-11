package com.renzo.labs.ticketing.user.application;

import com.renzo.labs.ticketing.auth.domain.User;
import com.renzo.labs.ticketing.auth.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User getUserByEmail(final String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User getCurrentUser(final String email) {
        return getUserByEmail(email);
    }
}
