# Story 4.3: Implement AuthService

## Epic
[Epic 4: Authentication Module](../epics/epic-04-authentication.md)

## Story
**As a** user  
**I want to** register and login to the system  
**So that** I can access protected features

## Acceptance Criteria
- [ ] `AuthService` interface in `auth/application/service/`
- [ ] `AuthServiceImpl` in `auth/infrastructure/service/`
- [ ] Methods:
  - `User register(RegisterRequest request)` - Create new user
  - `AuthResult login(LoginRequest request)` - Authenticate and return token
  - `Optional<User> getCurrentUser(UUID userId)` - Get current user
- [ ] Registration validates email uniqueness
- [ ] Login validates credentials (email + password)
- [ ] Passwords encoded with BCrypt
- [ ] Returns appropriate errors for invalid credentials

## Tasks
1. Create `auth/application/service/AuthService.java` (interface)
2. Create `auth/infrastructure/service/AuthServiceImpl.java`
3. Create DTOs: `RegisterRequest`, `LoginRequest`, `AuthResult`
4. Inject UserService and PasswordEncoder
5. Inject JwtProvider and CookieUtil
6. Implement register with duplicate email check
7. Implement login with credential validation
8. Write unit tests

## Estimated Effort
2 hours

## Priority
Must Have

## Notes
AuthService orchestrates UserService for persistence and JwtProvider for tokens.

Implementation skeleton:
```java
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    
    @Override
    public User register(RegisterRequest request) {
        // Check email exists
        // Create user with encoded password
        // Return user
    }
    
    @Override
    public AuthResult login(LoginRequest request) {
        // Find user by email
        // Validate password
        // Generate JWT
        // Return AuthResult with user and token
    }
}
```
