# Story 5.8: Implement Overbooking Protection

## Epic
[Epic 5: Event Ticket Booking Core](../epics/epic-05-event-ticketing-core.md)

## Story
**As a** system  
**I want to** prevent selling more tickets than available  
**So that** inventory remains accurate and customers aren't disappointed

## Acceptance Criteria
- [ ] Pessimistic locking on ticket tier rows during booking
- [ ] `@Lock(LockModeType.PESSIMISTIC_WRITE)` on repository query
- [ ] Optimistic locking fallback: version field on TicketTier
- [ ] `InsufficientInventoryException` for unavailable tickets
- [ ] Exception handler returns 409 CONFLICT with clear message
- [ ] Concurrent booking test: simulate 10 simultaneous requests for last ticket
- [ ] Only 1 succeeds, others get 409 error
- [ ] Database constraints: `availableQuantity >= 0`

## Tasks
1. Add `@Version` field to TicketTier (optimistic locking)
2. Create `@Lock` query method in TicketTierRepository
3. Create `InsufficientInventoryException`
4. Update `GlobalExceptionHandler` with 409 handler
5. Update `BookingService` to use locking
6. Write concurrent booking integration test
7. Add DB constraint: `CHECK (available_quantity >= 0)`
8. Verify race condition handling

## Estimated Effort
3 hours

## Priority
Must Have

## Notes
This is critical for business integrity. Use pessimistic locking for simplicity (acceptable for this scale). The concurrent test proves the system works under race conditions.
