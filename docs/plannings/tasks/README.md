# Tasks

This folder contains substantial development tasks (~4 hours each). Tasks combine related stories into meaningful work units that developers pick up and complete one by one.

## Structure

```
tasks/
├── README.md                    # This file
├── epic-01/                     # Epic 1: Project Setup
│   ├── task-01-project-setup-and-structure.md
│   └── task-02-database-and-infrastructure.md
├── epic-02/                     # Epic 2: Shared Infrastructure
│   ├── task-01-base-entity-and-response-framework.md
│   └── task-02-exception-handling-and-validation.md
├── epic-03/                     # Epic 3: User Module
│   ├── task-01-user-entity-and-repository.md
│   └── task-02-user-service-and-dtos.md
└── epic-04/                     # Epic 4: Authentication
    ├── task-01-jwt-infrastructure.md
    ├── task-02-authentication-service-and-filter.md
    └── task-03-security-configuration-and-controller.md
```

## Task Naming

- **Folder**: `epic-{NN}/` - Groups tasks by epic
- **File**: `task-{NN}-{descriptive-name}.md` - Sequential within epic

## Task Characteristics

Each task is:
- **~4 hours** of focused work
- **Self-contained** - can be completed in one session
- **Meaningful** - produces working, testable code
- **Combinations** of 2-4 related user stories

## Task Organization

| Epic | Task | Description | Est. | Status |
|------|------|-------------|------|--------|
| **Epic 1** | 1.1 | Project Setup and Modular Structure | 4h | Done |
| | 1.2 | Database and Infrastructure Setup | 4h | Done |
| **Epic 2** | 2.1 | Base Entity and Response Framework | 4h | Done |
| | 2.2 | Exception Handling and Validation | 4h | Done |
| **Epic 3** | 3.1 | User Entity and Repository | 4h | In Progress (60%) |
| | 3.2 | User Service and DTOs | 4h | Not Started |
| **Epic 4** | 4.1 | JWT Infrastructure | 4h | In Progress (75%) |
| | 4.2 | Authentication Service and Filter | 4h | In Progress (70%) |
| | 4.3 | Security Configuration and Controller | 4h | In Progress (80%) |
| **Total** | | | **~36h** | ~45% Complete |

## How to Work on Tasks

### 1. Pick a Task
- Choose a task with **Not Started** status
- Check dependencies (previous tasks in epic, or previous epics)
- Assign yourself
- Move to **In Progress**

### 2. Work on Task
- Read the **Acceptance Criteria** carefully
- Complete all checklist items
- Follow the estimated time (~4 hours)
- Update status as you work

### 3. Complete Task
- Verify all acceptance criteria are met
- Self-review your work
- Run tests
- Move to **In Review**
- Create PR if needed

### 4. Done
- After review/approval, move to **Done**
- Pick next task

## Task Status

| Status | Meaning |
|--------|---------|
| Not Started | Ready to pick up |
| In Progress | Currently being worked on |
| In Review | Complete, awaiting review |
| Done | Reviewed and accepted |
| Blocked | Cannot proceed (add blocker reason) |

## Task Dependencies

```
Epic 1 (Setup)
    ↓
Epic 2 (Shared Infrastructure)
    ↓
Epic 3 (User Module)
    ↓
Epic 4 (Authentication)
```

Within each epic:
- Task 1 must be done before Task 2
- Task 2 must be done before Task 3

## Tips

1. **Focus on one task** - Don't multitask across epics
2. **Complete AC before moving** - All checkboxes must be checked
3. **Test as you go** - Don't wait until the end
4. **Document blockers** - Add notes if stuck
5. **Timebox to ~4 hours** - If taking longer, split remaining work

## Template

Each task includes:
- Parent Epic reference
- Combined Stories (what stories this task covers)
- Overview (what you're building)
- Acceptance Criteria (checklist)
- Estimated Effort (~4 hours)
- Dependencies
- Testing requirements

---

**Ready?** Start with [Task 1.1: Project Setup and Modular Structure](epic-01/task-01-project-setup-and-structure.md)
