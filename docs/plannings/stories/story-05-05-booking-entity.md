# Story 5.5: Create Booking Entity and Repository

## Epic
[Epic 5: Event Ticket Booking Core](../epics/epic-05-event-ticketing-core.md)

## Story
**As a** developer  
**I want to** define the Booking entity  
**So that** user bookings can be stored and managed

## Acceptance Criteria
- [ ] `Booking` entity in `booking/domain/entity/`
- [ ] Fields:
  - `id`: UUID (PK)
  - `userId`: UUID (FK to User, required)
  - `eventId`: UUID (FK to Event, required)
  - `status`: Enum (PENDING, CONFIRMED, CANCELLED, EXPIRED)
  - `totalAmount`: BigDecimal (precision 10, scale 2)
  - `currency`: String (max 3)
  - `expiresAt`: Instant (for PENDING bookings)
  - `createdAt`, `updatedAt`, `confirmedAt`, `cancelledAt`: Instant
- [ ] `BookingItem` entity (line items):
  - `id`: UUID
  - `bookingId`: UUID (FK)
  - `ticketTierId`: UUID
  - `quantity`: Integer (> 0)
  - `unitPrice`: BigDecimal
- [ ] `BookingRepository` with methods:
  - `findByUserId(userId, pageable)`
  - `findByStatusAndExpiresAtBefore(status, time)` (for expiry job)
- [ ] Flyway migrations: `V5.5__create_bookings_table.sql`, `V5.5__create_booking_items_table.sql`

## Tasks
1. Create `BookingStatus` enum
2. Create `Booking` entity
3. Create `BookingItem` entity
4. Create `BookingRepository`
5. Write migrations
6. Write unit tests

## Estimated Effort
2 hours

## Priority
Must Have

## Notes
Bookings start in PENDING status. After payment (future), they become CONFIRMED. PENDING bookings expire after a set time (e.g., 15 minutes) if not paid.
