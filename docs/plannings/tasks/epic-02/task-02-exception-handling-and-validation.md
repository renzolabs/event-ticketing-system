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
- [x] `GlobalExceptionHandler` class exists in `shared/infrastructure/exception/`
- [x] Uses `@RestControllerAdvice` annotation
- [x] Custom exception classes created:
  - [x] `NotFoundException` (extends RuntimeException)
  - [x] `ValidationException` (extends RuntimeException)
  - [x] `ConflictException` (extends RuntimeException)
- [x] Handler methods for each exception type:
  - [x] `NotFoundException` → HTTP 404
  - [x] `ValidationException` / `MethodArgumentNotValidException` → HTTP 400
  - [x] `AccessDeniedException` → HTTP 403
  - [x] `ConflictException` → HTTP 409
  - [x] Generic `Exception` → HTTP 500
- [x] Returns consistent error response format:
  ```json
  {
    "error": "Error type",
    "message": "Human readable message",
    "details": ["Specific details"],
    "timestamp": "2024-01-01T00:00:00Z"
  }
  ```
- [x] Proper logging for each error level

### Validation Utilities
- [x] `ValidationConstants` class in `shared/domain/constant/`:
  - [x] Email regex pattern
  - [x] Password min/max length constants
  - [x] UUID regex pattern
- [x] `ValidationMessages` class with message constants:
  - [x] REQUIRED_FIELD
  - [x] INVALID_EMAIL
  - [x] INVALID_PASSWORD
  - [x] FIELD_TOO_SHORT
  - [x] FIELD_TOO_LONG
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
Completed (100%)

## Dependencies
- Task 1 (Base Entity and Response Framework) should be done first
- ErrorResponse DTO must exist

## Notes
Exception handler relies on ErrorResponse from Task 1. Make sure that's done first.
