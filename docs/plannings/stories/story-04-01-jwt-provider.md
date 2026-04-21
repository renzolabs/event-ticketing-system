# Story 4.1: Create JwtProvider Utility

## Epic
[Epic 4: Authentication Module](../epics/epic-04-authentication.md)

## Story
**As a** developer  
**I want to** have a JWT utility class  
**So that** I can generate and validate JWT tokens for authentication

## Acceptance Criteria
- [ ] `JwtProvider` class exists in `auth/infrastructure/security/`
- [ ] Can generate JWT token with user ID and email as claims
- [ ] Can validate JWT token and return user details
- [ ] Can extract user ID from token
- [ ] Token has configurable expiration (default 1 hour)
- [ ] Uses HS256 algorithm with secret key from configuration
- [ ] Handles expired/invalid tokens gracefully

## Tasks
1. Create `auth/infrastructure/security/JwtProvider.java`
2. Add methods: `generateToken(User)`, `validateToken(String)`, `getUserIdFromToken(String)`
3. Configure JWT secret and expiration in `application.yml`
4. Add JJWT dependencies (already in pom.xml)
5. Write unit tests for token generation and validation

## Estimated Effort
2 hours

## Priority
Must Have

## Notes
JJWT library already included in pom.xml (version 0.12.5). Secret key should be externalized via environment variable for production.

Implementation skeleton:
```java
@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;
    
    @Value("${jwt.expiration:3600000}")
    private long jwtExpiration;
    
    public String generateToken(User user) {
        // Generate JWT with user claims
    }
    
    public boolean validateToken(String token) {
        // Validate signature and expiration
    }
    
    public UUID getUserIdFromToken(String token) {
        // Extract user ID claim
    }
}
```
