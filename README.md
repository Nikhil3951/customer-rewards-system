# Customer Rewards System

## Overview
The **Customer Rewards System** is a RESTful Spring Boot application that calculates rewards points for customers based on their transactions.  

**Reward Rules:**
- **2 points** for every dollar spent **over $100** per transaction.  
- **1 point** for every dollar spent **between $50 and $100** per transaction.  

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

## Project Structure

