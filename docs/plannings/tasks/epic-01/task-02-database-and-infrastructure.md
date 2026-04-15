# Task 2: Database and Infrastructure Setup

## Parent Epic
[Epic 1: Project Setup](../../epics/epic-01-project-setup.md)

## Overview
Configure PostgreSQL database connection, Docker Compose environment, and application profiles for all environments.

## Combined Stories
- Story 1.3: Configure PostgreSQL Database
- Story 1.4: Setup Docker Compose Environment
- Story 1.5: Configure Application YAML Profiles

## Acceptance Criteria

### Database Configuration
- [ ] `application.yml` configured with PostgreSQL datasource
- [ ] Database URL: `jdbc:postgresql://localhost:5432/ticketing`
- [ ] Username and password configured (postgres/postgres for local)
- [ ] JPA/Hibernate properties configured:
  - [ ] `ddl-auto: validate` (Flyway manages schema)
  - [ ] Show SQL: false (true for dev)
  - [ ] Format SQL: true
  - [ ] Dialect: PostgreSQLDialect
- [ ] Connection pool settings configured
- [ ] Flyway enabled with migration location

### Docker Compose
- [ ] `docker-compose.yml` exists at project root
- [ ] PostgreSQL 17 service configured with:
  - [ ] Container name: `ticketing-postgres`
  - [ ] Port mapping: `5432:5432`
  - [ ] Database name: `ticketing`
  - [ ] Username: `postgres`
  - [ ] Password: `postgres`
- [ ] Persistent volume for database data
- [ ] Health check configured for PostgreSQL
- [ ] Service starts successfully with `docker-compose up -d`
- [ ] Application can connect to Dockerized PostgreSQL

### Application Profiles
- [ ] Main `application.yml` with common settings:
  - [ ] Application name
  - [ ] Jackson serialization (ISO-8601 dates)
  - [ ] Server port 8080 with context path /api
  - [ ] Logging levels
- [ ] `application-dev.yml` for local development:
  - [ ] Debug logging enabled
  - [ ] SQL logging enabled
  - [ ] Show SQL: true
  - [ ] Flyway clean-on-validation-error: true
- [ ] `application-test.yml` for testing (H2 or TestContainers)
- [ ] Profile-specific logging levels configured
- [ ] Sensitive values externalized (no passwords in committed files)

## Estimated Effort
4 hours

## Assignee
TBD

## Status
Done

## Dependencies
- Task 1 (Project Setup and Modular Structure) must be complete

## Notes
Test the full flow: Docker Compose up → App starts → Database connection works
