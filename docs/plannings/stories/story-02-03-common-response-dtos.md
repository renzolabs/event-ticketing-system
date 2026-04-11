# Story 2.3: Create Common Response DTOs

## Epic
[Epic 2: Shared Infrastructure](../epics/epic-02-shared-infrastructure.md)

## Story
**As a** API consumer  
**I want to** receive consistent success and error response formats  
**So that** I can parse responses reliably

## Acceptance Criteria
- [ ] `ApiResponse<T>` class exists for success responses:
  ```json
  {
    "data": {},
    "message": "Success",
    "timestamp": "2024-01-01T00:00:00Z"
  }
  ```
- [ ] `ErrorResponse` class exists for error responses:
  ```json
  {
    "error": "Error type",
    "message": "Human readable message",
    "details": ["Specific details"],
    "timestamp": "2024-01-01T00:00:00Z"
  }
  ```
- [ ] `PageResponse<T>` class exists for paginated responses:
  ```json
  {
    "content": [],
    "page": 0,
    "size": 20,
    "totalElements": 100,
    "totalPages": 5
  }
  ```
- [ ] Builder pattern or factory methods provided
- [ ] Uses generic types for type safety

## Tasks
1. Create `shared/application/dto/ApiResponse.java`
2. Create `shared/application/dto/ErrorResponse.java`
3. Create `shared/application/dto/PageResponse.java`
4. Add static factory methods:
   - `ApiResponse.success(data)`
   - `ApiResponse.success(data, message)`
   - `ErrorResponse.of(error, message)`
   - `ErrorResponse.of(error, message, details)`
5. Add Lombok annotations for clean code
6. Ensure timestamp auto-generation

## Estimated Effort
1 hour

## Priority
Must Have

## Notes
These DTOs will be used by all controllers. Consistency is critical for API consumers.

Implementation structure:
```java
@Data
@Builder
public class ApiResponse<T> {
    private T data;
    private String message;
    private String timestamp;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
            .data(data)
            .message("Success")
            .timestamp(Instant.now().toString())
            .build();
    }
}

@Data
@Builder
public class ErrorResponse {
    private String error;
    private String message;
    private List<String> details;
    private String timestamp;
}
```
