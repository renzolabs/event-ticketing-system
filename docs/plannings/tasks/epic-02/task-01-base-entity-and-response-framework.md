# Task 1: Base Entity and Response Framework

## Parent Epic
[Epic 2: Shared Infrastructure](../../epics/epic-02-shared-infrastructure.md)

## Overview
Create the foundational shared components: base entity class for all domain models and common response DTOs for API consistency.

## Combined Stories
- Story 2.1: Create Base Entity Class
- Story 2.3: Create Common Response DTOs

## Acceptance Criteria

### Base Entity
- [ ] `BaseEntity` class exists in `shared/domain/entity/`
- [ ] Uses `@MappedSuperclass` annotation
- [ ] Fields included:
  - [ ] `id`: UUID (primary key, auto-generated)
  - [ ] `createdAt`: LocalDateTime (auto-set on create)
  - [ ] `updatedAt`: LocalDateTime (auto-updated on modify)
- [ ] Uses JPA annotations for lifecycle callbacks:
  - [ ] `@PrePersist` for createdAt
  - [ ] `@PreUpdate` for updatedAt
- [ ] Uses UUID generation strategy
- [ ] Lombok annotations for clean code
- [ ] All entities can extend this class

### Response DTOs
- [ ] `ApiResponse<T>` class exists for success responses:
  - [ ] Generic type support
  - [ ] Fields: data, message, timestamp
  - [ ] Static factory methods: `success(data)`, `success(data, message)`
- [ ] `ErrorResponse` class exists for error responses:
  - [ ] Fields: error, message, details, timestamp
  - [ ] Static factory methods: `of(error, message)`, `of(error, message, details)`
- [ ] `PageResponse<T>` class exists for paginated responses:
  - [ ] Fields: content, page, size, totalElements, totalPages
  - [ ] Generic type support
- [ ] Builder pattern for all DTOs
- [ ] Timestamp auto-generation

### Testing
- [ ] Unit test for BaseEntity timestamp behavior
- [ ] Unit tests for DTO factory methods

## Estimated Effort
4 hours

## Assignee
TBD

## Status
Completed (100%)

## Dependencies
- Epic 1 (Project Setup) must be complete

## Notes
These components are the foundation for all domain entities and API responses. Get them right early.
