# 🏗️ Event Ticketing System – MVP Execution Document (Windsurf Ready)

---

# 📌 Objective

Build a **modular monolith REST backend** for an Event Ticketing System using Spring Boot with:

* Cookie-based authentication (JWT in HTTP-only cookies)
* Clean module boundaries
* MVP scope (production-expandable)

---

# 🧱 Architecture Summary

* Pattern: Modular Monolith
* Backend: Spring Boot 3.x (Java 21+)
* DB: PostgreSQL
* Auth: JWT via HTTP-only Cookie
* API: REST

---

# 📦 Module Scope (MVP)

## Required Modules

1. Auth Module (Cookie-based)
2. User Module
3. Event Module
4. Booking Module
5. Payment Module (Basic)

---

# 🧩 Module Boundaries (STRICT RULES)

* Each module has:

  * domain/
  * application/
  * infrastructure/
  * api/

* ❌ No cross-module repository access

* ✅ Only communicate via Service interfaces

---

# 🔐 AUTH MODULE (Cookie-Based)

## Features

* Register
* Login
* Logout
* JWT stored in HTTP-only cookie

---

## API

### POST /auth/register

```
{
  "email": "user@email.com",
  "password": "123456"
}
```

### POST /auth/login

→ Set cookie:

```
Set-Cookie: access_token=jwt; HttpOnly; Secure; SameSite=Strict; Path=/
```

### POST /auth/logout

→ Clear cookie

---

## Required Components

* AuthController
* AuthService
* JwtProvider
* CookieUtil
* JwtAuthenticationFilter

---

## Security Requirements

* Use Spring Security
* Stateless authentication
* Filter reads JWT from cookie
* Set SecurityContext

---

# 👤 USER MODULE

## Features

* Create user
* Get user by ID
* Get user by email

---

## Fields

* id
* email
* password
* role
* createdAt

---

## API

* GET /users/me

---

# 🎟️ EVENT MODULE

## Features

* Create event
* List events
* Get event details

---

## Fields

* id
* name
* description
* date
* totalTickets
* availableTickets

---

## API

* POST /events
* GET /events
* GET /events/{id}

---

## Logic

* isAvailable(eventId, quantity)

---

# 🧾 BOOKING MODULE

## Features

* Create booking
* Get user bookings

---

## Fields

* id
* userId
* eventId
* quantity
* status
* createdAt

---

## API

* POST /bookings
* GET /bookings/user/{userId}

---

## Flow

1. Check event availability
2. Create booking
3. Reduce available tickets
4. Create payment

---

## Notes

* No concurrency handling (MVP)
* Oversell possible (acceptable)

---

# 💳 PAYMENT MODULE (BASIC)

## Features

* Create payment
* Update payment status

---

## Fields

* id
* bookingId
* amount
* status (PENDING, SUCCESS, FAILED)

---

## API

* POST /payments
* PATCH /payments/{id}/status

---

---

# 🔗 MODULE INTEGRATION FLOW

### Booking Flow

```
BookingFacade
  → EventService.checkAvailability()
  → BookingService.create()
  → PaymentService.create()
```

---

# 🧪 NON-FUNCTIONAL (MVP)

* Basic logging
* Global exception handler
* DTO validation (optional basic)

---

# ⚙️ INFRASTRUCTURE

## Docker Compose

* PostgreSQL 17

## application.yml

```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/ticketing
    username: postgres
    password: postgres
```

---

# 🗂️ PROJECT STRUCTURE

```
com.renzo.labs.ticketing/

shared/

auth/
user/
event/
booking/
payment/
```

---

# 🧵 EXECUTION PLAN (EPICS & STORIES)

---

## 🟦 EPIC 1: Project Setup

### Stories

* Initialize Spring Boot project
* Setup package structure
* Configure PostgreSQL
* Setup Docker Compose
* Setup global exception handler

---

## 🟦 EPIC 2: User Module

### Stories

* Create User entity
* Implement UserRepository
* Implement UserService
* Create GET /users API

---

## 🟦 EPIC 3: Auth Module (Cookie-Based)

### Stories

* Implement JwtProvider
* Implement AuthService (login/register)
* Implement CookieUtil
* Implement AuthController
* Implement JwtAuthenticationFilter
* Configure Spring Security

---

## 🟦 EPIC 4: Event Module

### Stories

* Create Event entity
* Implement EventRepository
* Implement EventService
* Implement EventController

---

## 🟦 EPIC 5: Booking Module

### Stories

* Create Booking entity
* Implement BookingRepository
* Implement BookingService
* Implement BookingFacade
* Implement BookingController

---

## 🟦 EPIC 6: Payment Module

### Stories

* Create Payment entity
* Implement PaymentRepository
* Implement PaymentService
* Implement PaymentController

---

## 🟦 EPIC 7: Integration

### Stories

* Connect Booking → Event
* Connect Booking → Payment
* Test full flow

---

## 🟦 EPIC 8: Hardening

### Stories

* Add validation
* Improve error handling
* Add logging

---

# ⏱️ TIMELINE

| Phase       | Duration |
| ----------- | -------- |
| Setup       | 2–3 days |
| Auth + User | 4–5 days |
| Event       | 3–4 days |
| Booking     | 5–6 days |
| Payment     | 2–3 days |
| Integration | 2–3 days |

---

# 🚀 FINAL OUTPUT

System must support:

* User registration & login (cookie-based auth)
* Event creation & listing
* Ticket booking
* Payment tracking

---

# ⚠️ CONSTRAINTS

* No Redis
* No message queue
* No concurrency protection
* No external payment gateway

---

# 📌 SUCCESS CRITERIA

* All APIs functional
* Auth works via cookie
* End-to-end flow works:
  Register → Login → Create Event → Book → Payment

---

# 🔥 FUTURE EXTENSIONS (NOT IN MVP)

* Seat locking (Redis)
* Payment gateway integration
* Notification system
* Analytics dashboard
* Microservices migration

---

# 🧠 INSTRUCTION FOR WINDSURF

* Generate full Spring Boot project
* Follow module boundaries strictly
* Use interface-based communication between modules
* Do NOT merge modules
* Use clean, production-style code
* Keep implementation minimal (MVP only)

---

**END OF DOCUMENT**
