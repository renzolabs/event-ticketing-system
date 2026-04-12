# 🎟️ Event Ticketing System

[![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-4169E1?logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Redis](https://img.shields.io/badge/Redis-7-DC382D?logo=redis&logoColor=white)](https://redis.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

**Event Ticketing System - Spring Boot backend.**

## 🚀 Quick Start

```bash
# Clone and setup
git clone https://github.com/renzolabs/event-ticketing-system.git
cd event-ticketing-system

# Install git hooks
bash scripts/install-git-hooks.sh

# Start infrastructure services
docker-compose -f docker/docker-compose.yml up -d

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

## 📋 Overview

The Event Ticketing System is a **Phase 1** backend built to support:
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

- **Backend**: Spring Boot 3.x (Java 21)
- **Database**: PostgreSQL 17
- **Cache**: Redis 7+
- **Authentication**: JWT with Spring Security
- **Architecture**: Modular monolith (microservice-ready)
- **Containerization**: Docker & Docker Compose

## 📁 Project Structure

```
event-ticketing-system/
├── src/
│   ├── main/java/              # Application code
│   └── test/java/              # Test code
├── config/
│   ├── checkstyle.xml          # Checkstyle rules
│   └── sonar-project.properties # SonarQube config
├── docker/
│   └── docker-compose.yml      # PostgreSQL + Redis
├── scripts/
│   ├── format-java.sh          # Format all Java files
│   └── install-git-hooks.sh    # Setup git hooks
├── tools/                      # CLI tools (google-java-format)
└── pom.xml                     # Maven configuration
```

## 📋 Prerequisites

- Java 21+
- Maven 3.8+
- Docker & Docker Compose

## 🔧 Code Quality

### Git Workflow

See [Git Workflow Guide](docs/workflows/git-workflow.md) for detailed branching and merging strategy.

### Git Hooks

Install hooks for automatic code quality checks:

```bash
bash scripts/install-git-hooks.sh
```

Hooks installed:
- **pre-commit**: Validates filenames, formats Java, compiles code
- **commit-msg**: Enforces conventional commits (`feat:`, `fix:`, etc.)

### Manual Formatting

```bash
# Format all Java files
bash scripts/format-java.sh
```

### Checkstyle

Basic rules configured in `config/checkstyle.xml`:
- Max line length: 120
- No star imports
- No unused imports

### SonarQube

Configuration in `config/sonar-project.properties`. Run analysis:

```bash
sonar-scanner -Dproject.settings=config/sonar-project.properties
```

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
./mvnw test

# Run with coverage report
./mvnw jacoco:report
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
# Start infrastructure services
docker-compose -f docker/docker-compose.yml up -d

# View logs
docker-compose -f docker/docker-compose.yml logs -f
```

## 🤝 Contributing

1. Fork the repository
2. Install git hooks: `bash scripts/install-git-hooks.sh`
3. Create a feature branch: `git checkout -b feat/your-feature`
4. Make changes (hooks auto-format and validate)
5. Push (hooks run tests)
6. Submit a pull request

## � License

MIT License - see [LICENSE](LICENSE)

---

**Built by RenzoLabs**
