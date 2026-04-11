# Story 5.3: Create Event Details API

## Epic
[Epic 5: Event Ticket Booking Core](../epics/epic-05-event-ticketing-core.md)

## Story
**As a** user  
**I want to** see detailed information about an event  
**So that** I can decide whether to book it

## Acceptance Criteria
- [ ] Endpoint: `GET /api/events/{id}`
- [ ] Returns full event details
- [ ] Include ticket tier summary in response (min/max price, tiers available)
- [ ] `EventDetailResponse` DTO extends EventResponse with:
  - `description` (full text)
  - `ticketTiers`: list of basic tier info
- [ ] Returns 404 if event not found or not PUBLISHED
- [ ] Proper error handling with consistent error format

## Tasks
1. Create `EventDetailResponse` DTO
2. Add `getEventById()` method in EventService
3. Add endpoint in EventController
4. Handle NotFoundException
5. Write unit tests
6. Write integration tests

## Estimated Effort
1.5 hours

## Priority
Must Have

## Notes
This endpoint prepares the user for ticket selection. Include ticket tier summary so users know pricing before clicking into booking flow.
