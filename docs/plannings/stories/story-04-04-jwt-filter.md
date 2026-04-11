# Story 4.4: Implement JwtAuthenticationFilter

## Epic
[Epic 4: Authentication Module](../epics/epic-04-authentication.md)

## Story
**As a** system  
**I want to** validate JWT tokens on each request  
**So that** only authenticated users access protected endpoints

## Acceptance Criteria
- [ ] `JwtAuthenticationFilter` extends `OncePerRequestFilter`
- [ ] Located in `auth/infrastructure/security/`
- [ ] Extracts JWT from `access_token` cookie
- [ ] Validates JWT using JwtProvider
- [ ] Sets SecurityContext with authenticated user
- [ ] Skips authentication for public paths (/auth/**)
- [ ] Returns 401 for invalid/missing tokens on protected endpoints

## Tasks
1. Create `auth/infrastructure/security/JwtAuthenticationFilter.java`
2. Override `doFilterInternal` method
3. Extract and validate JWT from cookie
4. Create Authentication object for SecurityContext
5. Add to Spring Security filter chain
6. Write integration tests

## Estimated Effort
2 hours

## Priority
Must Have

## Notes
Filter runs before each request. Must handle both authenticated and unauthenticated paths.

Implementation skeleton:
```java
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final UserService userService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain chain) {
        // Extract token from cookie
        // Validate token
        // Load user details
        // Set SecurityContext
        // Continue filter chain
    }
    
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // Skip /auth/** paths
    }
}
```
