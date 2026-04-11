# HTTP Client Testing Guide

This document describes how to use HTTP request files for testing the Event Ticketing System API endpoints.

## Tool Location

HTTP request files are located in:
```
tools/http-client/
```

## Files

- `auth.http` - Authentication requests
- `users.http` - User management requests
- `events.http` - Event management requests
- `bookings.http` - Booking requests
- `payments.http` - Payment requests
- `end-to-end.http` - Complete workflow tests

## Usage with HTTPie

### Install HTTPie

```bash
# On Windows with pip
pip install httpie

# Or with chocolatey
choco install httpie

# On macOS
brew install httpie

# On Linux
apt-get install httpie
```

### Running Tests

1. **Authentication Tests:**
   ```bash
   http --session=auth POST localhost:8080/auth/register email="test@example.com" password="password123"
   http --session=auth POST localhost:8080/auth/login email="test@example.com" password="password123"
   http --session=auth POST localhost:8080/auth/logout
   ```

2. **User Tests:**
   ```bash
   http --session=auth GET localhost:8080/users/me
   http --session=auth GET localhost:8080/users/1
   ```

3. **Event Tests:**
   ```bash
   # Create event
   http --session=auth POST localhost:8080/events name="Summer Music Festival" description="An amazing outdoor music festival" date:="2024-07-15T18:00:00" totalTickets:=1000
   
   # List events
   http GET localhost:8080/events
   
   # Get specific event
   http GET localhost:8080/events/1
   ```

4. **Booking Tests:**
   ```bash
   http --session=auth POST localhost:8080/bookings eventId:=1 quantity:=2 amount:=99.99
   http --session=auth GET localhost:8080/bookings/user/1
   ```

5. **Payment Tests:**
   ```bash
   http POST localhost:8080/payments bookingId:=1 amount:=99.99
   http PATCH localhost:8080/payments/1/status status:="SUCCESS"
   ```

## Session Management

HTTPie sessions (`--session=auth`) automatically handle cookies, so you don't need to manually copy-paste tokens between requests.

## End-to-End Flow

1. Register a user
2. Login to get authentication cookie
3. Create an event
4. Book tickets for the event
5. Process payment
6. Check booking status

## Alternative: Using .http Files Directly

You can also use the `.http` files with:
- **IntelliJ IDEA** - Native HTTP client support
- **VS Code** - REST Client extension
- **JetBrains IDEs** - Built-in HTTP client

## Notes

- All authenticated endpoints require the `access_token` cookie
- Public endpoints (like listing events) don't require authentication
- The application runs on `http://localhost:8080`
- Make sure the PostgreSQL database is running via Docker Compose

---

**File Naming**: This file follows kebab-case convention (readme-http-client.md)  
**Location**: docs/tools/ (proper documentation location)  
**Compliance**: Follows governance naming standards
