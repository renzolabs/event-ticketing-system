# Task 1: Project Setup and Modular Structure

## Parent Epic
[Epic 1: Project Setup](../../epics/epic-01-project-setup.md)

## Overview
Verify the Spring Boot project is properly configured and establish the modular package structure following clean architecture principles.

## Combined Stories
- Story 1.1: Verify Spring Boot Project Structure
- Story 1.2: Setup Modular Package Structure

## Acceptance Criteria

### Project Verification
- [ ] `pom.xml` has all required dependencies:
  - [ ] Spring Boot Web Starter
  - [ ] Spring Data JPA
  - [ ] Spring Security
  - [ ] PostgreSQL Driver
  - [ ] Flyway
  - [ ] Lombok
  - [ ] JJWT (api, impl, jackson)
  - [ ] Validation
  - [ ] OpenAPI/SpringDoc
- [ ] Java version is set to 21
- [ ] Maven wrapper exists and works (`mvnw --version`)
- [ ] Project builds without errors (`mvnw clean compile`)
- [ ] Main application class exists at `com.renzo.labs.ticketing.EventTicketingSystemApplication`

### Package Structure
- [ ] Base package `com.renzo.labs.ticketing` exists
- [ ] Module packages created:
  - [ ] `shared/` with domain/, application/, infrastructure/
  - [ ] `user/` with domain/, application/, infrastructure/, api/
  - [ ] `auth/` with domain/, application/, infrastructure/, api/
  - [ ] `event/` with domain/, application/, infrastructure/, api/
  - [ ] `booking/` with domain/, application/, infrastructure/, api/
  - [ ] `payment/` with domain/, application/, infrastructure/, api/
- [ ] Each module has sub-packages:
  - [ ] `domain/entity/`, `domain/repository/`, `domain/vo/`
  - [ ] `application/service/`, `application/dto/`
  - [ ] `infrastructure/persistence/`, `infrastructure/service/`
  - [ ] `api/controller/`
- [ ] `.gitkeep` files added to empty packages for git tracking

## Estimated Effort
4 hours

## Assignee
TBD

## Status
Not Started

## Dependencies
None

## Notes
This is the foundation task. Everything else depends on this being done correctly.
