# Story 2.2: Create Global Exception Handler

## Epic
[Epic 2: Shared Infrastructure](../epics/epic-02-shared-infrastructure.md)

## Story
**As a** API consumer  
**I want to** receive consistent error responses  
**So that** I can handle errors predictably in my application

## Acceptance Criteria
- [ ] `GlobalExceptionHandler` class exists in `shared/infrastructure/exception/`
- [ ] Uses `@RestControllerAdvice` annotation
- [ ] Handles common exceptions:
  - `EntityNotFoundException` → 404
  - `ValidationException` / `MethodArgumentNotValidException` → 400
  - `AccessDeniedException` → 403
  - `IllegalArgumentException` → 400
  - `Exception` (generic) → 500
- [ ] Returns consistent error response format matching API docs:
  ```json
  {
    "error": "Error type",
    "message": "Human readable message",
    "details": ["Specific details"],
    "timestamp": "2024-01-01T00:00:00Z"
  }
  ```
- [ ] Includes timestamp in error response
- [ ] Logs errors appropriately

## Tasks
1. Create `shared/infrastructure/exception/GlobalExceptionHandler.java`
2. Create custom exception classes:
   - `NotFoundException`
   - `ValidationException`
   - `ConflictException`
3. Create `ErrorResponse` DTO
4. Implement handler methods for each exception type
5. Add logging for each error level
6. Write integration tests with MockMvc

## Estimated Effort
2 hours

## Priority
Must Have

## Notes
Error format must match the API documentation exactly. This ensures frontend and API consumers have a predictable contract.

Exception class structure:
```java
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex) {
        // Implementation
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        // Extract field errors into details array
    }

    // ... other handlers
}
```
