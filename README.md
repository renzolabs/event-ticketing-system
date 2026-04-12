![Event Ticketing System Banner](docs/assets/caveman-tries-ticketing-festival-banner.png)

# 🎟️ Event Ticketing Platform

[![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-4169E1?logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Redis](https://img.shields.io/badge/Redis-7-DC382D?logo=redis&logoColor=white)](https://redis.io/)
[![JWT](https://img.shields.io/badge/JWT-Auth-000000?logo=jsonwebtokens&logoColor=white)](https://jwt.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

**A scalable backend system for event creation, ticket booking, and user authentication.**

## 🚀 Quick Start

```bash
# Clone the repository
git clone https://github.com/renzolabs/event-ticketing-system.git
cd event-ticketing-system

# Start infrastructure services
docker-compose up -d postgres redis

# Run the application
mvn spring-boot:run

# Access the API
curl http://localhost:8080/actuator/health
```

## 📋 Overview

The Event Ticketing Platform is a **Phase 1 (Core System Only)** backend built to support:
- Event creation & management
- Ticket booking system
- User authentication
- Admin controls
- Future payment integration

## ✨ Core Features

### Authentication
- User registration and login
- JWT-based authentication
- Role-based access control (USER, ADMIN)

### Event Management
- Create, update, and delete events
- Event listing with search and filtering
- Event categories and status management

### Booking System
- Book tickets for events
- Track bookings per user
- QR code ticket generation
- Booking cancellation and refunds

### Admin Controls
- Manage users and events
- View system statistics
- Export data and reports

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.x (Java 17+)
- **Database**: PostgreSQL 17
- **Cache**: Redis 7+
- **Authentication**: JWT with Spring Security
- **Architecture**: Modular monolith (microservice-ready)
- **Containerization**: Docker & Docker Compose

## 📁 Project Structure

```
event-ticketing-system/
+-- src/main/java/com/renzo/labs/ticketing/
¦   +-- core/                    # Domain entities
¦   +-- application/             # Business logic
¦   +-- infrastructure/          # External integrations
¦   +-- interfaces/              # API controllers
+-- src/main/resources/
¦   +-- application.yaml         # Configuration
¦   +-- db/migration/           # Database migrations
+-- docs/
¦   +-- api/                    # API documentation
¦   +-- architecture/           # System design
¦   +-- development/            # Development guides
+-- docker-compose.yml          # Local development
+-- pom.xml                     # Maven configuration
```

## 📋 Prerequisites

- Java 21+
- Maven 3.8+
- Docker & Docker Compose
- PostgreSQL 15+ (or use Docker)
- Redis 7+ (or use Docker)

## 📚 Documentation

### API Documentation
- [Authentication API](docs/api/authentication.md)
- [Events API](docs/api/events.md)
- [Bookings API](docs/api/bookings.md)
- [Admin API](docs/api/admin.md)

### Architecture
- [System Design](docs/architecture/system-design.md)
- [Database Schema](docs/architecture/database-schema.md)

### Development
- [Development Setup](docs/development/setup.md)
- [Contributing Guidelines](docs/development/contributing.md)

## 🔌 API Endpoints

### Authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login
- `POST /api/auth/refresh` - Refresh JWT token

### Events
- `GET /api/events` - List all events
- `POST /api/events` - Create new event
- `GET /api/events/{id}` - Get event details
- `PUT /api/events/{id}` - Update event
- `DELETE /api/events/{id}` - Delete event

### Bookings
- `POST /api/bookings` - Create booking
- `GET /api/bookings/my-bookings` - Get user bookings
- `GET /api/bookings/{id}` - Get booking details
- `POST /api/bookings/{id}/cancel` - Cancel booking

### Admin
- `GET /api/admin/statistics` - System statistics
- `GET /api/admin/users` - Manage users
- `GET /api/admin/events` - Manage events
- `GET /api/admin/bookings` - View all bookings

## 🚀 Running the Application

### Development Mode
```bash
# Start with hot reload
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Production Mode
```bash
# Build JAR
mvn clean package

# Run JAR
java -jar target/event-ticketing-system-0.0.1-SNAPSHOT.jar
```

### Docker Mode
```bash
# Build image
docker build -t ticketing-system .

# Run container
docker run -p 8080:8080 ticketing-system
```

## 🧪 Testing

```bash
# Run all tests
mvn test

# Run with coverage
mvn jacoco:report

# Run integration tests
mvn test -Dtest=**/*IntegrationTest
```

## 📊 Monitoring

- **Health Check**: http://localhost:8080/actuator/health
- **Metrics**: http://localhost:8080/actuator/metrics
- **Info**: http://localhost:8080/actuator/info

## 🚢 Deployment

### Environment Variables
```bash
DATABASE_URL=jdbc:postgresql://localhost:5432/ticketing_db
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=password
REDIS_HOST=localhost
REDIS_PORT=6379
JWT_SECRET=your-secret-key-here
```

### Docker Compose
```bash
# Start all services
docker-compose up -d

# View logs
docker-compose logs -f
```

## 📈 Scalability Plan

Future upgrades include:
- Split into microservices
- Add message queues (Kafka)
- Implement API Gateway
- Deploy on Kubernetes
- Add caching layers
- Implement payment gateways

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests
5. Submit a pull request

See [Contributing Guidelines](docs/development/contributing.md) for details.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 💬 Support

For questions and support:
- Create an [Issue](https://github.com/your-repo/issues)
- Check [Documentation](docs/)
- Review [FAQ](docs/faq.md)

## 🗺️ Roadmap

### Phase 1 ✅ (Current)
- Core authentication system
- Event management
- Basic booking system
- Admin controls

### Phase 2 🔄
- Payment gateway integration
- Seat selection system
- Notification system
- Mobile app API

### Phase 3 🚀
- Analytics dashboard
- Advanced reporting
- Multi-tenant support
- Third-party integrations

---

**Built with ❤️ by RenzoLabs**
