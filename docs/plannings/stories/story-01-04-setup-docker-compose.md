# Story 1.4: Setup Docker Compose Environment

## Epic
[Epic 1: Project Setup](../epics/epic-01-project-setup.md)

## Story
**As a** developer  
**I want to** setup Docker Compose for local development  
**So that** all developers have consistent database environment

## Acceptance Criteria
- [ ] `docker-compose.yml` exists at project root
- [ ] PostgreSQL 17 service configured with:
  - Container name: `ticketing-postgres`
  - Port mapping: `5432:5432`
  - Database name: `ticketing`
  - Username: `postgres`
  - Password: `postgres`
- [ ] Persistent volume for database data
- [ ] Health check configured for PostgreSQL
- [ ] Service starts successfully with `docker-compose up -d`
- [ ] Application can connect to Dockerized PostgreSQL

## Tasks
1. Review existing `docker-compose.yml`
2. Update PostgreSQL version to 17 if needed
3. Configure proper environment variables
4. Add volume for data persistence
5. Add health check configuration
6. Test startup and connectivity
7. Document usage in README

## Estimated Effort
1 hour

## Priority
Must Have

## Notes
Docker Compose already exists. Verify it matches requirements and PostgreSQL 17 is specified.

Required `docker-compose.yml` structure:
```yaml
version: '3.8'
services:
  postgres:
    image: postgres:17-alpine
    container_name: ticketing-postgres
    environment:
      POSTGRES_DB: ticketing
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U postgres"]
      interval: 5s
      timeout: 5s
      retries: 5

volumes:
  postgres_data:
```
