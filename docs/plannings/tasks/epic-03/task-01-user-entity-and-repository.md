# Task 1: User Entity and Repository

## Parent Epic
[Epic 3: User Module Foundation](../../epics/epic-03-user-module-foundation.md)

## Overview
Create the User entity with JPA mappings and implement the repository layer for database operations.

## Combined Stories
- Story 3.1: Create User Entity
- Story 3.2: Implement UserRepository

## Acceptance Criteria

### User Entity
- [ ] `User` entity exists in `user/domain/entity/`
- [ ] Extends `BaseEntity` (from shared module)
- [ ] Fields with proper JPA annotations:
  - [ ] `email`: String (unique, not null, max 255)
  - [ ] `password`: String (not null, max 255)
  - [ ] `firstName`: String (max 100)
  - [ ] `lastName`: String (max 100)
  - [ ] `role`: Enum (USER, ADMIN) - defaults to USER
- [ ] Database constraints:
  - [ ] Unique index on email
  - [ ] Non-null constraints where applicable
  - [ ] Password column allows 60 chars for BCrypt
- [ ] `Role` enum in `user/domain/vo/`:
  - [ ] USER, ADMIN values
  - [ ] Defaults to USER in entity
- [ ] Lombok annotations for clean code
- [ ] Builder pattern support

### Repository
- [ ] `UserRepository` interface in `user/domain/repository/`
- [ ] Extends `JpaRepository<User, UUID>`
- [ ] Custom finder methods:
  - [ ] `Optional<User> findByEmail(String email)`
  - [ ] `boolean existsByEmail(String email)`

### Database Migration
- [ ] Flyway migration `V1__Create_users_table.sql`
- [ ] Creates users table with proper columns
- [ ] Includes unique index on email
- [ ] Compatible with User entity mapping

### Testing
- [ ] Integration tests with @DataJpaTest
- [ ] Test `findByEmail` returns correct user
- [ ] Test `existsByEmail` returns correct boolean
- [ ] Test entity persistence and retrieval

## Estimated Effort
4 hours

## Assignee
TBD

## Status
Not Started

## Dependencies
- Epic 2 (Shared Infrastructure) must be complete
- BaseEntity must exist
- PostgreSQL must be configured

## Notes
User entity is the foundation for authentication. Make sure password column can store BCrypt hash (60 chars).
