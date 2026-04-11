package com.renzo.labs.ticketing.user.application;

import com.renzo.labs.ticketing.auth.domain.User;

public interface UserService {
    User getUserById(Long id);
    User getUserByEmail(String email);
    User getCurrentUser(String email);
}
