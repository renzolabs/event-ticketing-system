# 🧩 Epic: User Module Foundation

## 🎯 Goal

Implement the foundational User module with entity, repository, service, and DTOs to support authentication and user management.

---

## 📄 Description

This epic builds the User domain module with complete CRUD capabilities. It establishes the user entity structure, data access layer, business logic, and API contracts.

This module serves as the foundation for authentication in Epic 4.

---

## ✅ Success Criteria

* User entity exists with all required fields
* UserRepository can perform CRUD operations
* UserService provides business logic layer
* User DTOs handle data transfer cleanly
* Unit tests for UserService pass
* Passwords are properly hashed

---

## 📦 Scope (Stories inside this Epic)

### 1. User Entity

* As a developer, I want a User entity so that user data can be stored and managed

### 2. User Repository

* As a developer, I want a UserRepository so that users can be queried and persisted

### 3. User Service

* As a developer, I want a UserService so that user business logic is centralized

### 4. User DTOs

* As a developer, I want User DTOs so that API contracts are clean and type-safe

---

## 🔧 Technical Notes

**User Fields:**
* `id`: UUID
* `email`: String (unique, not null)
* `password`: String (hashed, not null)
* `firstName`: String
* `lastName`: String
* `role`: Enum (USER, ADMIN)
* `createdAt`, `updatedAt`: Timestamp

**Constraints:**
* Email must be unique
* Password stored as **BCrypt hash**
* Role defaults to **USER**

**Module Structure:**
```
user/
├── domain/
│   ├── entity/User.java
│   ├── repository/UserRepository.java
│   └── vo/ (value objects)
├── application/
│   ├── service/UserService.java (interface)
│   └── dto/
│       ├── UserRequest.java
│       ├── UserResponse.java
│       └── UserMapper.java
└── infrastructure/
    └── service/UserServiceImpl.java
```

---

## 🚧 Out of Scope

* User profile management (update profile, change password)
* User preferences or settings
* User avatar/image uploads
* Admin user management features
* Email verification

---

## 📊 Priority

High (required for authentication)

---

## 🧠 Why this is a good Epic

* Clear, well-defined scope
* Builds reusable module
* Follows clean architecture
* Directly enables authentication

---

## 📋 Story Links

1. [Story 3.1: Create User Entity](../stories/story-03-01-user-entity.md)
2. [Story 3.2: Implement UserRepository](../stories/story-03-02-user-repository.md)
3. [Story 3.3: Implement UserService](../stories/story-03-03-user-service.md)
4. [Story 3.4: Create User DTOs](../stories/story-03-04-user-dtos.md)

---

## 🔗 Dependencies

* Epic 1: Project Setup
* Epic 2: Shared Infrastructure

---

## 🗓️ Timeline

**Day 3** (6 hours)
