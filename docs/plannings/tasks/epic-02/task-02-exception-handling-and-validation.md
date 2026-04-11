# Task 2: Exception Handling and Validation Framework

## Parent Epic
[Epic 2: Shared Infrastructure](../../epics/epic-02-shared-infrastructure.md)

## Overview
Create global exception handling and validation utilities for consistent error responses and validation rules across the application.

## Combined Stories
- Story 2.2: Create Global Exception Handler
- Story 2.4: Setup Validation Utilities

## Acceptance Criteria

### Exception Handler
- [ ] `GlobalExceptionHandler` class exists in `shared/infrastructure/exception/`
- [ ] Uses `@RestControllerAdvice` annotation
- [ ] Custom exception classes created:
  - [ ] `NotFoundException` (extends RuntimeException)
  - [ ] `ValidationException` (extends RuntimeException)
  - [ ] `ConflictException` (extends RuntimeException)
- [ ] Handler methods for each exception type:
  - [ ] `NotFoundException` → HTTP 404
  - [ ] `ValidationException` / `MethodArgumentNotValidException` → HTTP 400
  - [ ] `AccessDeniedException` → HTTP 403
  - [ ] `ConflictException` → HTTP 409
  - [ ] Generic `Exception` → HTTP 500
- [ ] Returns consistent error response format:
  ```json
  {
    "error": "Error type",
    "message": "Human readable message",
    "details": ["Specific details"],
    "timestamp": "2024-01-01T00:00:00Z"
  }
  ```
- [ ] Proper logging for each error level

### Validation Utilities
- [ ] `ValidationConstants` class in `shared/domain/constant/`:
  - [ ] Email regex pattern
  - [ ] Password min/max length constants
  - [ ] UUID regex pattern
- [ ] `ValidationMessages` class with message constants:
  - [ ] REQUIRED_FIELD
  - [ ] INVALID_EMAIL
  - [ ] INVALID_PASSWORD
  - [ ] FIELD_TOO_SHORT
  - [ ] FIELD_TOO_LONG
- [ ] Custom validators (optional but recommended):
  - [ ] `@ValidEmail` annotation
  - [ ] `@ValidPassword` annotation

### Testing
- [ ] Integration tests for exception handlers with MockMvc
- [ ] Test each exception type returns correct HTTP status

## Estimated Effort
4 hours

## Assignee
TBD

## Status
Not Started

## Dependencies
- Task 1 (Base Entity and Response Framework) should be done first
- ErrorResponse DTO must exist

## Notes
Exception handler relies on ErrorResponse from Task 1. Make sure that's done first.
