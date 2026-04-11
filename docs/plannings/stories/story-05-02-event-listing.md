# Story 5.2: Create Event Listing API

## Epic
[Epic 5: Event Ticket Booking Core](../epics/epic-05-event-ticketing-core.md)

## Story
**As a** user  
**I want to** browse available events  
**So that** I can choose one to book

## Acceptance Criteria
- [ ] `EventController` in `event/api/controller/`
- [ ] Endpoint: `GET /api/events`
- [ ] Query parameters:
  - `status` (default: PUBLISHED)
  - `category` (optional filter)
  - `from` (optional, start time after)
  - `page`, `size` (pagination)
- [ ] `EventService` in `event/application/service/`
- [ ] `EventResponse` DTO (id, title, description, location, startTime, endTime, category, status)
- [ ] `EventMapper` for entity → DTO conversion
- [ ] Paginated response with metadata

## Tasks
1. Create `EventService` with listing logic
2. Create `EventResponse` DTO
3. Create `EventMapper`
4. Create `EventController` with listing endpoint
5. Add pagination support
6. Write unit tests for service

## Estimated Effort
2 hours

## Priority
Must Have

## Notes
Only PUBLISHED events are visible to regular users. Admin users (future) can see all statuses. Default sort: startTime ascending.
