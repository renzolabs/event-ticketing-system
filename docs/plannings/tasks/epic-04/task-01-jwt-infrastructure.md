# Task 1: JWT Infrastructure

## Parent Epic
[Epic 4: Authentication Module](../../epics/epic-04-authentication.md)

## Overview
Create JWT token provider and cookie utilities for authentication infrastructure.

## Combined Stories
- Story 4.1: Create JwtProvider Utility
- Story 4.2: Create CookieUtil for HTTP-Only Cookies

## Acceptance Criteria

### JwtProvider
- [ ] `JwtProvider` class in `auth/infrastructure/security/`
- [ ] Methods:
  - [ ] `String generateToken(User user)` - creates JWT with user claims
  - [ ] `boolean validateToken(String token)` - validates signature and expiration
  - [ ] `UUID getUserIdFromToken(String token)` - extracts user ID claim
  - [ ] `String getEmailFromToken(String token)` - extracts email claim
- [ ] Configuration:
  - [ ] JWT secret from `app.jwt.secret` (externalized)
  - [ ] Expiration from `app.jwt.expiration` (default 1 hour)
- [ ] Token claims:
  - [ ] `sub`: user ID
  - [ ] `email`: user email
  - [ ] `iat`: issued at
  - [ ] `exp`: expiration
- [ ] Uses HS256 algorithm
- [ ] Proper error handling for invalid tokens

### CookieUtil
- [ ] `CookieUtil` class in `auth/infrastructure/security/`
- [ ] Methods:
  - [ ] `ResponseCookie createAuthCookie(String jwt)`
  - [ ] `ResponseCookie clearAuthCookie()`
- [ ] Cookie settings:
  - [ ] HTTP-only flag (prevents XSS)
  - [ ] Secure flag (configurable, true in prod)
  - [ ] SameSite=Strict
  - [ ] Path=/
  - [ ] MaxAge matches JWT expiration
- [ ] Cookie name configurable (default: `access_token`)
- [ ] Clear cookie sets MaxAge=0 and empty value

### Testing
- [ ] Unit tests for JwtProvider
- [ ] Test token generation and validation
- [ ] Test expired token rejection
- [ ] Test cookie creation properties

## Estimated Effort
4 hours

## Assignee
TBD

## Status
In Progress (75%)

## Dependencies
- Epic 3 (User Module) must be complete
- UserService must exist

## Notes
JJWT library already in pom.xml. Keep JWT secret externalized - never commit secrets to repo.
