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
