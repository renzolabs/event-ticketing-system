# 🧩 Epic: Shared Infrastructure

## 🎯 Goal

Create shared components and utilities used across all modules including base entities, exception handling, and common response formats.

---

## 📄 Description

This epic establishes the common infrastructure that every module will depend on. It defines standard patterns for entities, API responses, and error handling to ensure consistency throughout the application.

These components live in the `shared/` module and are available to all feature modules.

---

## ✅ Success Criteria

* BaseEntity class exists with common fields (UUID, timestamps)
* GlobalExceptionHandler handles all common exceptions consistently
* ApiResponse and ErrorResponse DTOs are defined
* Application returns consistent error format for all endpoints
* Validation utilities are available for reuse

---

## 📦 Scope (Stories inside this Epic)

### 1. Base Entity

* As a developer, I want a base entity class so that all entities have consistent ID and timestamp handling

### 2. Exception Handler

* As a developer, I want a global exception handler so that errors are returned in a consistent format

### 3. Common Response DTOs

* As a developer, I want standardized response wrappers so that API consumers get predictable responses

### 4. Validation Utilities

* As a developer, I want reusable validation utilities so that validation logic is consistent across the app

---

## 🔧 Technical Notes

* **BaseEntity** uses JPA's `@MappedSuperclass`
* **UUID** as primary key type (consistent with API docs)
* **Error response format** must match API documentation:
  ```json
  {
    "error": "Error type",
    "message": "Human readable message",
    "details": ["Specific error details"],
    "timestamp": "2024-01-01T00:00:00Z"
  }
  ```
* **Auto-timestamp** generation for all entities
* **Validation** annotations use Jakarta Validation

---

## 🚧 Out of Scope

* Business-specific validation rules
* Custom validation annotations for domains
* Localization of error messages
* Performance monitoring utilities

---

## 📊 Priority

High (blocks entity creation in other modules)

---

## 🧠 Why this is a good Epic

* Provides reusable foundation for all modules
* Ensures API consistency
* Reduces duplication
* Small, focused scope

---

## 📋 Story Links

1. [Story 2.1: Create Base Entity Class](../stories/story-02-01-base-entity.md)
2. [Story 2.2: Create Global Exception Handler](../stories/story-02-02-global-exception-handler.md)
3. [Story 2.3: Create Common Response DTOs](../stories/story-02-03-common-response-dtos.md)
4. [Story 2.4: Setup Validation Utilities](../stories/story-02-04-validation-utilities.md)

---

## 🔗 Dependencies

* Epic 1: Project Setup (must be completed)

---

## 🗓️ Timeline

**Day 2** (5 hours)
