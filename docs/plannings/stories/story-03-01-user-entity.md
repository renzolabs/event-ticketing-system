# Story 3.1: Create User Entity

## Epic
[Epic 3: User Module Foundation](../epics/epic-03-user-module-foundation.md)

## Story
**As a** system  
**I want to** store user information in the database  
**So that** users can be identified and authenticated

## Acceptance Criteria
- [ ] `User` entity exists in `user/domain/entity/`
- [ ] Extends `BaseEntity`
- [ ] Fields:
  - `email`: String (unique, not null, max 255)
  - `password`: String (not null, max 255)
  - `firstName`: String (max 100)
  - `lastName`: String (max 100)
  - `role`: Enum (USER, ADMIN) - defaults to USER
- [ ] Database constraints:
  - Unique index on email
  - Non-null constraints where applicable
- [ ] Lombok annotations for boilerplate reduction
- [ ] Equals and hashCode based on UUID (inherited from BaseEntity)

## Tasks
1. Create `user/domain/entity/User.java`
2. Extend `BaseEntity`
3. Add all fields with JPA annotations
4. Create `Role` enum in `user/domain/vo/`
5. Add database constraints via annotations
6. Add Lombok annotations
7. Create Flyway migration for users table

## Estimated Effort
1.5 hours

## Priority
Must Have

## Notes
User entity is the foundation for authentication. Password will be stored as BCrypt hash (60 chars), so allow space in column.

Entity structure:
```java
@Entity
@Table(name = "users", indexes = {
    @Index(name = "idx_users_email", columnList = "email", unique = true)
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private Role role = Role.USER;

    public enum Role {
        USER, ADMIN
    }
}
```

Migration: `V1__Create_users_table.sql`
