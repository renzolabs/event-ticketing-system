# Story 1.2: Setup Modular Package Structure

## Epic
[Epic 1: Project Setup](../epics/epic-01-project-setup.md)

## Story
**As a** developer  
**I want to** establish the modular package structure  
**So that** the codebase follows clean architecture with clear module boundaries

## Acceptance Criteria
- [ ] Base package `com.renzo.labs.ticketing` exists
- [ ] Following module packages are created:
  - `shared/` - Common utilities, base classes
  - `user/` - User module (domain, application, infrastructure, api)
  - `auth/` - Authentication module
  - `event/` - Event module
  - `booking/` - Booking module
  - `payment/` - Payment module
- [ ] Each module has sub-packages:
  - `domain/` - Entities, repositories (interfaces), value objects
  - `application/` - Services (interfaces), DTOs, mappers
  - `infrastructure/` - Repository implementations, service implementations
  - `api/` - Controllers, request/response objects
- [ ] `.gitkeep` files added to empty packages for git tracking

## Tasks
1. Create module root packages
2. Create domain sub-packages for each module
3. Create application sub-packages
4. Create infrastructure sub-packages
5. Create api sub-packages
6. Add .gitkeep files where needed

## Estimated Effort
1.5 hours

## Priority
Must Have

## Notes
Follow the modular monolith pattern strictly. No cross-module dependencies should exist at this stage. Each module is self-contained.

Target Structure:
```
com.renzo.labs.ticketing/
├── shared/
│   ├── domain/
│   ├── application/
│   └── infrastructure/
├── user/
│   ├── domain/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── vo/
│   ├── application/
│   │   ├── service/
│   │   └── dto/
│   ├── infrastructure/
│   │   ├── persistence/
│   │   └── service/
│   └── api/
│       └── controller/
├── auth/
│   └── ...
├── event/
│   └── ...
├── booking/
│   └── ...
└── payment/
    └── ...
```
