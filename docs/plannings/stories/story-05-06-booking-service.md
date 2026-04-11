# Story 5.6: Implement Booking Creation Service

## Epic
[Epic 5: Event Ticket Booking Core](../epics/epic-05-event-ticketing-core.md)

## Story
**As a** developer  
**I want to** implement the core booking creation logic  
**So that** bookings are created safely with transactional integrity

## Acceptance Criteria
- [ ] `BookingService` in `booking/application/service/`
- [ ] Method: `createBooking(userId, eventId, List<TicketSelection>)`
- [ ] `TicketSelection` DTO: `ticketTierId`, `quantity`
- [ ] Validation:
  - Event exists and is PUBLISHED
  - All ticket tiers belong to the event
  - Requested quantity <= available for each tier
  - Total quantity > 0
- [ ] Transactional behavior:
  - Lock ticket tiers (pessimistic or optimistic)
  - Decrement availableQuantity
  - Create Booking (PENDING)
  - Create BookingItems
- [ ] Calculate totalAmount from tier prices
- [ ] Set expiresAt (e.g., now + 15 minutes)
- [ ] Return `BookingResponse` DTO

## Tasks
1. Create `CreateBookingRequest` DTO
2. Create `BookingResponse` DTO
3. Create `BookingMapper`
4. Implement `BookingService.createBooking()`
5. Implement availability validation
6. Add @Transactional with proper isolation
7. Write unit tests with mocked repository
8. Write integration tests with database

## Estimated Effort
3 hours

## Priority
Must Have

## Notes
This is the critical transaction. Use pessimistic locking (`@Lock(LockModeType.PESSIMISTIC_WRITE)`) on ticket tiers to prevent race conditions. All operations must succeed or rollback together.
