# Story 2.4: Setup Validation Utilities

## Epic
[Epic 2: Shared Infrastructure](../epics/epic-02-shared-infrastructure.md)

## Story
**As a** developer  
**I want to** have validation utilities and constants  
**So that** validation rules are consistent across the application

## Acceptance Criteria
- [ ] `ValidationConstants` class exists with common regex patterns:
  - Email pattern
  - Password strength requirements
  - UUID pattern
- [ ] `ValidationMessages` class exists with message keys:
  - REQUIRED_FIELD
  - INVALID_EMAIL
  - INVALID_PASSWORD
  - FIELD_TOO_SHORT
  - FIELD_TOO_LONG
- [ ] Custom validators created:
  - `@ValidEmail`
  - `@ValidPassword` (if needed)
- [ ] All constants are centralized in `shared/domain/constant/`

## Tasks
1. Create `shared/domain/constant/ValidationConstants.java`
2. Create `shared/domain/constant/ValidationMessages.java`
3. Create custom validation annotations if needed
4. Define regex patterns for common validations
5. Document validation rules

## Estimated Effort
1 hour

## Priority
Should Have

## Notes
Centralized validation ensures consistent user experience. Use standard Jakarta Validation annotations where possible.

Example constants:
```java
public final class ValidationConstants {
    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    
    public static final int PASSWORD_MIN_LENGTH = 8;
    public static final int PASSWORD_MAX_LENGTH = 100;
    
    private ValidationConstants() {}
}
```
