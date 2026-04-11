# 🔐 Authentication API

## Overview
JWT-based authentication system for user registration, login, and token management.

## Endpoints

### Register User
```
POST /api/auth/register
```

**Request Body:**
```json
{
  "email": "user@example.com",
  "password": "password123",
  "firstName": "John",
  "lastName": "Doe"
}
```

**Response:**
```json
{
  "id": "uuid",
  "email": "user@example.com",
  "firstName": "John",
  "lastName": "Doe",
  "role": "USER",
  "createdAt": "2024-01-01T00:00:00Z"
}
```

### Login
```
POST /api/auth/login
```

**Request Body:**
```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "jwt-token",
  "type": "Bearer",
  "expiresIn": 3600,
  "user": {
    "id": "uuid",
    "email": "user@example.com",
    "role": "USER"
  }
}
```

### Refresh Token
```
POST /api/auth/refresh
```

**Headers:**
```
Authorization: Bearer <token>
```

**Response:**
```json
{
  "token": "new-jwt-token",
  "expiresIn": 3600
}
```

### Logout
```
POST /api/auth/logout
```

**Headers:**
```
Authorization: Bearer <token>
```

## Error Responses

**400 Bad Request:**
```json
{
  "error": "Validation failed",
  "details": ["Email is required", "Password must be at least 8 characters"]
}
```

**401 Unauthorized:**
```json
{
  "error": "Invalid credentials"
}
```

**409 Conflict:**
```json
{
  "error": "Email already exists"
}
```

## Security Notes
- Passwords are hashed using BCrypt
- JWT tokens expire after 1 hour
- Use HTTPS in production
- Implement rate limiting for auth endpoints
