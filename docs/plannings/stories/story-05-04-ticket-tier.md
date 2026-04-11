# Story 5.4: Create Ticket Tier Entity

## Epic
[Epic 5: Event Ticket Booking Core](../epics/epic-05-event-ticketing-core.md)

## Story
**As a** developer  
**I want to** define ticket tiers for events  
**So that** events can have multiple pricing levels with inventory

## Acceptance Criteria
- [ ] `TicketTier` entity in `event/domain/entity/`
- [ ] Fields:
  - `id`: UUID (PK)
  - `eventId`: UUID (FK to Event)
  - `name`: String (required, max 100) - e.g., "VIP", "General Admission"
  - `description`: String (max 255)
  - `price`: BigDecimal (required, precision 10, scale 2)
  - `currency`: String (default: "USD", max 3)
  - `totalQuantity`: Integer (required, > 0)
  - `availableQuantity`: Integer (required, >= 0)
  - `createdAt`, `updatedAt`: Instant
- [ ] `TicketTierRepository` in `event/domain/repository/`
- [ ] Repository methods:
  - `findByEventId(eventId)`
  - `findByEventIdAndAvailableQuantityGreaterThan(eventId, 0)`
- [ ] Flyway migration: `V5.4__create_ticket_tiers_table.sql`

## Tasks
1. Create `TicketTier` entity
2. Create `TicketTierRepository`
3. Write migration
4. Add relation to Event (optional eager fetch)
5. Write unit tests

## Estimated Effort
1.5 hours

## Priority
Must Have

## Notes
Ticket tiers belong to the event-module since they describe event pricing. The `availableQuantity` field is critical for overbooking prevention and will be updated atomically during booking.
