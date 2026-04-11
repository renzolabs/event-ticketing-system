# 🧩 Epic: Event Ticket Booking Core

## 🎯 Goal

Allow users to browse events, select tickets, and complete a booking flow through a REST-based backend.

---

## 📄 Description

This epic delivers the core functionality required for users to discover events and book tickets. It includes event listing, event details, ticket selection, and booking creation.

The system is designed in a modular way so additional features (payment, notifications, analytics) can be plugged in later without changing the core booking flow.

---

## ✅ Success Criteria

* Users can view a list of available events
* Users can view detailed information about an event
* Users can select ticket quantity for an event
* Users can create a booking successfully
* System prevents overbooking through validation
* Bookings maintain data integrity with transactional handling

---

## 📦 Scope (Stories inside this Epic)

### 1. Event Listing

* As a user, I want to view available events so that I can choose one to attend

### 2. Event Details

* As a user, I want to see event details so that I can decide whether to book

### 3. Ticket Tier Setup

* As a system, I want to manage ticket tiers with pricing and inventory so that users have options

### 4. Booking Creation

* As a user, I want to create a booking for selected tickets so that I can reserve my spot

### 5. Booking Validation

* As a system, I want to validate ticket availability before confirming a booking so that inventory stays accurate

### 6. Booking Management

* As a user, I want to view and cancel my bookings so that I can manage my reservations

### 7. Overbooking Protection

* As a system, I want to prevent concurrent bookings from overselling so that inventory remains consistent

### 8. Availability Checking

* As a user, I want to check ticket availability in real-time so that I know what's in stock

---

## 🔧 Technical Notes

* REST API only (frontend handled separately with React)
* Modular structure:
  * `event-module` - event listing and details
  * `booking-module` - ticket selection, booking creation, availability validation
* Use **pessimistic locking** for inventory management to prevent race conditions
* All booking operations wrapped in **@Transactional**
* Prepare extension point for payment module integration
* Event listing supports filtering by date range, category, and status
* Soft delete for events via status (ARCHIVED instead of hard delete)

---

## 🚧 Out of Scope

* Payment processing
* Notifications (email/SMS)
* Advanced seat mapping with visual UI
* Promotions/discounts system
* Event creation/management by organizers

---

## 📊 Priority

High (core business functionality)

---

## 🧠 Why this is a good Epic

* Clear business goal - users can discover and book events
* Not too big, not too vague
* Easily breakable into 8 focused stories
* Directly implementable with clear technical boundaries

---

## 📋 Story Links

1. [Story 5.1: Create Event Entity and Repository](../stories/story-05-01-event-entity.md)
2. [Story 5.2: Create Event Listing API](../stories/story-05-02-event-listing.md)
3. [Story 5.3: Create Event Details API](../stories/story-05-03-event-details.md)
4. [Story 5.4: Create Ticket Tier Entity](../stories/story-05-04-ticket-tier.md)
5. [Story 5.5: Create Booking Entity and Repository](../stories/story-05-05-booking-entity.md)
6. [Story 5.6: Implement Booking Creation Service](../stories/story-05-06-booking-service.md)
7. [Story 5.7: Create Booking API Endpoints](../stories/story-05-07-booking-api.md)
8. [Story 5.8: Implement Overbooking Protection](../stories/story-05-08-overbooking-protection.md)

---

## 🔗 Dependencies

* Epic 1: Project Setup (infrastructure ready)
* Epic 2: Shared Infrastructure (exception handling, DTOs)
* Epic 3: User Module Foundation (User entity and service)
* Epic 4: Authentication Module (protected endpoints)

---

## 🗓️ Timeline

**Days 7-12** (Event module: Days 7-9, Booking module: Days 10-12)
