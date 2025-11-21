# Customer Rewards System

## Overview
The **Customer Rewards System** is a RESTful Spring Boot application that calculates rewards points for customers based on their transactions.

**Reward Rules:**
- **2 points** for every dollar spent **over $100** per transaction.
- **1 point** for every dollar spent **between $50  and $100** per transaction.
- **0 points** for every dollar spent **between $0 to $50** per transaction

The system provides:
- Total points earned by a customer over a configurable time period(<=3months from current date).
- Monthly breakdown of rewards points.
- Detailed transaction history with points earned per transaction.
- Asynchronous transaction fetching for improved performance.

---

## Technology Stack
- **Language:** Java 8
- **Framework:** Spring Boot
- **Persistence:** Spring Data JPA (H2 - in memory/ Flyway)
- **Build Tool:** Maven
- **Testing:** JUnit, Mockito

---
## API Specifications

**Endpoint:** **GET /api/transactions/rewards/{customerId}**

**Description:** Fetches the complete reward summary for a customer including total reward points, monthly breakdown, and detailed transaction

**Path Variable:**
- customerId — Unique identifier of the customer whose reward summary is requested.

**Parameters**:
- todate(Not mandatory) - Should not go beyond 90 days.
- fromDate(Not mandatory) - Should not be future date.

**Sample Response:**
```json
{
    "customerId": "sampleId",
    "customerName": "sampleName",
    "customerEmail": "ssampleEmail@gmail.com",
    "totalRewardPoints": 110,
    "monthlyPoints": {
        "August": 20,
        "September": 90
    },
    "transactions": [
        {
            "amount": 70.00,
            "transactionId": "SampleTrxId",
            "transactionDate": "2025-08-10",
            "pointsEarned": 20
        },
        {
            "amount": 120.00,
            "transactionId": "SampleTrxId2",
            "transactionDate": "2025-09-05",
            "pointsEarned": 90
        }
    ]
}
