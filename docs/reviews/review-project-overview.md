# Event Ticketing System - Project Overview

## Architecture

This is a **modular monolith** Spring Boot application for event ticketing with strict module boundaries and clean architecture principles.

### Technology Stack
- **Backend**: Spring Boot 3.x (Java 21)
- **Database**: PostgreSQL with Flyway migrations
- **Authentication**: JWT via HTTP-only cookies
- **Security**: Spring Security
- **Build**: Maven
- **Containerization**: Docker Compose

### Module Structure

```
com.renzo.labs.ticketing/
auth/                    # Authentication & Authorization
  domain/               # User entity, Role enum
  application/          # AuthService interface & implementation
  infrastructure/       # UserRepository, JwtProvider, CookieUtil, Security Filter
  api/                  # AuthController, DTOs

user/                    # User Management
  domain/               # (Uses auth.domain.User)
  application/          # UserService interface & implementation
  infrastructure/       # (Uses auth.infrastructure.UserRepository)
  api/                  # UserController

event/                   # Event Management
  domain/               # Event entity with availability logic
  application/          # EventService interface & implementation
  infrastructure/       # EventRepository
  api/                  # EventController, DTOs

booking/                 # Booking Management
  domain/               # Booking entity, BookingStatus enum
  application/          # BookingService, BookingFacade
  infrastructure/       # BookingRepository
  api/                  # BookingController, DTOs

payment/                 # Payment Processing
  domain/               # Payment entity, PaymentStatus enum
  application/          # PaymentService interface & implementation
  infrastructure/       # PaymentRepository
  api/                  # PaymentController, DTOs
```

## Key Features

### Authentication System
- Cookie-based JWT authentication
- HTTP-only cookies for security
- Stateless authentication
- Automatic token refresh

### Business Logic
- Event creation with ticket availability tracking
- Booking system with automatic ticket reduction
- Payment processing with status tracking
- Module communication via service interfaces

### Database Schema
- Users table with role-based access
- Events with total/available ticket tracking
- Bookings linking users to events
- Payments linked to bookings

## API Endpoints

### Authentication
- `POST /auth/register` - User registration
- `POST /auth/login` - User login (sets cookie)
- `POST /auth/logout` - User logout (clears cookie)

### Users
- `GET /users/me` - Get current user profile
- `GET /users/{id}` - Get user by ID

### Events
- `POST /events` - Create event (auth required)
- `GET /events` - List all events (public)
- `GET /events/{id}` - Get event details (public)

### Bookings
- `POST /bookings` - Create booking (auth required)
- `GET /bookings/user/{userId}` - Get user bookings

### Payments
- `POST /payments` - Create payment
- `PATCH /payments/{id}/status` - Update payment status

## Module Integration

### Booking Flow
```
BookingFacade.createBookingWithPayment()
  -> EventService.checkAvailability()
  -> Event.reduceAvailableTickets()
  -> BookingService.create()
  -> PaymentService.create()
  -> PaymentService.updateStatus()
```

### Strict Module Boundaries
- No cross-module repository access
- Communication only via service interfaces
- Each module is independently testable
- Clear separation of concerns

## Development Setup

### Prerequisites
- Java 21+
- Maven 3.6+
- Docker & Docker Compose
- PostgreSQL (via Docker)

### Quick Start
```bash
# Start database
docker-compose up -d postgres

# Run application
./mvnw spring-boot:run

# Test APIs
.http/test-with-httpie.bat  # Windows
bash .http/test-with-httpie.sh  # Linux/Mac
```

### Configuration
- Database: `application.yml`
- JWT settings: `application.yml`
- Flyway migrations: `src/main/resources/db/migration/`

## Testing

### HTTP Files
All API tests are available in the `.http/` folder:
- `auth.http` - Authentication endpoints
- `events.http` - Event management
- `bookings.http` - Booking operations
- `payments.http` - Payment processing
- `end-to-end.http` - Complete workflow

### HTTPie Integration
```bash
# Install HTTPie
pip install httpie

# Run automated tests
.http/test-with-httpie.sh
```

## Security Considerations

- JWT tokens stored in HTTP-only cookies
- Secure cookie settings (SameSite=Strict)
- Password encryption with BCrypt
- Role-based access control
- Input validation and sanitization

## Future Enhancements

### Not in MVP
- Redis for session management/caching
- External payment gateway integration
- Email notifications
- Real-time updates (WebSockets)
- Microservices migration
- Advanced analytics

### Production Considerations
- Connection pooling
- Caching strategies
- Rate limiting
- Monitoring and logging
- Backup strategies
- Load balancing

## Architecture Decisions

### Modular Monolith Benefits
- Simplified deployment
- Shared database transactions
- Easier debugging
- Lower operational complexity
- Clear module boundaries for future microservices split

### Cookie-based Authentication
- Better security than localStorage
- Automatic CSRF protection
- Simplified client-side handling
- Mobile app compatibility

### Clean Architecture
- Domain logic isolated from framework
- Testable business rules
- Clear dependency direction
- Interface-based module communication
