# 👑 Admin API

## Overview
Administrative endpoints for managing events, users, and system operations.

## Endpoints

### Get All Users (Admin)
```
GET /api/admin/users
```

**Headers:**
```
Authorization: Bearer <admin-token>
```

**Query Parameters:**
- `page`: Page number (default: 0)
- `size`: Page size (default: 20)
- `role`: Filter by role (USER, ADMIN)
- `status`: Filter by status (ACTIVE, SUSPENDED)

**Response:**
```json
{
  "content": [
    {
      "id": "uuid",
      "email": "user@example.com",
      "firstName": "John",
      "lastName": "Doe",
      "role": "USER",
      "status": "ACTIVE",
      "createdAt": "2024-01-01T00:00:00Z",
      "lastLoginAt": "2024-01-15T10:30:00Z"
    }
  ],
  "page": 0,
  "size": 20,
  "totalElements": 1,
  "totalPages": 1
}
```

### Update User Status
```
PUT /api/admin/users/{userId}/status
```

**Headers:**
```
Authorization: Bearer <admin-token>
```

**Request Body:**
```json
{
  "status": "SUSPENDED",
  "reason": "Violation of terms of service"
}
```

**Response:**
```json
{
  "message": "User status updated successfully",
  "userId": "uuid",
  "newStatus": "SUSPENDED"
}
```

### Get All Events (Admin View)
```
GET /api/admin/events
```

**Headers:**
```
Authorization: Bearer <admin-token>
```

**Query Parameters:**
- `page`: Page number (default: 0)
- `size`: Page size (default: 20)
- `status`: Filter by status
- `organizerId`: Filter by organizer
- `dateFrom`: Filter by start date
- `dateTo`: Filter by end date

**Response:**
```json
{
  "content": [
    {
      "id": "uuid",
      "title": "Summer Music Festival",
      "organizer": {
        "id": "uuid",
        "name": "John Doe",
        "email": "john@example.com"
      },
      "totalTickets": 1000,
      "soldTickets": 750,
      "revenue": 37500.00,
      "status": "ACTIVE",
      "createdAt": "2024-01-01T00:00:00Z"
    }
  ],
  "page": 0,
  "size": 20,
  "totalElements": 1,
  "totalPages": 1
}
```

### Get System Statistics
```
GET /api/admin/statistics
```

**Headers:**
```
Authorization: Bearer <admin-token>
```

**Query Parameters:**
- `period`: Time period (TODAY, WEEK, MONTH, YEAR)

**Response:**
```json
{
  "users": {
    "total": 1250,
    "newThisMonth": 85,
    "activeThisMonth": 320
  },
  "events": {
    "total": 45,
    "active": 12,
    "completed": 28,
    "cancelled": 5
  },
  "bookings": {
    "total": 3420,
    "thisMonth": 280,
    "revenue": 125000.00,
    "averageTicketPrice": 36.76
  },
  "revenue": {
    "total": 125000.00,
    "thisMonth": 15000.00,
    "lastMonth": 12000.00,
    "growth": 25.0
  }
}
```

### Get Bookings (Admin View)
```
GET /api/admin/bookings
```

**Headers:**
```
Authorization: Bearer <admin-token>
```

**Query Parameters:**
- `page`: Page number (default: 0)
- `size`: Page size (default: 20)
- `status`: Filter by booking status
- `eventId`: Filter by event
- `userId`: Filter by user
- `dateFrom`: Filter by start date
- `dateTo`: Filter by end date

**Response:**
```json
{
  "content": [
    {
      "id": "uuid",
      "bookingReference": "BK-2024-001234",
      "user": {
        "id": "uuid",
        "name": "Jane Smith",
        "email": "jane@example.com"
      },
      "event": {
        "id": "uuid",
        "title": "Summer Music Festival",
        "dateTime": "2024-07-15T18:00:00Z"
      },
      "quantity": 2,
      "totalPrice": 100.00,
      "status": "CONFIRMED",
      "bookingDate": "2024-01-01T00:00:00Z"
    }
  ],
  "page": 0,
  "size": 20,
  "totalElements": 1,
  "totalPages": 1
}
```

### Cancel Event (Admin)
```
POST /api/admin/events/{eventId}/cancel
```

**Headers:**
```
Authorization: Bearer <admin-token>
```

**Request Body:**
```json
{
  "reason": "Weather conditions",
  "notifyUsers": true,
  "refundPolicy": "FULL_REFUND"
}
```

**Response:**
```json
{
  "message": "Event cancelled successfully",
  "eventId": "uuid",
  "affectedBookings": 25,
  "totalRefundAmount": 2500.00
}
```

### Export Data
```
GET /api/admin/export
```

**Headers:**
```
Authorization: Bearer <admin-token>
```

**Query Parameters:**
- `type`: Export type (USERS, EVENTS, BOOKINGS, REVENUE)
- `format`: Export format (CSV, XLSX, JSON)
- `dateFrom`: Start date filter
- `dateTo`: End date filter

**Response:**
```
Content-Type: application/octet-stream
Content-Disposition: attachment; filename="export-users-2024-01-01.csv"
```

## User Status
- `ACTIVE`: User can access the system
- `SUSPENDED`: User temporarily blocked
- `BANNED`: User permanently blocked

## Refund Policies
- `FULL_REFUND`: 100% refund
- `PARTIAL_REFUND`: Partial refund (percentage based)
- `CREDIT`: Store credit for future bookings
- `NO_REFUND`: No refund

## Error Responses

**403 Forbidden:**
```json
{
  "error": "Admin access required"
}
```

**404 Not Found:**
```json
{
  "error": "User not found"
}
```

**400 Bad Request:**
```json
{
  "error": "Invalid admin action",
  "details": ["Cannot cancel event with active bookings"]
}
```

## Admin Permissions
- `VIEW_USERS`: View user information
- `MANAGE_USERS`: Update user status and roles
- `VIEW_EVENTS`: View all events with statistics
- `MANAGE_EVENTS`: Cancel/modify any event
- `VIEW_BOOKINGS`: View all booking information
- `EXPORT_DATA`: Export system data
- `VIEW_ANALYTICS`: Access system statistics

## Audit Trail
All admin actions are logged with:
- Admin user ID
- Action performed
- Target resource
- Timestamp
- IP address
- Changes made
