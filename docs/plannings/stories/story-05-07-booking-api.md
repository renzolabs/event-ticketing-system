# Story 5.7: Create Booking API Endpoints

## Epic
[Epic 5: Event Ticket Booking Core](../epics/epic-05-event-ticketing-core.md)

## Story
**As a** user  
**I want to** create and manage bookings via API  
**So that** I can complete the ticket purchase flow

## Acceptance Criteria
- [ ] `BookingController` in `booking/api/controller/`
- [ ] Endpoints:
  - `POST /api/bookings` - Create booking (authenticated)
  - `GET /api/bookings` - List my bookings (authenticated, paginated)
  - `GET /api/bookings/{id}` - Get booking details (authenticated, must be owner)
  - `DELETE /api/bookings/{id}` - Cancel booking (authenticated, PENDING only)
- [ ] `GET /api/events/{id}/availability` - Check ticket availability (public)
- [ ] Request validation on `CreateBookingRequest`
- [ ] Proper security: users can only access their own bookings
- [ ] Consistent response format via ApiResponse wrapper

## Tasks
1. Create `BookingController`
2. Implement POST /api/bookings
3. Implement GET /api/bookings (with pagination)
4. Implement GET /api/bookings/{id}
5. Implement DELETE /api/bookings/{id}
6. Add EventController endpoint for availability
7. Add authentication requirements
8. Write integration tests

## Estimated Effort
2.5 hours

## Priority
Must Have

## Notes
The availability endpoint helps users check stock before attempting to book. Cancellation only allowed for PENDING bookings (before payment). CONFIRMED bookings require refund flow (future).
