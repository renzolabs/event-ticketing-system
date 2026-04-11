# Spring Boot Best Practices

## Dependency Injection
- **Always use constructor-based injection**
- **NEVER use `@Autowired` on fields**
- Use `final` for injected dependencies
- Use `@RequiredArgsConstructor` from Lombok

## REST API Standards
- **URLs**: Use kebab-case (e.g., `/api/v1/user-roles`)
- **Return type**: Every controller must return `ResponseEntity<T>`
- **HTTP methods**: Use appropriate methods (GET, POST, PUT, DELETE)
- **Status codes**: Return proper HTTP status codes (200, 201, 400, 404, etc.)

## Naming Conventions
| Component | Suffix | Example |
|-----------|--------|---------|
| Controller | `Controller` | `UserController` |
| Service | `Service` | `UserService` |
| Repository | `Repository` | `UserRepository` |
| Entity | (none) | `User` |
| DTO Request | `Request` | `CreateUserRequest` |
| DTO Response | `Response` | `UserResponse` |

## Lombok Annotations
Use these to reduce boilerplate:
- `@Data` - Getters, setters, toString, equals, hashCode
- `@Builder` - Builder pattern
- `@NoArgsConstructor` - Default constructor
- `@AllArgsConstructor` - All-args constructor
- `@RequiredArgsConstructor` - Constructor for `final` fields
- `@Slf4j` - Logging

## Validation
- Use **Jakarta Validation** annotations on all DTOs
- Common annotations:
  - `@NotBlank` - For strings
  - `@NotNull` - For objects
  - `@Min(value)` - For numbers
  - `@Email` - For email validation
  - `@Size(min, max)` - For collections/strings

## Layered Architecture
```
src/main/java/com/example/project/
├── api/           # Controllers, DTOs
├── application/   # Services, business logic
├── domain/        # Entities, enums
└── infrastructure/# Repositories, external APIs
```

## Response Format
All API responses should follow this structure:
```json
{
  "data": { },
  "message": "Success",
  "timestamp": "2025-04-12T10:30:00Z"
}
```

## Error Handling
- Use `@ControllerAdvice` with `GlobalExceptionHandler`
- Return structured error responses
- Log errors appropriately
