# 🏗️ System Design

## Overview
Event Ticketing Platform built with modular monolith architecture, designed for scalability and future microservice migration.

## Architecture Pattern
**Modular Monolith** - Single deployment with clear module boundaries for future microservice extraction.

## Technology Stack

### Backend
- **Framework**: Spring Boot 3.x
- **Language**: Java 21+
- **Architecture**: REST API with layered design
- **Security**: Spring Security with JWT
- **Database**: PostgreSQL 15+
- **Cache**: Redis 7+
- **Containerization**: Docker & Docker Compose

### Infrastructure
- **Database**: PostgreSQL for persistent data
- **Caching**: Redis for session management and frequent queries
- **Message Queue**: Future - Kafka/RabbitMQ
- **API Gateway**: Future - Spring Cloud Gateway
- **Monitoring**: Future - Prometheus + Grafana

## Module Structure

```
com.renzo.labs.ticketing/
├── core/                    # Core domain entities
│   ├── user/
│   ├── event/
│   ├── booking/
│   └── payment/
├── application/             # Application services
│   ├── auth/
│   ├── event/
│   ├── booking/
│   └── admin/
├── infrastructure/          # External integrations
│   ├── persistence/
│   ├── cache/
│   └── security/
└── interfaces/              # API controllers
    ├── rest/
    └── dto/
```

## Data Flow

### User Registration/Login
1. Client → Auth Controller
2. Auth Service → User Repository
3. JWT Token Generation
4. Redis Session Storage

### Event Booking
1. Client → Booking Controller
2. Booking Service → Event Service (availability check)
3. Booking Service → Payment Service (future)
4. Booking Repository → PostgreSQL
5. Cache Update → Redis

## Database Design

### Core Tables
- **users**: User accounts and profiles
- **events**: Event information
- **bookings**: Booking records
- **tickets**: Individual ticket records
- **payments**: Payment transactions (future)

### Relationships
- Users → Events (organizer relationship)
- Users → Bookings (customer relationship)
- Events → Bookings (one-to-many)
- Bookings → Tickets (one-to-many)

## Caching Strategy

### Redis Usage
- **Session Management**: User sessions and JWT tokens
- **Event Data**: Frequently accessed event information
- **Booking Cache**: Recent booking data
- **Rate Limiting**: API request throttling

### Cache Keys
- `session:{userId}`: User session data
- `event:{eventId}`: Event details
- `booking:recent:{userId}`: Recent bookings
- `rate_limit:{ip}:{endpoint}`: Rate limiting

## Security Architecture

### Authentication
- JWT-based stateless authentication
- Token expiration: 1 hour
- Refresh token mechanism
- Password hashing with BCrypt

### Authorization
- Role-based access control (RBAC)
- USER, ADMIN roles
- Resource-level permissions
- Method-level security

### Security Headers
- CORS configuration
- CSRF protection
- Content Security Policy
- X-Frame-Options

## API Design Principles

### RESTful Conventions
- Resource-based URLs
- HTTP status codes
- Consistent response format
- Pagination for large datasets

### Response Format
```json
{
  "data": {},
  "message": "Success",
  "timestamp": "2024-01-01T00:00:00Z",
  "errors": []
}
```

## Error Handling

### Global Exception Handler
- Validation errors
- Business logic exceptions
- Database errors
- External service failures

### Error Response Structure
```json
{
  "error": "Error type",
  "message": "Human readable message",
  "details": ["Specific error details"],
  "timestamp": "2024-01-01T00:00:00Z"
}
```

## Performance Considerations

### Database Optimization
- Indexing strategy
- Query optimization
- Connection pooling
- Read replicas (future)

### Caching Layers
- Application-level caching
- Database query cache
- CDN for static assets (future)

### Scalability Plan
1. **Phase 1**: Modular monolith with Redis
2. **Phase 2**: Add message queues
3. **Phase 3**: Extract microservices
4. **Phase 4**: Kubernetes deployment

## Monitoring & Logging

### Application Logging
- Structured logging with JSON format
- Log levels: DEBUG, INFO, WARN, ERROR
- Request/response logging
- Error tracking

### Metrics (Future)
- Application performance metrics
- Database performance
- Cache hit ratios
- API response times

## Development Environment

### Local Setup
- Docker Compose for local services
- H2 database for testing
- Embedded Redis for development
- Hot reload with Spring DevTools

### Testing Strategy
- Unit tests with JUnit 5
- Integration tests with TestContainers
- API testing with MockMvc
- Performance testing (future)
