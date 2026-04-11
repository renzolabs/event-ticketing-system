# Story 3.4: Create User DTOs

## Epic
[Epic 3: User Module Foundation](../epics/epic-03-user-module-foundation.md)

## Story
**As a** API consumer  
**I want to** use well-defined request/response objects  
**So that** the API contract is clear and type-safe

## Acceptance Criteria
- [ ] DTOs created in `user/application/dto/`
- [ ] Request DTOs:
  - `CreateUserRequest`: email, password, firstName, lastName
  - `UpdateUserRequest`: firstName, lastName (optional fields)
- [ ] Response DTOs:
  - `UserResponse`: id, email, firstName, lastName, role, createdAt
- [ ] Validation annotations on request DTOs:
  - @NotBlank, @Email on email
  - @Size on password (min 8)
  - @Size on names (max 100)
- [ ] Mapper class `UserMapper` for entity <-> DTO conversion
- [ ] Lombok annotations for clean code

## Tasks
1. Create `user/application/dto/CreateUserRequest.java`
2. Create `user/application/dto/UpdateUserRequest.java`
3. Create `user/application/dto/UserResponse.java`
4. Create `user/application/dto/UserMapper.java`
5. Add Jakarta Validation annotations
6. Write unit tests for mapper

## Estimated Effort
1.5 hours

## Priority
Must Have

## Notes
DTOs separate internal entity structure from API contract. This allows flexibility in changing internals without affecting API consumers.

DTO examples:
```java
@Data
@Builder
public class CreateUserRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
    
    @Size(max = 100, message = "First name too long")
    private String firstName;
    
    @Size(max = 100, message = "Last name too long")
    private String lastName;
}

@Data
@Builder
public class UserResponse {
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    private String createdAt;
}

@Component
public class UserMapper {
    public UserResponse toResponse(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .email(user.getEmail())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .role(user.getRole().name())
            .createdAt(user.getCreatedAt().toString())
            .build();
    }
}
```
