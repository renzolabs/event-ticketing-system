#!/bin/bash

# Event Ticketing System API Tests using HTTPie
# Make sure the application is running on localhost:8080

echo "=== Event Ticketing System API Tests ==="
echo

# Base URL
BASE_URL="http://localhost:8080"

echo "1. Registering a new user..."
http --session=auth POST $BASE_URL/auth/register email="test@example.com" password="password123"
echo

echo "2. Logging in..."
http --session=auth POST $BASE_URL/auth/login email="test@example.com" password="password123"
echo

echo "3. Getting current user profile..."
http --session=auth GET $BASE_URL/users/me
echo

echo "4. Creating an event..."
http --session=auth POST $BASE_URL/events name="Summer Music Festival" description="An amazing outdoor music festival" date:="2024-07-15T18:00:00" totalTickets:=1000
echo

echo "5. Listing all events..."
http GET $BASE_URL/events
echo

echo "6. Creating a booking..."
http --session=auth POST $BASE_URL/bookings eventId:=1 quantity:=2 amount:=99.99
echo

echo "7. Getting user bookings..."
http --session=auth GET $BASE_URL/bookings/user/1
echo

echo "8. Creating payment..."
http POST $BASE_URL/payments bookingId:=1 amount:=99.99
echo

echo "9. Updating payment status..."
http PATCH $BASE_URL/payments/1/status status:="SUCCESS"
echo

echo "10. Checking event availability after booking..."
http GET $BASE_URL/events/1
echo

echo "11. Logging out..."
http --session=auth POST $BASE_URL/auth/logout
echo

echo "=== Test Complete ==="
