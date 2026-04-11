# 📝 Global Naming Conventions

## Universal Rules (All File Types)

### ✅ Required
- **Lowercase** for all non-code files
- **Kebab-case** (hyphens) for documentation, configs, scripts
- **No spaces** in any file name
- **No special characters**: `< > : " | ? * & ; # $ ! ' @ % { } [ ] + =`
- **Max 100 characters** for file names (excluding extension)

### ❌ Prohibited
- Spaces (` `) - Use hyphens instead
- Underscores (`_`) in non-code files - Use hyphens instead  
- Mixed case in documentation - Use lowercase
- Vague names like `final`, `new`, `test`, `temp`, `old`

---

## By File Type

### 📄 Documentation Files (`.md`, `.txt`)

**Format:** `kebab-case.md`

**Pattern:** `[category]-[purpose]-[type].md`

**Examples:**
- ✅ `project-overview.md`
- ✅ `api-authentication.md`
- ✅ `dev-backend-guide.md`
- ✅ `architecture-system-design.md`
- ✅ `review-code-summary.md`

**Exceptions Allowed:**
- `README.md` - Project overview (root only)
- `LICENSE.md` - License file
- `CONTRIBUTING.md` - Contribution guidelines
- `CHANGELOG.md` - Version history

**Anti-patterns:**
- ❌ `MyDocument.md`
- ❌ `my_document.md`
- ❌ `my document.md`
- ❌ `README-BUILD.md`

---

### ☕ Java Files (`.java`)

**Classes:** `PascalCase`
- ✅ `UserController.java`
- ✅ `BookingService.java`
- ✅ `EventRepository.java`

**Interfaces:** `PascalCase` (often descriptive)
- ✅ `UserService.java`
- ✅ `PaymentProcessor.java`

**Methods:** `camelCase`
- ✅ `getUserById()`
- ✅ `processPayment()`

**Variables:** `camelCase`
- ✅ `userRepository`
- ✅ `bookingList`

**Constants:** `UPPER_SNAKE_CASE`
- ✅ `MAX_RETRY_COUNT`
- ✅ `DEFAULT_TIMEOUT`

**Packages:** `lowercase` (dot-separated)
- ✅ `com.renzo.labs.ticketing`
- ✅ `com.example.project.auth`

---

### 🐍 Python Files (`.py`)

**Files:** `snake_case.py`
- ✅ `user_service.py`
- ✅ `booking_repository.py`
- ✅ `config_loader.py`

**Classes:** `PascalCase`
- ✅ `UserService`
- ✅ `BookingRepository`

**Functions:** `snake_case`
- ✅ `get_user_by_id()`
- ✅ `process_payment()`

**Variables:** `snake_case`
- ✅ `user_repository`
- ✅ `booking_list`

**Constants:** `UPPER_SNAKE_CASE`
- ✅ `MAX_RETRY_COUNT`
- ✅ `DEFAULT_TIMEOUT`

---

### 🟨 JavaScript/TypeScript Files (`.js`, `.ts`, `.jsx`, `.tsx`)

**Components (React/Vue):** `PascalCase`
- ✅ `UserProfile.jsx`
- ✅ `BookingCard.tsx`

**Hooks:** `camelCase` (starts with `use`)
- ✅ `useAuth.js`
- ✅ `useBooking.ts`

**Utils/Services:** `camelCase`
- ✅ `apiClient.js`
- ✅ `dateUtils.ts`

**Variables:** `camelCase`
- ✅ `userProfile`
- ✅ `bookingList`

**Constants:** `UPPER_SNAKE_CASE`
- ✅ `API_BASE_URL`
- ✅ `DEFAULT_PAGE_SIZE`

**Configuration Files:** `kebab-case`
- ✅ `vite.config.ts`
- ✅ `tailwind.config.js`

---

### 🗄️ Database Migration Files

**Flyway Format:** `V[number]__[description].sql`
- ✅ `V1__create-users-table.sql`
- ✅ `V2__add-user-indexes.sql`
- ✅ `V10__add-payment-status.sql`

