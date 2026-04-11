# Milestone 1: Week 1 - Foundation & Authentication

## Overview
Establish the complete foundational infrastructure for the Event Ticketing System including project setup, shared components, User module, and Authentication system.

> **Flexible Schedule**: Work on these tasks whenever you have free time. Pull from Ready column in [Kanban Board](../kanban/board.md).

## Milestone Goal
Create a fully working authentication system with:
- Solid development environment
- Database connectivity
- Shared infrastructure (entities, exceptions, DTOs)
- User management
- JWT-based cookie authentication
- Protected API endpoints

## Kanban Board
Track progress in real-time: [Kanban Board](../kanban/board.md)  
View backlog: [Kanban Backlog](../kanban/backlog.md)  
How to use: [Kanban Guide](../kanban/guide.md)

## Week 1 Timeline (Flexible)

| Day | Focus | Stories | Est. Hours |
|-----|-------|---------|------------|
| Day 1 | Project Setup | 1.1 - 1.5 | 6h |
| Day 2 | Shared Infrastructure | 2.1 - 2.4 | 5h |
| Day 3 | User Module | 3.1 - 3.4 | 6h |
| Day 4 | Auth Infrastructure | 4.1 - 4.2 | 3h |
| Day 5 | Auth Service & Filter | 4.3 - 4.4 | 4h |
| Day 6 | Security & Controller | 4.5 - 4.6 | 4h |
| Day 7 | Integration Testing | 1.6 | 3h |

**Total Estimated**: ~31 hours (work at your own pace)

## Epics

### Epic 1: Project Setup (Day 1)
Establish foundational infrastructure.

| Story | Description | Effort | Priority |
|-------|-------------|--------|----------|
| [1.1](../stories/story-01-01-verify-project-structure.md) | Verify Spring Boot Project Structure | 1h | Must |
| [1.2](../stories/story-01-02-setup-package-structure.md) | Setup Modular Package Structure | 1.5h | Must |
| [1.3](../stories/story-01-03-configure-postgresql.md) | Configure PostgreSQL Database | 1h | Must |
| [1.4](../stories/story-01-04-setup-docker-compose.md) | Setup Docker Compose Environment | 1h | Must |
| [1.5](../stories/story-01-05-configure-application-yml.md) | Configure Application YAML Profiles | 1.5h | Should |

**Epic Total**: 6 hours

### Epic 2: Shared Infrastructure (Day 2)
Create shared components used across all modules.

| Story | Description | Effort | Priority |
|-------|-------------|--------|----------|
| [2.1](../stories/story-02-01-base-entity.md) | Create Base Entity Class | 1h | Must |
| [2.2](../stories/story-02-02-global-exception-handler.md) | Create Global Exception Handler | 2h | Must |
| [2.3](../stories/story-02-03-common-response-dtos.md) | Create Common Response DTOs | 1h | Must |
| [2.4](../stories/story-02-04-validation-utilities.md) | Setup Validation Utilities | 1h | Should |

**Epic Total**: 5 hours

### Epic 3: User Module Foundation (Day 3)
Implement the User module with entity, repository, service, and DTOs.

| Story | Description | Effort | Priority |
|-------|-------------|--------|----------|
| [3.1](../stories/story-03-01-user-entity.md) | Create User Entity | 1.5h | Must |
| [3.2](../stories/story-03-02-user-repository.md) | Implement UserRepository | 1h | Must |
| [3.3](../stories/story-03-03-user-service.md) | Implement UserService | 2h | Must |
| [3.4](../stories/story-03-04-user-dtos.md) | Create User DTOs | 1.5h | Must |

**Epic Total**: 6 hours

### Epic 4: Authentication Module (Days 4-6)
Implement JWT-based cookie authentication.

| Story | Description | Effort | Priority |
|-------|-------------|--------|----------|
| [4.1](../stories/story-04-01-jwt-provider.md) | Create JwtProvider Utility | 2h | Must |
| [4.2](../stories/story-04-02-cookie-util.md) | Create CookieUtil for HTTP-Only Cookies | 1h | Must |
| [4.3](../stories/story-04-03-auth-service.md) | Implement AuthService | 2h | Must |
| [4.4](../stories/story-04-04-jwt-filter.md) | Implement JwtAuthenticationFilter | 2h | Must |
| [4.5](../stories/story-04-05-security-config.md) | Configure Spring Security | 2h | Must |
| [4.6](../stories/story-04-06-auth-controller.md) | Create AuthController | 2h | Must |

**Epic Total**: 11 hours

### Week 1 Integration (Day 7)
End-to-end testing and validation.

| Story | Description | Effort | Priority |
|-------|-------------|--------|----------|
| [1.6](../stories/story-01-06-integration-testing.md) | End-to-End Integration Testing | 3h | Should |

**Epic Total**: 3 hours

## Definition of Done

### Technical Checklist
- [ ] All code compiles without errors
- [ ] All unit tests pass
- [ ] Integration tests pass with database
- [ ] Code follows project style guidelines (Checkstyle)
- [ ] Test coverage > 70%

### Functional Checklist
- [ ] Application starts successfully with Docker Compose
- [ ] Database migrations run automatically
- [ ] User can register with email/password
- [ ] User can login and receive JWT in HTTP-only cookie
- [ ] Protected endpoints require valid authentication
- [ ] Logout clears the authentication cookie
- [ ] Exception handler returns consistent error format
- [ ] All API responses follow standard format

## Dependencies
None - This is the first milestone.

## Risks
| Risk | Impact | Mitigation |
|------|--------|------------|
| Database connection issues | High | Verify Docker Compose early |
| Spring Security complexity | Medium | Follow guide in story 4.5 |
| JWT configuration errors | Medium | Test with unit tests first |
| Time constraints (free time work) | Low | Stories are small (< 3h each) |

## Related Documents
- [Project Brief](../../drafts/draft-project-brief.md)
- [MVP Execution Plan](../plan-mvp-execution.md)
- [System Design](../../architecture/architecture-system-design.md)
- [Authentication API](../../api/api-authentication.md)

## Milestone Review Criteria
When Week 1 is complete, demonstrate:
1. **Docker Compose** starts PostgreSQL and app cleanly
2. **Registration**: `POST /api/auth/register` creates user
3. **Login**: `POST /api/auth/login` sets auth cookie
4. **Protected Access**: `GET /api/auth/me` returns user info with valid cookie
5. **Logout**: `POST /api/auth/logout` clears cookie
6. All integration tests pass

## Next Milestone Preview
**Milestone 2: Week 2 - Event & Booking Modules**
- Event management (create, list, get)
- Booking system with ticket availability
- Integration between modules
- Basic payment tracking

**Ready to start?** Open [Kanban Board](../kanban/board.md) and pull your first story!
