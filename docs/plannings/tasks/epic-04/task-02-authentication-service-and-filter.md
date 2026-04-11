# Task 2: Authentication Service and Filter

## Parent Epic
[Epic 4: Authentication Module](../../epics/epic-04-authentication.md)

## Overview
Implement authentication business logic with AuthService and JWT authentication filter.

## Combined Stories
- Story 4.3: Implement AuthService
- Story 4.4: Implement JwtAuthenticationFilter

## Acceptance Criteria

### AuthService
- [ ] `AuthService` interface in `auth/application/service/`
- [ ] `AuthServiceImpl` in `auth/infrastructure/service/`
- [ ] Methods:
  - [ ] `User register(RegisterRequest request)` - create new user
  - [ ] `AuthResult login(LoginRequest request)` - authenticate user
  - [ ] `Optional<User> getCurrentUser(UUID userId)` - get user by ID
- [ ] Register functionality:
  - [ ] Validates email uniqueness
  - [ ] Encodes password with BCrypt
  - [ ] Creates user via UserService
  - [ ] Returns created user
- [ ] Login functionality:
  - [ ] Finds user by email
  - [ ] Validates password with BCrypt
  - [ ] Generates JWT token
  - [ ] Returns AuthResult (user + token info)
- [ ] Error handling:
  - [ ] Invalid credentials → appropriate error
  - [ ] Duplicate email on register → ConflictException

### DTOs
- [ ] `RegisterRequest`: email, password, firstName, lastName
- [ ] `LoginRequest`: email, password
- [ ] `AuthResult`: user, token, expiresIn

### JwtAuthenticationFilter
- [ ] `JwtAuthenticationFilter` extends `OncePerRequestFilter`
- [ ] Located in `auth/infrastructure/security/`
- [ ] Functionality:
  - [ ] Extracts JWT from `access_token` cookie
  - [ ] Validates JWT using JwtProvider
  - [ ] Loads user details from token
  - [ ] Sets SecurityContext with Authentication
- [ ] Public paths bypass filter:
  - [ ] `/api/auth/**` (register, login, logout)
  - [ ] `/actuator/**` (health checks)
- [ ] Returns 401 for invalid/missing tokens on protected endpoints

### Testing
- [ ] Unit tests for AuthService
- [ ] Test register with duplicate email
- [ ] Test login with valid and invalid credentials
- [ ] Integration tests for filter
- [ ] Test protected endpoint requires auth

## Estimated Effort
4 hours

## Assignee
TBD

## Status
Not Started

## Dependencies
- Task 1 (JWT Infrastructure) must be complete
- JwtProvider and CookieUtil must exist
- UserService must exist

## Notes
AuthService orchestrates UserService for persistence and JwtProvider for tokens.
