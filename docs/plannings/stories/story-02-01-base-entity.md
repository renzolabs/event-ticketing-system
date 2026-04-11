# Story 2.1: Create Base Entity Class

## Epic
[Epic 2: Shared Infrastructure](../epics/epic-02-shared-infrastructure.md)

## Story
**As a** developer  
**I want to** create a base entity class with common fields  
**So that** all domain entities inherit consistent structure (UUID, timestamps)

## Acceptance Criteria
- [ ] `BaseEntity` class exists in `shared/domain/entity/`
- [ ] Uses `@MappedSuperclass` annotation
- [ ] Fields included:
  - `id`: UUID (primary key, auto-generated)
  - `createdAt`: LocalDateTime (auto-set on create)
  - `updatedAt`: LocalDateTime (auto-updated on modify)
- [ ] Uses JPA annotations for lifecycle callbacks:
  - `@PrePersist` for createdAt
  - `@PreUpdate` for updatedAt
- [ ] Uses UUID generation strategy
- [ ] All entities can extend this class

## Tasks
1. Create `shared/domain/entity/BaseEntity.java`
2. Add UUID id field with `@Id` and `@GeneratedValue`
3. Add createdAt and updatedAt fields
4. Implement `@PrePersist` to set timestamps
5. Implement `@PreUpdate` to update timestamp
6. Add Lombok annotations (@Getter, @EqualsAndHashCode, etc.)
7. Write unit test for timestamp behavior

## Estimated Effort
1 hour

## Priority
Must Have

## Notes
Using UUID aligns with API documentation. All entities (User, Event, Booking, Payment) will extend this class.

Implementation example:
```java
@MappedSuperclass
@Getter
@EqualsAndHashCode(of = "id")
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
```
