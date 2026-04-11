# Story 4.2: Create CookieUtil for HTTP-Only Cookies

## Epic
[Epic 4: Authentication Module](../epics/epic-04-authentication.md)

## Story
**As a** developer  
**I want to** have a utility for managing authentication cookies  
**So that** JWT tokens are securely delivered via HTTP-only cookies

## Acceptance Criteria
- [ ] `CookieUtil` class exists in `auth/infrastructure/security/`
- [ ] Can create auth cookie with JWT token:
  - HTTP-only flag
  - Secure flag (configurable)
  - SameSite=Strict
  - Path=/
  - MaxAge matches token expiration
- [ ] Can clear auth cookie (for logout)
- [ ] Cookie name configurable (default: `access_token`)
- [ ] Proper handling in different environments (dev/prod)

## Tasks
1. Create `auth/infrastructure/security/CookieUtil.java`
2. Add `createAuthCookie(String jwt)` method
3. Add `clearAuthCookie()` method
4. Make flags configurable via application.yml
5. Write unit tests

## Estimated Effort
1 hour

## Priority
Must Have

## Notes
HTTP-only cookies prevent XSS attacks from stealing the token. Secure flag should be enabled in production.

Implementation skeleton:
```java
@Component
public class CookieUtil {
    @Value("${app.auth.cookie-name:access_token}")
    private String cookieName;
    
    @Value("${app.auth.cookie-secure:false}")
    private boolean secure;
    
    public ResponseCookie createAuthCookie(String jwt) {
        return ResponseCookie.from(cookieName, jwt)
            .httpOnly(true)
            .secure(secure)
            .sameSite("Strict")
            .path("/")
            .maxAge(Duration.ofHours(1))
            .build();
    }
    
    public ResponseCookie clearAuthCookie() {
        return ResponseCookie.from(cookieName, "")
            .httpOnly(true)
            .secure(secure)
            .sameSite("Strict")
            .path("/")
            .maxAge(Duration.ZERO)
            .build();
    }
}
```
