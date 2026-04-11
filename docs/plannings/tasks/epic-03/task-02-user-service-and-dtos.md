# Task 2: User Service and DTOs

## Parent Epic
[Epic 3: User Module Foundation](../../epics/epic-03-user-module-foundation.md)

## Overview
Implement the business logic layer with UserService and create DTOs for API request/response handling.

## Combined Stories
- Story 3.3: Implement UserService
- Story 3.4: Create User DTOs

## Acceptance Criteria

### User Service
- [ ] `UserService` interface in `user/application/service/`
- [ ] `UserServiceImpl` in `user/infrastructure/service/`
- [ ] Methods:
  - [ ] `User createUser(CreateUserRequest request)`
  - [ ] `Optional<User> findById(UUID id)`
  - [ ] `Optional<User> findByEmail(String email)`
  - [ ] `boolean existsByEmail(String email)`
- [ ] Business rules:
  - [ ] Duplicate email check before creation
  - [ ] Password encoded with BCrypt before saving
  - [ ] Throws `ConflictException` if email exists
- [ ] Transactional boundaries:
  - [ ] Write operations: `@Transactional`
  - [ ] Read operations: `@Transactional(readOnly = true)`
- [ ] Proper dependency injection (constructor-based)

### DTOs
- [ ] `CreateUserRequest` in `user/application/dto/`:
  - [ ] Fields: email, password, firstName, lastName
  - [ ] @NotBlank, @Email on email
  - [ ] @Size(min=8) on password
  - [ ] @Size(max=100) on names
- [ ] `UpdateUserRequest` in `user/application/dto/`:
  - [ ] Fields: firstName, lastName (all optional)
- [ ] `UserResponse` in `user/application/dto/`:
  - [ ] Fields: id, email, firstName, lastName, role, createdAt
  - [ ] role as String (role.name())
  - [ ] createdAt as String
- [ ] `UserMapper` in `user/application/dto/`:
  - [ ] `toResponse(User user)` method
  - [ ] `toEntity(CreateUserRequest request)` method
  - [ ] @Component annotation

### Testing
- [ ] Unit tests for UserService with Mockito
- [ ] Test createUser with duplicate email throws exception
- [ ] Test password is encoded before saving
- [ ] Unit tests for UserMapper
- [ ] Integration tests for service layer

## Estimated Effort
4 hours

## Assignee
TBD

## Status
Not Started

## Dependencies
- Task 1 (User Entity and Repository) must be complete
- UserRepository must exist
- PasswordEncoder bean must be available
- ErrorResponse/Exception handling must work

## Notes
Service layer is where business rules live. Make sure ConflictException from shared module is available.
