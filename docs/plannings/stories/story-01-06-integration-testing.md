# Story 1.6: End-to-End Integration Testing

## Epic
[Epic 1: Project Setup](../epics/epic-01-project-setup.md)

## Story
**As a** developer  
**I want to** verify the complete auth flow works end-to-end  
**So that** I can confirm the foundation is solid before moving forward

## Acceptance Criteria
- [ ] Integration test for full registration flow
- [ ] Integration test for login → access protected endpoint → logout
- [ ] Integration test for invalid credentials handling
- [ ] Integration test for expired token handling
- [ ] All existing unit tests still pass
- [ ] Test coverage report generated (Jacoco)
- [ ] Document any issues found and fixes applied

## Tasks
1. Create `test/integration/AuthIntegrationTest.java`
2. Create `test/integration/UserIntegrationTest.java`
3. Use `@SpringBootTest` with TestContainers or Docker Compose
4. Test full flow: Register → Login → Call /me → Logout
5. Test error scenarios: Wrong password, expired token, missing token
6. Run all tests and verify coverage
7. Fix any issues discovered
8. Update documentation if API changes needed

## Estimated Effort
3 hours

## Priority
Should Have

## Notes
Use TestContainers for PostgreSQL or run against Docker Compose. This validates the entire Week 1 work before proceeding to Event module.

Test skeleton:
```java
@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
public class AuthIntegrationTest {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17");
    
    @Test
    void shouldRegisterAndLogin() {
        // Register user
        // Login and get cookie
        // Access protected endpoint
        // Logout
    }
}
```

## Success = Week 1 Complete
When this story is done, Week 1 foundation is verified and ready for Week 2 (Event/Booking modules).
