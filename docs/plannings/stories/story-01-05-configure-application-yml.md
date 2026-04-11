# Story 1.5: Configure Application YAML Profiles

## Epic
[Epic 1: Project Setup](../epics/epic-01-project-setup.md)

## Story
**As a** developer  
**I want to** setup environment-specific configurations  
**So that** the app works correctly in different environments (dev, test, prod)

## Acceptance Criteria
- [ ] Main `application.yml` with common settings
- [ ] `application-dev.yml` for local development:
  - Debug logging enabled
  - SQL logging enabled
  - Show SQL: true
- [ ] `application-test.yml` for testing:
  - H2 database configuration (optional)
  - Or TestContainers setup
- [ ] Profile-specific logging levels configured
- [ ] Server port configuration (default 8080)
- [ ] Jackson serialization settings (dates as ISO-8601)

## Tasks
1. Create `application.yml` with shared configuration
2. Create `application-dev.yml` with dev-specific settings
3. Configure logging levels per profile
4. Configure Jackson date format
5. Add server configuration
6. Document profile usage

## Estimated Effort
1.5 hours

## Priority
Should Have

## Notes
Keep sensitive values (passwords, secrets) out of committed files. Use environment variables or externalized config for production.

Configuration structure:
```yaml
# application.yml (common)
spring:
  application:
    name: event-ticketing-system
  jackson:
    serialization:
      write-dates-as-timestamps: false
    date-format: yyyy-MM-dd'T'HH:mm:ss'Z'

server:
  port: 8080
  servlet:
    context-path: /api

logging:
  level:
    root: INFO
```

```yaml
# application-dev.yml
spring:
  jpa:
    show-sql: true
  flyway:
    clean-on-validation-error: true

logging:
  level:
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql: TRACE
```
