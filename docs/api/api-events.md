# 📅 Events API

## Overview
Event management system for creating, updating, and retrieving events.

## Endpoints

### Create Event
```
POST /api/events
```

**Headers:**
```
Authorization: Bearer <token>
```

**Request Body:**
```json
{
  "title": "Summer Music Festival",
  "description": "Annual outdoor music festival",
  "dateTime": "2024-07-15T18:00:00Z",
  "venue": "Central Park",
  "totalTickets": 1000,
  "price": 50.00,
  "category": "MUSIC"
}
```

**Response:**
```json
{
  "id": "uuid",
  "title": "Summer Music Festival",
  "description": "Annual outdoor music festival",
  "dateTime": "2024-07-15T18:00:00Z",
  "venue": "Central Park",
  "totalTickets": 1000,
  "availableTickets": 1000,
  "price": 50.00,
  "category": "MUSIC",
  "status": "ACTIVE",
  "organizerId": "uuid",
  "createdAt": "2024-01-01T00:00:00Z",
  "updatedAt": "2024-01-01T00:00:00Z"
}
```

### Get All Events
```
GET /api/events
```

**Query Parameters:**
- `page`: Page number (default: 0)
- `size`: Page size (default: 20)
- `category`: Filter by category
- `status`: Filter by status (ACTIVE, CANCELLED)
- `search`: Search in title and description

**Response:**
```json
{
  "content": [
    {
      "id": "uuid",
      "title": "Summer Music Festival",
      "dateTime": "2024-07-15T18:00:00Z",
      "venue": "Central Park",
      "availableTickets": 750,
      "price": 50.00,
      "category": "MUSIC",
      "status": "ACTIVE"
    }
  ],
  "page": 0,
  "size": 20,
  "totalElements": 1,
  "totalPages": 1
}
```

### Get Event by ID
```
GET /api/events/{eventId}
```

**Response:**
```json
{
  "id": "uuid",
  "title": "Summer Music Festival",
  "description": "Annual outdoor music festival",
  "dateTime": "2024-07-15T18:00:00Z",
  "venue": "Central Park",
  "totalTickets": 1000,
  "availableTickets": 750,
  "price": 50.00,
  "category": "MUSIC",
  "status": "ACTIVE",
  "organizer": {
    "id": "uuid",
    "name": "John Doe",
    "email": "john@example.com"
  },
  "createdAt": "2024-01-01T00:00:00Z"
}
```

### Update Event
```
PUT /api/events/{eventId}
```

**Headers:**
```
Authorization: Bearer <token>
```

**Request Body:**
```json
{
  "title": "Updated Festival Name",
  "description": "Updated description",
  "dateTime": "2024-07-16T18:00:00Z",
  "venue": "New Venue",
  "price": 60.00
}
```

### Delete Event
```
DELETE /api/events/{eventId}
```

**Headers:**
```
Authorization: Bearer <token>
```

**Response:**
```json
{
  "message": "Event deleted successfully"
}
```

## Event Categories
- `MUSIC`
- `SPORTS`
- `THEATER`
- `CONFERENCE`
- `WORKSHOP`
- `OTHER`

## Event Status
- `ACTIVE`: Event is live and available for booking
- `CANCELLED`: Event has been cancelled
- `COMPLETED`: Event has finished

## Error Responses

**404 Not Found:**
```json
{
  "error": "Event not found"
}
```

**403 Forbidden:**
```json
{
  "error": "Not authorized to modify this event"
}
```

**400 Bad Request:**
```json
{
  "error": "Invalid event data",
  "details": ["Date must be in the future"]
}
```
