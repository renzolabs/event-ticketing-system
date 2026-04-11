# Story 3.3: Implement UserService

## Epic
[Epic 3: User Module Foundation](../epics/epic-03-user-module-foundation.md)

## Story
**As a** developer  
**I want to** have a service layer for user operations  
**So that** business logic is encapsulated and reusable

## Acceptance Criteria
- [ ] `UserService` interface exists in `user/application/service/`
- [ ] `UserServiceImpl` class exists in `user/infrastructure/service/`
- [ ] Methods:
  - `User createUser(CreateUserRequest request)`
  - `Optional<User> findById(UUID id)`
  - `Optional<User> findByEmail(String email)`
  - `boolean existsByEmail(String email)`
- [ ] Password is encoded using BCrypt before saving
- [ ] Duplicate email check before creation
- [ ] Transactional boundaries properly defined
- [ ] Unit tests for service implementation

## Tasks
1. Create `user/application/service/UserService.java` (interface)
2. Define all service methods
3. Create `user/infrastructure/service/UserServiceImpl.java`
4. Inject UserRepository and PasswordEncoder
5. Implement createUser with duplicate check and password encoding
6. Implement find methods
7. Write unit tests with Mockito
8. Write integration tests

## Estimated Effort
2 hours

## Priority
Must Have

## Notes
Service layer is where business rules live. Password encoding happens here or in a dedicated domain service.

Service interface:
```java
public interface UserService {
    User createUser(CreateUserRequest request);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
```

Service implementation:
```java
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public User createUser(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException("Email already exists");
        }
        
        User user = User.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .build();
            
        return userRepository.save(user);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }
    
    // ... other methods
}
```
