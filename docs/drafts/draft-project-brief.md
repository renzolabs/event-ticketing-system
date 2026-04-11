# 📘 2. Project Brief (Business + Team Alignment)

---

## 🎯 Project Name
**Event Ticketing Platform (Core Backend)**

---

## 🧩 Objective

Build a scalable backend system to support:
- Event creation & management
- Ticket booking
- User authentication
- Future payment integration

This is **Phase 1 (Core System Only)** to validate product and support MVP launch.

---

## 👥 Target Users

- Customers (buy tickets)
- Event organizers
- Admin team

---

## ⚙️ Core Features (MVP Scope)

### 1. Authentication
- User registration/login
- JWT-based authentication

### 2. Event Management
- Create/update/delete events
- Event listing
- Event details

### 3. Booking System
- Book tickets
- Track bookings per user

### 4. Admin Controls
- Manage events
- View bookings

---

## 🚫 Out of Scope (Phase 1)

- Payment gateway
- Seat selection (simple booking only)
- Notification system
- Analytics dashboard

---

## 🏗 Technical Approach

### Backend
- Spring Boot (Java)
- REST API architecture
- Modular monolith (microservice-ready)

### Frontend
- Next.js (separate project)

### Infrastructure
- Dockerized services
- PostgreSQL database
- Redis for caching

---

## 📅 Estimated Timeline

| Phase | Duration |
|------|--------|
| Setup & Architecture | 2–3 days |
| Auth Module | 3–4 days |
| Event Module | 4–5 days |
| Booking Module | 4–5 days |
| Testing & Stabilization | 3–4 days |

👉 **Total: ~2–3 weeks (1 developer)**

---

## ⚠️ Risks

- Over-engineering too early
- Payment complexity later
- Scaling without caching strategy

---

## 📈 Scalability Plan

Future upgrades:
- Split into microservices
- Introduce message queues (Kafka)
- Add API Gateway
- Deploy on Kubernetes

---

## 🧠 Strategic Recommendation

- Start with **Java (Spring Boot)** for stability
- Keep architecture modular
- Add Redis early
- Avoid Golang unless high concurrency needed later

---

## 📌 Success Criteria

- Users can register and login
- Events can be created and listed
- Tickets can be booked successfully
- System handles concurrent users (basic level)

---
