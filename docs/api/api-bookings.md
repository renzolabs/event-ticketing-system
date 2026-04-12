# Bookings API

## Overview
Booking system for purchasing and managing event tickets.

## Endpoints

### Create Booking
```
POST /api/bookings
```

**Headers:**
```
Authorization: Bearer <token>
```

**Request Body:**
```json
{
  "eventId": "uuid",
  "quantity": 2,
  "paymentMethod": "CREDIT_CARD"
}
```

**Response:**
```json
{
  "id": "uuid",
  "bookingReference": "BK-2024-001234",
  "eventId": "uuid",
  "event": {
    "title": "Summer Music Festival",
    "dateTime": "2024-07-15T18:00:00Z",
    "venue": "Central Park"
  },
  "userId": "uuid",
  "quantity": 2,
  "totalPrice": 100.00,
  "status": "CONFIRMED",
  "bookingDate": "2024-01-01T00:00:00Z",
  "tickets": [
    {
      "id": "uuid",
      "ticketNumber": "TK-001",
      "qrCode": "base64-encoded-qr"
    }
  ]
}
```

### Get User Bookings
```
GET /api/bookings/my-bookings
```

**Headers:**
```
Authorization: Bearer <token>
```

**Query Parameters:**
- `page`: Page number (default: 0)
- `size`: Page size (default: 20)
- `status`: Filter by status (CONFIRMED, CANCELLED, PENDING)

**Response:**
```json
{
  "content": [
    {
      "id": "uuid",
      "bookingReference": "BK-2024-001234",
      "event": {
        "id": "uuid",
        "title": "Summer Music Festival",
        "dateTime": "2024-07-15T18:00:00Z",
        "venue": "Central Park"
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

### Get Booking by ID
```
GET /api/bookings/{bookingId}
```

**Headers:**
```
Authorization: Bearer <token>
```

**Response:**
```json
{
  "id": "uuid",
  "bookingReference": "BK-2024-001234",
  "event": {
    "id": "uuid",
    "title": "Summer Music Festival",
    "description": "Annual outdoor music festival",
    "dateTime": "2024-07-15T18:00:00Z",
    "venue": "Central Park",
    "organizer": {
      "name": "John Doe",
      "email": "john@example.com"
    }
  },
  "quantity": 2,
  "totalPrice": 100.00,
  "status": "CONFIRMED",
  "bookingDate": "2024-01-01T00:00:00Z",
  "tickets": [
    {
      "id": "uuid",
      "ticketNumber": "TK-001",
      "qrCode": "base64-encoded-qr",
      "seatNumber": "A1"
    },
    {
      "id": "uuid",
      "ticketNumber": "TK-002",
      "qrCode": "base64-encoded-qr",
      "seatNumber": "A2"
    }
  ]
}
```

### Cancel Booking
```
POST /api/bookings/{bookingId}/cancel
```

**Headers:**
```
Authorization: Bearer <token>
```

**Response:**
```json
{
  "message": "Booking cancelled successfully",
  "refundAmount": 100.00,
  "refundStatus": "PROCESSING"
}
```

### Download Tickets
```
GET /api/bookings/{bookingId}/tickets
```

**Headers:**
```
Authorization: Bearer <token>
```

**Query Parameters:**
- `format`: Download format (PDF, QR)

**Response:**
For PDF format:
```
Content-Type: application/pdf
Content-Disposition: attachment; filename="tickets-BK-2024-001234.pdf"
```

For QR format:
```json
{
  "tickets": [
    {
      "ticketNumber": "TK-001",
      "qrCode": "base64-encoded-qr",
      "eventDetails": {
        "title": "Summer Music Festival",
        "dateTime": "2024-07-15T18:00:00Z",
        "venue": "Central Park"
      }
    }
  ]
}
```

## Booking Status
- `PENDING`: Payment is being processed
- `CONFIRMED`: Booking is confirmed and paid
- `CANCELLED`: Booking has been cancelled
- `REFUNDED`: Refund has been processed

## Payment Methods
- `CREDIT_CARD`: Credit/Debit card
- `PAYPAL`: PayPal account
- `BANK_TRANSFER`: Bank transfer
- `CASH_ON_DELIVERY`: Cash payment (for in-person events)

## Error Responses

**400 Bad Request:**
```json
{
  "error": "Invalid booking request",
  "details": ["Not enough tickets available"]
}
```

**404 Not Found:**
```json
{
  "error": "Booking not found"
}
```

**409 Conflict:**
```json
{
  "error": "Cannot cancel booking",
  "reason": "Event already started"
}
```

**403 Forbidden:**
```json
{
  "error": "Not authorized to access this booking"
}
```

## Business Rules
- Users can book maximum 10 tickets per event
- Cancellation allowed up to 24 hours before event
- Refunds processed within 5-7 business days
- QR codes are single-use and expire after event
