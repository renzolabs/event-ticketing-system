# 📁 Standard Folder Structure

## Project Root Structure

```
project-root/
├── .windsurf/                    # AI behavior configuration
│   ├── config.json               # Main AI config
│   └── rules.md                  # Behavior rules
│
├── .ai-guidelines/              # (Optional) Shared guidelines submodule
│
├── docs/                         # Documentation
│   ├── governance/              # AI rules & standards
│   ├── templates/               # Document templates
│   ├── api/                     # API documentation
│   ├── architecture/            # System design docs
│   ├── development/             # Developer guides
│   │   ├── java/               # Java-specific guides
│   │   ├── python/             # Python-specific guides
│   │   ├── frontend/           # Frontend guides
│   │   ├── ai/                 # AI-specific guides
│   │   └── general/            # Language-agnostic guides
│   ├── plannings/              # Project planning
│   │   ├── epics/              # Epic documents
│   │   └── stories/            # Story documents
│   ├── reviews/                # Code reviews
│   ├── quality/                # QA documents
│   └── drafts/                 # Work in progress
│
├── scripts/                     # Build & test scripts
│   ├── config/                  # Script configurations
│   ├── reports/                 # Test reports
│   └── tests/                   # Test scripts
│
├── tools/                       # Development tools
│   └── http-client/            # HTTP request files
│
├── src/                         # Source code
│   └── [language-specific]/
│
├── [config files]               # Root-level configs
│   ├── README.md               # Project overview
│   ├── LICENSE                 # License file
│   ├── .gitignore             # Git ignore rules
│   └── [framework configs]    # pom.xml, package.json, etc.
```

---

## Documentation Structure

### docs/governance/
**Purpose:** AI rules and project standards

**Required Files:**
- `ai-startup-mandatory.md` - Mandatory reading for AI
- `naming-conventions.md` - Naming standards
- `ai-agent-guidelines.md` - AI behavior rules
- `governance-index.md` - Central reference

**Naming:** All kebab-case.md

---

### docs/templates/
**Purpose:** Reusable document templates

**Structure:**
```
templates/
├── epics/
│   └── epic-template.md
├── stories/
│   └── story-template.md
├── pr/
│   └── pull-request-template.md
└── code/
    ├── java-class.java
    └── python-module.py
```

**Naming:** All kebab-case.md

---

### docs/development/
**Purpose:** Developer guides organized by language/topic

**Structure:**
```
development/
├── java/                       # Java-specific
│   ├── java-coding-standards.md
│   ├── java-project-structure.md
│   └── java-backend-guide.md
│
├── python/                     # Python-specific
│   ├── python-coding-standards.md
│   └── python-project-structure.md
│
├── frontend/                   # Frontend-specific
│   ├── frontend-guide.md
│   └── react-patterns.md
│
├── ai/                         # AI-specific
│   ├── ai-development-checklist.md
│   └── ai-onboarding.md
│
└── general/                    # Language-agnostic
    ├── general-project-overview.md
    ├── general-file-naming-standards.md
    ├── general-setup.md
    └── general-code-review-checklist.md
```

**Naming:** Prefix with language/topic (java-, python-, general-, ai-)

---

### docs/api/
**Purpose:** API documentation

**Naming Pattern:** `api-[resource].md`

**Examples:**
- `api-authentication.md`
- `api-users.md`
- `api-bookings.md`

---

### docs/architecture/
**Purpose:** System design documentation

**Naming Pattern:** `architecture-[component].md`

**Examples:**
- `architecture-system-design.md`
- `architecture-database-schema.md`

---

### docs/plannings/
**Purpose:** Project planning documents

**Structure:**
```
plannings/
├── epics/
│   └── epic-*.md               # Epic documents
├── stories/
│   └── story-*.md              # Story documents
└── plan-*.md                   # Plan documents
```

**Naming:**
- Epics: `epic-[name].md`
- Stories: `story-[name].md`
- Plans: `plan-[name].md`

---

### docs/reviews/
**Purpose:** Code review summaries

**Naming Pattern:** `review-[type].md`