**Liquibase Format:** `kebab-case.xml` or `kebab-case.yaml`
- ✅ `create-users-table.xml`
- ✅ `add-booking-constraints.yaml`

---

### 🔧 Script Files (`.sh`, `.bat`, `.ps1`)

**Format:** `kebab-case.[ext]`

**Pattern:** `[action]-[subject].[ext]`

**Examples:**
- ✅ `build-test.sh`
- ✅ `deploy-staging.bat`
- ✅ `validate-governance.sh`
- ✅ `sync-to-machine.sh`
- ✅ `install-hooks.sh`

**Anti-patterns:**
- ❌ `runTests.sh`
- ❌ `deploy_staging.bat`
- ❌ `MyScript.sh`

---

### ⚙️ Configuration Files

**General:** `kebab-case.[ext]`
- ✅ `docker-compose.yml`
- ✅ `application.yaml`
- ✅ `checkstyle.xml`
- ✅ `spotbugs-exclude.xml`

**Environment Files:** `kebab-case.env`
- ✅ `local.env`
- ✅ `staging.env`
- ✅ `production.env`

**Exception:**
- `pom.xml` - Maven (standard)
- `package.json` - NPM (standard)
- `.gitignore` - Git (standard, dot-prefix)

---

## 📁 Folder Naming

**All folders:** `kebab-case`

**Examples:**
- ✅ `docs/governance/`
- ✅ `docs/templates/`
- ✅ `src/main/java/`
- ✅ `tools/http-client/`
- ✅ `scripts/tests/`

**Anti-patterns:**
- ❌ `docs/governanceRules/`
- ❌ `src/main/Java/`
- ❌ `tools/HTTPClient/`

---

## 🏗️ Module & Layer Naming

### Java 4-Layer Architecture

```
{module}/
├── api/                        # Controllers, DTOs
├── application/                # Services, facades
├── domain/                    # Entities, enums
└── infrastructure/            # Repositories, utils
```

**Controller:** `{Entity}Controller`
- ✅ `UserController.java`
- ✅ `BookingController.java`

**Service Interface:** `{Entity}Service`
- ✅ `UserService.java`
- ✅ `BookingService.java`

**Service Implementation:** `{Entity}ServiceImpl`
- ✅ `UserServiceImpl.java`
- ✅ `BookingServiceImpl.java`

**Repository:** `{Entity}Repository`
- ✅ `UserRepository.java`
- ✅ `BookingRepository.java`

**Entity:** `{Entity}`
- ✅ `User.java`
- ✅ `Booking.java`

**DTO Request:** `{Action}{Entity}Request`
- ✅ `CreateUserRequest.java`
- ✅ `UpdateBookingRequest.java`

**DTO Response:** `{Entity}Response`
- ✅ `UserResponse.java`
- ✅ `BookingResponse.java`

---

## ✅ Validation Checklist

Before creating any file, verify:

- [ ] Name is all lowercase (non-code files)
- [ ] Uses hyphens not spaces or underscores (non-code)
- [ ] No special characters
- [ ] Follows language-specific convention (code files)
- [ ] Descriptive but concise (max 100 chars)
- [ ] Not vague (avoid: `final`, `new`, `test`)
- [ ] Correct folder location

---

## 🔄 Quick Reference

| File Type | Case | Example |
|-----------|------|---------|
| Documentation | kebab-case | `api-documentation.md` |
| Java Classes | PascalCase | `UserController.java` |
| Java Methods | camelCase | `getUserById()` |
| Python Files | snake_case | `user_service.py` |
| Python Classes | PascalCase | `UserService` |
| JS Components | PascalCase | `UserProfile.jsx` |
| JS Utils | camelCase | `apiClient.js` |
| Scripts | kebab-case | `build-test.sh` |
| Configs | kebab-case | `docker-compose.yml` |
| Folders | kebab-case | `docs/governance/` |

---

**Version**: 1.0  
**Enforced By**: AI agents, Git hooks, Validation scripts  
**Applies To**: All projects using ai-guidelines-base
