# Retailer Rewards Program - Spring Boot

This Spring Boot application calculates customer reward points based on purchase transactions over a 3-month period. It exposes a RESTful API to retrieve reward points per customer, per month, and in total.

---

## Rewards Logic

Customers earn points according to the following rule:

- 2 points for every dollar spent over $100
- 1 point for every dollar spent between $50 and $100
- No points for spending below $50

**Example:**
Transaction of $120 → (2 * $20) + (1 * $50) = 90 points

**API Endpoint: GET /api/rewards**
Returns the monthly and total reward points earned per customer.


## Tech Stack

- Java 17+
- Spring Boot 3.2.x
- Maven
- REST API
- Postman Collection for Testing

---

**Prerequisites**

Ensure the following tools are installed on your system:

- Java 17+
- Maven
- Git

**#API Base URL**

```
http://localhost:8080/api/rewards
```

**GET `/api/rewards`**

Fetches reward points for all customers, grouped by month and with a total.

**Response Sample**

```json
[
  {
    "customerId": "C001",
    "monthlyPoints": {
      "Mar 2025": 115,
      "Apr 2025": 250
    },
    "totalPoints": 365
  },
  {
    "customerId": "C002",
    "monthlyPoints": {
      "Mar 2025": 45,
      "May 2025": 110
    },
    "totalPoints": 155
  }
]
```

---
**Sample Response**
[
  {
    "customerId": "C001",
    "monthlyPoints": {
      "Mar 2025": 115,
      "Apr 2025": 250
    },
    "totalPoints": 365
  },
  {
    "customerId": "C002",
    "monthlyPoints": {
      "Mar 2025": 45,
      "May 2025": 110
    },
    "totalPoints": 155
  }
]

---
