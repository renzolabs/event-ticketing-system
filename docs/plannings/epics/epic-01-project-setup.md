# 🧩 Epic: Project Setup

## 🎯 Goal

Establish the foundational infrastructure for the Event Ticketing System including project structure, database configuration, and Docker environment.

---

## 📄 Description

This epic sets up the complete development environment and project structure. It ensures the Spring Boot project is properly initialized, database connectivity is established, and the modular architecture is ready for feature development.

The setup follows clean architecture principles with clear module boundaries.

---

## ✅ Success Criteria

* Project builds successfully with Maven
* Docker Compose starts PostgreSQL container
* Application connects to database
* Flyway migration structure is ready
* Module package boundaries are established
* Integration tests verify the foundation

---

## 📦 Scope (Stories inside this Epic)

### 1. Verify Project Structure

* As a developer, I want to verify the Spring Boot project is correctly set up so that I can start building features

### 2. Setup Modular Packages

* As a developer, I want a modular package structure so that the codebase remains organized and maintainable

### 3. Configure PostgreSQL

* As a developer, I want PostgreSQL configured so that the application has persistent data storage

### 4. Setup Docker Compose

* As a developer, I want Docker Compose for local development so that the database is easy to start and manage

### 5. Configure Application Profiles

* As a developer, I want environment-specific configuration so that the app runs correctly in dev, test, and production

### 6. Integration Testing

* As a developer, I want end-to-end integration tests so that I can verify the complete foundation works

---

## 🔧 Technical Notes

* **Modular monolith pattern** with strict package boundaries
* Each module must have: `domain/`, `application/`, `infrastructure/`, `api/`
* No cross-module repository access allowed
* Use interface-based communication between modules
* **UUID** as primary key type for all entities
* **PostgreSQL 17** as database
* **Flyway** for database migrations

---

## 🚧 Out of Scope

* Production deployment configuration
* CI/CD pipeline setup
* Load balancing or clustering
* Monitoring and observability tools

---

## 📊 Priority

Critical (blocks all other development)

---

## 🧠 Why this is a good Epic

* Clear, tangible deliverables
* Foundation for everything else
* Measurable success criteria
* Self-contained and complete

---

## 📋 Story Links

1. [Story 1.1: Verify Spring Boot Project Structure](../stories/story-01-01-verify-project-structure.md)
2. [Story 1.2: Setup Modular Package Structure](../stories/story-01-02-setup-package-structure.md)
3. [Story 1.3: Configure PostgreSQL Database](../stories/story-01-03-configure-postgresql.md)
4. [Story 1.4: Setup Docker Compose Environment](../stories/story-01-04-setup-docker-compose.md)
5. [Story 1.5: Configure Application YAML](../stories/story-01-05-configure-application-yml.md)
6. [Story 1.6: End-to-End Integration Testing](../stories/story-01-06-integration-testing.md)

---

## 🔗 Dependencies

None - This is the foundational epic.

---

## 🗓️ Timeline

**Day 1** (6 hours)
