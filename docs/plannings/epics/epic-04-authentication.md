# 🧩 Epic: User Authentication & Session Management

## 🎯 Goal

Enable users to securely register, log in, and access protected resources using cookie-based authentication.

---

## 📄 Description

This epic covers the complete authentication flow including user registration, login, logout, and session handling. It ensures secure access control for all protected APIs in the system.

The implementation uses **HTTP-only cookies** for token storage and a request filter for authentication validation. This approach is secure against XSS attacks and provides seamless API access.

---

## ✅ Success Criteria

* Users can register with email/password
* Users can login and receive JWT in HTTP-only cookie
* Protected endpoints require valid JWT
* Logout clears the authentication cookie
* Auth endpoints follow API specification
* Passwords are BCrypt hashed

---

## 📦 Scope (Stories inside this Epic)

### 1. User Registration

* As a user, I want to create an account using email and password

### 2. User Login

* As a user, I want to log in and receive authentication via secure cookie

### 3. Authentication Filter

* As a system, I want to validate user identity on each request

### 4. Logout

* As a user, I want to log out and clear my session

### 5. Protected API Access

* As a system, I want to restrict access to authenticated users only

---

## 🔧 Technical Notes

* **JWT** stored in HTTP-only, Secure, SameSite=Strict cookie
* **Token expiration**: 1 hour
* **Stateless authentication** (no server-side session)
* **Public endpoints**: `/auth/**`, `/actuator/**`
* **Protected endpoints**: all others require valid JWT
* **Spring Security** for request filtering and access control

**API Endpoints:**
* `POST /api/auth/register` - User registration
* `POST /api/auth/login` - User login (sets cookie)
* `POST /api/auth/logout` - User logout (clears cookie)
* `GET /api/auth/me` - Get current user info

---

## 🚧 Out of Scope

* Social login (Google, Facebook)
* Multi-factor authentication
* OAuth2 external providers
* Password reset flow
* Email verification on registration

---

## 📊 Priority

High (core system requirement)

---

## 🧠 Why this is a good Epic

* Clear business goal - users can securely access the system
* Not too big, not too vague
* Easily breakable into 5 focused stories
* Directly implementable with clear technical boundaries

---

## 📋 Story Links

1. [Story 4.1: User Registration](../stories/story-04-03-auth-service.md) - Registration service + controller endpoint
2. [Story 4.2: User Login](../stories/story-04-03-auth-service.md) - Login service with cookie handling
3. [Story 4.3: Authentication Filter](../stories/story-04-04-jwt-filter.md) - JWT validation on each request
4. [Story 4.4: Logout](../stories/story-04-06-auth-controller.md) - Logout endpoint with cookie clearing
5. [Story 4.5: Protected API Access](../stories/story-04-05-security-config.md) - Spring Security configuration

**Infrastructure Stories:**
- [Story 4.1a: JWT Provider](../stories/story-04-01-jwt-provider.md) - Token generation/validation utility
- [Story 4.2a: Cookie Utility](../stories/story-04-02-cookie-util.md) - HTTP-only cookie handling

---

## 🔗 Dependencies

* Epic 1: Project Setup (infrastructure ready)
* Epic 2: Shared Infrastructure (exception handling, DTOs)
* Epic 3: User Module Foundation (User entity and service)

---

## 🗓️ Timeline

**Days 4-6** (9 hours)
