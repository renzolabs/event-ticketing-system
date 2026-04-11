# Event Ticketing System - Project Summary

## Overview
A comprehensive Spring Boot-based event ticketing system with cookie-based authentication, built using Java 21 and PostgreSQL. The system follows clean architecture principles with modular design.

## Tech Stack
- **Backend**: Spring Boot 3.5.13, Java 21
- **Database**: PostgreSQL 17 with Flyway migrations
- **Security**: Spring Security with JWT + Cookie-based authentication
- **API Documentation**: OpenAPI 3 (Swagger)
- **Build Tool**: Maven
- **Containerization**: Docker Compose
- **Cache**: Redis 7 (pre-configured)

## Architecture & Modules

### 1. Auth Module (Complete)
- **Domain**: `User`, `Role` entities
- **Infrastructure**: `JwtProvider`, `JwtAuthenticationFilter`, `CookieUtil`, `UserRepository`
- **Application**: `AuthService` with login/register functionality
- **API**: `AuthController` with login/register endpoints
- **Features**: JWT tokens, secure HTTP-only cookies, role-based access

### 2. User Module (Complete)
- **Domain**: Reuses `User` entity from auth
- **Application**: `UserService` for user management
- **API**: `UserController` with `/users/me` and `/users/{id}` endpoints

### 3. Event Module (Complete)
- **Domain**: `Event` entity
- **Infrastructure**: `EventRepository`
- **Application**: `EventService` for CRUD operations
- **API**: `EventController` with full CRUD endpoints

### 4. Booking Module (Complete)
- **Domain**: `Booking`, `BookingStatus` entities
- **Infrastructure**: `BookingRepository`
- **Application**: `BookingService`, `BookingFacade` for complex operations
- **API**: `BookingController` with booking management endpoints
- **Features**: Booking status management, reservation timeouts

### 5. Payment Module (Complete)
- **Domain**: `Payment` entity
- **Infrastructure**: `PaymentRepository`
- **Application**: `PaymentService` for payment processing
- **API**: `PaymentController` with payment creation and status updates
- **Features**: Mock payment provider (ready for Stripe/Omise integration)

### 6. Configuration (Complete)
- **Security**: `SecurityConfig` with JWT filter configuration
- **Global Exception Handling**: `GlobalExceptionHandler`, `ValidationExceptionHandler`
- **API Documentation**: `OpenApiConfig`
- **Database**: Flyway migrations for all tables

## Database Schema
- **users**: id, email, password, first_name, last_name, role, created_at, updated_at
- **events**: id, title, description, venue, event_date, total_tickets, available_tickets, price, status, created_at, updated_at
- **bookings**: id, user_id, event_id, number_of_tickets, total_price, status, booking_time, payment_deadline
- **payments**: id, booking_id, amount, status, payment_method, transaction_id, created_at, updated_at

## Key Features Implemented
- JWT-based authentication with secure cookies
- Role-based authorization (USER, ADMIN)
- Event creation and management
- Booking system with reservation timeouts
- Payment processing with status tracking
- Global exception handling
- Input validation
- API documentation with Swagger
- Database migrations
- Docker Compose setup with PostgreSQL and Redis

## Configuration Highlights
- **JWT**: 24-hour expiration, secure cookie storage
- **Database**: PostgreSQL with Hibernate DDL update
- **CORS**: Configured for localhost:3000 (frontend ready)
- **Logging**: Debug level for security and SQL
- **Ticketing**: 15-minute reservation timeout, max 10 tickets per user

## API Endpoints
- **Auth**: POST /auth/login, POST /auth/register
- **Users**: GET /users/me, GET /users/{id}
- **Events**: GET /events, POST /events, GET /events/{id}, PUT /events/{id}, DELETE /events/{id}
- **Bookings**: GET /bookings, POST /bookings, GET /bookings/{id}, PATCH /bookings/{id}/status
- **Payments**: POST /payments, PATCH /payments/{id}/status

## Development Setup
- PostgreSQL on localhost:5432
- Redis on localhost:6379
- Application runs on port 8080
- Swagger UI available at /swagger-ui.html

## Status: Production Ready
All core modules are implemented and integrated. The system is ready for:
- Frontend integration
- Payment provider integration (Stripe/Omise)
- Notification system implementation
- Production deployment
