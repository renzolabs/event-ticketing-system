# Story 1.3: Configure PostgreSQL Database

## Epic
[Epic 1: Project Setup](../epics/epic-01-project-setup.md)

## Story
**As a** developer  
**I want to** configure PostgreSQL database connection  
**So that** the application can persist data reliably

## Acceptance Criteria
- [ ] `application.yml` configured with PostgreSQL datasource
- [ ] Database URL: `jdbc:postgresql://localhost:5432/ticketing`
- [ ] Username and password configured (postgres/postgres for local)
- [ ] JPA/Hibernate properties configured:
  - `ddl-auto: validate` (Flyway manages schema)
  - Show SQL: false (true for dev)
  - Format SQL: true
  - Dialect: PostgreSQLDialect
- [ ] Connection pool settings (HikariCP defaults acceptable)
- [ ] Test connection works when app starts

## Tasks
1. Create `application.yml` in `src/main/resources`
2. Configure datasource properties
3. Configure JPA/Hibernate properties
4. Add logging configuration for SQL (dev only)
5. Create separate `application-dev.yml` profile
6. Test database connection on startup

## Estimated Effort
1 hour

## Priority
Must Have

## Notes
Use Flyway for schema management, not Hibernate auto-create. This ensures version-controlled migrations.

Sample configuration:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/ticketing
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  flyway:
    enabled: true
    locations: classpath:db/migration
```