**Examples:**
- `review-code-summary.md`
- `review-final-summary.md`
- `review-plan.md`

---

### docs/quality/
**Purpose:** QA documents, compliance reports

**Naming Pattern:** `quality-[topic].md` or `compliance-[date].md`

---

### docs/drafts/
**Purpose:** Work in progress, temporary documents

**Naming Pattern:** `draft-[description].md`

---

## Source Code Structure

### Java / Spring Boot

```
src/
├── main/
│   ├── java/
│   │   └── com/[org]/[project]/
│   │       ├── [module]/
│   │       │   ├── api/          # Controllers, DTOs
│   │       │   ├── application/  # Services
│   │       │   ├── domain/       # Entities
│   │       │   └── infrastructure/ # Repositories
│   │       └── config/          # Configuration
│   └── resources/
│       ├── db/migration/        # Flyway migrations
│       └── application.yaml    # Config
└── test/
    └── java/
        └── com/[org]/[project]/
```

**Module Examples:**
- `auth/` - Authentication module
- `user/` - User management
- `booking/` - Booking system
- `payment/` - Payment processing
- `event/` - Event management

---

### Python / FastAPI

```
src/
├── api/                        # FastAPI routes
├── models/                     # SQLAlchemy models
├── schemas/                    # Pydantic schemas
├── services/                   # Business logic
├── repositories/              # Data access
├── utils/                     # Utilities
└── config/                    # Configuration
```

---

### React / Frontend

```
src/
├── components/                 # Reusable components
│   ├── ui/                    # UI components
│   ├── forms/                 # Form components
│   └── layout/                # Layout components
├── pages/                     # Route pages
├── hooks/                     # Custom hooks
├── lib/                       # Utilities
├── services/                  # API services
├── types/                     # TypeScript types
└── stores/                    # State management
```

---

## Scripts Structure

### scripts/
**Purpose:** Build, test, and utility scripts

**Naming:** All kebab-case with action prefix

**Examples:**
- `build-test.sh` / `build-test.bat`
- `validate-governance.sh`
- `validate-structure.sh`
- `sync-to-machine.sh`
- `install-hooks.sh`

---

## Tools Structure

### tools/
**Purpose:** Development tools and utilities

**Structure:**
```
tools/
└── http-client/                # HTTP request files
    ├── auth.http
    ├── users.http
    ├── events.http
    └── README.md
```

---

## Folder Naming Rules

### ✅ Required
- **All lowercase**
- **Kebab-case** (hyphens for multi-word)
- **No spaces**
- **No special characters**

### Examples
- ✅ `docs/governance/`
- ✅ `docs/file-naming-standards/`
- ✅ `src/main/java/`
- ✅ `tools/http-client/`

### Anti-patterns
- ❌ `docs/governanceRules/`
- ❌ `src/main/Java/`
- ❌ `tools/HTTP Client/`

---

## File Placement Reference

| What | Where | Naming Example |
|------|-------|----------------|
| AI rules | docs/governance/ | `ai-behavior-rules.md` |
| Templates | docs/templates/ | `epic-template.md` |
| API docs | docs/api/ | `api-authentication.md` |
| Java guides | docs/development/java/ | `java-coding-standards.md` |
| Epics | docs/plannings/epics/ | `epic-user-auth.md` |
| Stories | docs/plannings/stories/ | `story-login-api.md` |
| Reviews | docs/reviews/ | `review-code-summary.md` |
| Java controllers | src/.../api/ | `UserController.java` |
| Java services | src/.../application/ | `UserService.java` |
| Java entities | src/.../domain/ | `User.java` |
| Scripts | scripts/ | `build-test.sh` |
| HTTP tests | tools/http-client/ | `auth.http` |

---

## Quick Validation

Before creating any file or folder:

```markdown
- [ ] Correct folder identified?
- [ ] Naming follows convention?
- [ ] No spaces in path?
- [ ] All lowercase (folders)?
- [ ] Purpose matches folder?
```

---

**Version**: 1.0  
**Enforced By**: AI agents, Validation scripts  
**Applies To**: All projects using ai-guidelines-base
