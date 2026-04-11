# Story 4.6: Create AuthController

## Epic
[Epic 4: Authentication Module](../epics/epic-04-authentication.md)

## Story
**As an** API consumer  
**I want to** have authentication endpoints  
**So that** users can register, login, and logout

## Acceptance Criteria
- [ ] `AuthController` in `auth/api/controller/`
- [ ] Endpoints:
  - `POST /api/auth/register` - Returns UserResponse, sets auth cookie
  - `POST /api/auth/login` - Returns AuthResponse, sets auth cookie
  - `POST /api/auth/logout` - Clears auth cookie
  - `GET /api/auth/me` - Returns current user info (requires auth)
- [ ] Uses AuthService for business logic
- [ ] Uses CookieUtil for cookie management
- [ ] Returns consistent response format via ApiResponse wrapper
- [ ] Proper validation on request DTOs

## Tasks
1. Create `auth/api/controller/AuthController.java`
2. Create request DTOs: `RegisterRequest`, `LoginRequest`
3. Create response DTO: `AuthResponse`
4. Implement register endpoint
5. Implement login endpoint with cookie
6. Implement logout endpoint
7. Implement me endpoint (get current user)
8. Write integration tests with MockMvc

## Estimated Effort
2 hours

## Priority
Must Have

## Notes
Cookie handling uses ResponseCookie with HttpServletResponse. API responses follow the standard format.

Implementation skeleton:
```java
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final CookieUtil cookieUtil;
    private final UserMapper userMapper;
    
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(
            @Valid @RequestBody RegisterRequest request,
            HttpServletResponse response) {
        // Register user
        // Create auth cookie
        // Return response
    }
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletResponse response) {
        // Authenticate
        // Create auth cookie
        // Return response with token info
    }
    
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(HttpServletResponse response) {
        // Clear auth cookie
        // Return success
    }
    
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserResponse>> getCurrentUser(
            @AuthenticationPrincipal UserDetails userDetails) {
        // Return current user info
    }
}
```
