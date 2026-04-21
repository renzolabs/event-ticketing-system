# Task 3: Security Configuration and Auth Controller

## Parent Epic
[Epic 4: Authentication Module](../../epics/epic-04-authentication.md)

## Overview
Configure Spring Security and create REST endpoints for authentication.

## Combined Stories
- Story 4.5: Configure Spring Security
- Story 4.6: Create AuthController

## Acceptance Criteria

### Security Configuration
- [ ] `SecurityConfig` in `auth/infrastructure/config/`
- [ ] Annotations: `@Configuration`, `@EnableWebSecurity`
- [ ] `SecurityFilterChain` bean:
  - [ ] Stateless session management
  - [ ] CSRF disabled (for stateless JWT APIs)
  - [ ] Public endpoints permitted:
    - [ ] `POST /api/auth/register`
    - [ ] `POST /api/auth/login`
    - [ ] `POST /api/auth/logout`
    - [ ] `GET /api/auth/me` (requires auth - fix if needed)
    - [ ] `/actuator/**`
  - [ ] All other endpoints require authentication
- [ ] JwtAuthenticationFilter added to filter chain:
  - [ ] Added before `UsernamePasswordAuthenticationFilter`
- [ ] `PasswordEncoder` bean:
  - [ ] Returns `BCryptPasswordEncoder`
  - [ ] Strength 10 (default)
- [ ] CORS configuration (if needed for frontend)

### AuthController
- [ ] `AuthController` in `auth/api/controller/`
- [ ] Base path: `/api/auth`
- [ ] Endpoints:
  - [ ] `POST /register` - User registration
    - [ ] Accepts RegisterRequest
    - [ ] Creates user via AuthService
    - [ ] Sets auth cookie with JWT
    - [ ] Returns UserResponse
  - [ ] `POST /login` - User login
    - [ ] Accepts LoginRequest
    - [ ] Authenticates via AuthService
    - [ ] Sets auth cookie with JWT
    - [ ] Returns AuthResponse (user + token info)
  - [ ] `POST /logout` - User logout
    - [ ] Clears auth cookie
    - [ ] Returns success message
  - [ ] `GET /me` - Get current user
    - [ ] Requires authentication
    - [ ] Returns UserResponse from SecurityContext
- [ ] Response format:
  - [ ] Uses ApiResponse wrapper
  - [ ] Consistent response structure
- [ ] Cookie handling:
  - [ ] Uses CookieUtil for cookie creation/clearing
  - [ ] HttpServletResponse for cookie headers

### Testing
- [ ] Integration tests with MockMvc
- [ ] Test register → login → access /me → logout flow
- [ ] Test protected endpoint without auth returns 401
- [ ] Test logout clears cookie

## Estimated Effort
4 hours

## Assignee
TBD

## Status
In Progress (80%)

## Dependencies
- Task 2 (Authentication Service and Filter) must be complete
- AuthService and JwtAuthenticationFilter must exist

## Notes
This is the final piece of authentication. After this, the full auth flow should work: Register → Login → Access Protected Endpoints → Logout.
