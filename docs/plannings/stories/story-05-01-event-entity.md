# Story 5.1: Create Event Entity and Repository

## Epic
[Epic 5: Event Ticket Booking Core](../epics/epic-05-event-ticketing-core.md)

## Story
**As a** developer  
**I want to** define the Event entity and repository  
**So that** events can be stored and retrieved from the database

## Acceptance Criteria
- [ ] `Event` entity in `event/domain/entity/`
- [ ] Fields:
  - `id`: UUID (PK)
  - `title`: String (required, max 255)
  - `description`: Text
  - `location`: String (max 500)
  - `startTime`: Instant (required)
  - `endTime`: Instant
  - `status`: Enum (DRAFT, PUBLISHED, CANCELLED, ARCHIVED)
  - `category`: String (max 100)
  - `organizerId`: UUID (FK to User, nullable)
  - `createdAt`, `updatedAt`: Instant
- [ ] `EventRepository` in `event/domain/repository/`
- [ ] Repository methods:
  - `findByStatusAndStartTimeAfter(status, time, pageable)`
  - `findByStatus(status, pageable)`
  - `findByCategoryAndStatus(category, status, pageable)`
- [ ] Flyway migration: `V5.1__create_events_table.sql`

## Tasks
1. Create `Event` entity with JPA annotations
2. Create `EventStatus` enum
3. Create `EventRepository` interface
4. Write migration for events table
5. Write unit tests for entity

## Estimated Effort
1.5 hours

## Priority
Must Have

## Notes
Event is the core domain object. Soft delete via status = ARCHIVED. Events start in DRAFT status, must be PUBLISHED to be visible.
