# Planning Documents

This folder contains epics, stories, and tasks for the Event Ticketing System.

## Contents Overview

| Document | Description |
|----------|-------------|
| [Tasks](tasks/) | Small, actionable work units for developers |
| [Milestone 1](milestones/milestone-01-foundation.md) | Week 1 complete plan |
| [Stories](stories/) | 28 user stories |
| [Epics](epics/) | 5 epic definitions |
| [MVP Plan](plan-mvp-execution.md) | Overall MVP execution plan |

## Development Hierarchy

```
Epic (Large Feature)
    ↓
Story (User-facing deliverable)
    ↓
Task (Small, actionable work unit)
    ↓
Developer implementation
```

## Week 1 Scope

| Phase | Stories | Tasks | Est. Hours |
|-------|---------|-------|------------|
| Foundation | 13 | ~25 | 17h |
| Authentication | 6 | ~15 | 11h |
| Integration | 1 | ~3 | 3h |
| Event & Booking | 8 | ~20 | 17h |
| **Total** | **28** | **~63** | **~48h** |

Timeline breakdown:
- Days 1-3: Project Setup, Shared Infrastructure, User Module
- Days 4-6: JWT Authentication, Security, Auth API
- Day 7: Integration Testing
- Days 8-12: Event & Booking Core

## Folder Structure

```
docs/plannings/
├── README.md                    # This file
├── plan-mvp-execution.md        # Overall MVP plan
├── milestones/
│   └── milestone-01-foundation.md   # Week 1 plan
├── epics/                       # Epic definitions
│   ├── epic-01-project-setup.md
│   ├── epic-02-shared-infrastructure.md
│   ├── epic-03-user-module-foundation.md
│   ├── epic-04-authentication.md
│   └── epic-05-event-ticketing-core.md
├── stories/                     # User stories
│   ├── story-01-01-verify-project-structure.md
│   ├── story-01-02-setup-package-structure.md
│   └── ... (26 more stories)
└── tasks/                       # 🎯 Tasks for developers
    ├── README.md                # How to use tasks
    ├── story-01-01/             # Tasks for Story 1.1
    │   ├── task-01-verify-maven-wrapper.md
    │   ├── task-02-verify-dependencies.md
    │   └── task-03-initial-compile.md
    └── story-01-02/             # Tasks for Story 1.2
        └── ... (more task folders)
```

## Story Dependencies

| Story | Depends On |
|-------|------------|
| 2.1 (Base Entity) | 1.2 (Package Structure) |
| 2.2 (Exception Handler) | 1.3 (App Config) |
| 3.1 (User Entity) | 2.1 (Base Entity) |
| 3.2 (UserRepository) | 3.1 (User Entity) |
| 3.3 (UserService) | 3.2 (UserRepository) |
| 4.1 (JwtProvider) | 3.3 (UserService) |
| 4.3 (AuthService) | 3.3, 4.1, 4.2 |
| 4.4 (JwtFilter) | 4.1 (JwtProvider) |
| 4.6 (AuthController) | 4.3, 4.5 |
| 1.6 (Integration Test) | 4.6 (AuthController) |
| 5.1 (Event Entity) | 2.1 (Base Entity) |
| 5.4 (Ticket Tier) | 5.1 (Event Entity) |
| 5.5 (Booking Entity) | 3.1 (User Entity), 5.4 (Ticket Tier) |
| 5.6 (Booking Service) | 5.5 (Booking Entity) |
| 5.7 (Booking API) | 4.6 (AuthController), 5.6 (Booking Service) |

## Document Format Reference

### Story Template
- Title: Story name
- Epic: Parent epic
- Estimate: Hours
- Description: As a... I want... So that...
- Acceptance Criteria: Checklist of requirements

### Task Template
- Title: Task name
- Parent Story: Link to story
- Estimate: Minutes/Hours
- Description: What needs to be done
- Acceptance Criteria: Checklist

## Naming Conventions

| Type | Pattern | Example |
|------|---------|---------|
| Epic | `epic-{NN}-{name}.md` | `epic-01-project-setup.md` |
| Story | `story-{EPIC}-{NN}-{name}.md` | `story-01-01-verify-project-structure.md` |
| Task | `task-{NN}-{name}.md` | `task-01-verify-maven-wrapper.md` |
| Milestone | `milestone-{NN}-{name}.md` | `milestone-01-foundation.md` |
