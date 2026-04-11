# Story 3.2: Implement UserRepository

## Epic
[Epic 3: User Module Foundation](../epics/epic-03-user-module-foundation.md)

## Story
**As a** developer  
**I want to** have a repository interface for User CRUD operations  
**So that** I can persist and retrieve user data

## Acceptance Criteria
- [ ] `UserRepository` interface exists in `user/domain/repository/`
- [ ] Extends `JpaRepository<User, UUID>`
- [ ] Custom query methods:
  - `Optional<User> findByEmail(String email)`
  - `boolean existsByEmail(String email)`
- [ ] Spring Data JPA generates implementation automatically
- [ ] Repository is package-private (interface in domain, impl in infrastructure)

## Tasks
1. Create `user/domain/repository/UserRepository.java`
2. Extend JpaRepository with User and UUID
3. Define custom finder methods
4. Create `user/infrastructure/persistence/UserRepositoryImpl.java` if needed
5. Write integration tests with @DataJpaTest
6. Test custom queries

## Estimated Effort
1 hour

## Priority
Must Have

## Notes
Following clean architecture, repository interface stays in domain, implementation goes to infrastructure. Spring Data JPA makes this easy.

Repository interface:
```java
public interface UserRepository extends JpaRepository<User, UUID> {
    
    Optional<User> findByEmail(String email);
    
    boolean existsByEmail(String email);
}
```

Test example:
```java
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    
    @Test
    void shouldFindUserByEmail() {
        // given
        User user = User.builder()
            .email("test@example.com")
            .password("hashedPassword")
            .build();
        userRepository.save(user);
        
        // when
        Optional<User> found = userRepository.findByEmail("test@example.com");
        
        // then
        assertThat(found).isPresent();
        assertThat(found.get().getEmail()).isEqualTo("test@example.com");
    }
}
```
