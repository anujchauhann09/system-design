# Single Responsibility Principle (SRP)

## Simple Definition

A class should have only **one reason to change**.

> One class = One responsibility

**Important clarification:** Responsibility does NOT mean one method. It means one business purpose.

---

## Real-World Analogy — Restaurant

- **Chef** → cook food
- **Cashier** → handle payments
- **Waiter** → serve customers

If the chef also handles billing, cleans tables, and manages inventory — everything becomes messy. Same in software.

---

## Why SRP Exists

Without SRP, classes become **GOD CLASSES** — huge classes doing everything. These become hard to maintain, hard to debug, hard to test, and tightly coupled.

**Bad design:**
```java
class UserService {
    void registerUser() {}
    void sendEmail() {}
    void saveToDatabase() {}
    void generateReport() {}
    void processPayment() {}
}
```

This class has multiple responsibilities: user management, email handling, database operations, report generation, payment processing.

**Why this becomes dangerous:** If email logic changes, you modify `UserService`. Now a payment bug can accidentally be introduced, testing becomes huge, and deployments become risky.

---

## Proper SRP Design

```java
class UserService    { void registerUser() {} }
class EmailService   { void sendEmail() {} }
class PaymentService { void processPayment() {} }
class ReportService  { void generateReport() {} }
```

Each class has a clear purpose. Changes stay isolated.

---

## SRP Reduces Ripple Effects

**Without SRP:**
```
Small change → Huge side effects
```

**With SRP:**
```
Small change → Localized impact
```

This is huge in enterprise systems.

---

## Cohesion

SRP improves **high cohesion** — related functionality stays together.

**Good cohesion:**
```
PaymentService
├── validatePayment()
├── processPayment()
└── refundPayment()
```

All methods relate to payment.

**Bad cohesion:**
```
UserManager
├── login()
├── generateInvoice()
├── uploadImage()
└── calculateTax()
```

Unrelated responsibilities mixed together.

---

## Real-World Example — E-Commerce

**Bad:**
```java
class OrderManager {
    void createOrder() {}
    void sendConfirmationEmail() {}
    void processPayment() {}
    void printInvoice() {}
    void updateInventory() {}
}
```

**Better:**
```
OrderService
PaymentService
InventoryService
EmailService
InvoiceService
```

Each focused on one responsibility.

---

## Easier Testing

If `PaymentService` has a bug and SRP is followed — test payment independently. Without SRP, giant setup is required and unrelated systems are affected. SRP dramatically improves unit testing, debugging, and maintainability.

---

## SRP & Team Scalability

In large companies, multiple teams work simultaneously. Without SRP, developers constantly conflict. With SRP, teams can work independently. Very important real-world advantage.

---

## Common Beginner Mistakes

**Mistake 1** — Thinking one method = one class. That's overengineering. SRP means one responsibility, not microscopic classes.

**Mistake 2** — Creating utility god classes:
```java
class CommonUtils {
    // email logic
    // file logic
    // tax logic
    // validation logic
}
```

**Mistake 3** — Putting everything inside controller/service:
```java
class UserController {
    // validation
    // payment
    // email
    // database
    // logging
}
```

Controllers become gigantic.

---

## Real Industry Architecture

Modern backend systems separate layers:
```
Controller Layer
      ↓
Service Layer
      ↓
Repository Layer
```

Each layer has focused responsibility. This comes from SRP thinking.

---

## Refactoring Example

**Bad:**
```java
class InvoiceService {
    void calculateInvoice() {}
    void printInvoice() {}
    void saveInvoiceToDB() {}
}
```

Multiple responsibilities: business logic, printing, persistence.

**Better:**
```java
class InvoiceCalculator  {}
class InvoicePrinter     {}
class InvoiceRepository  {}
```

---

## "Reason to Change" — Key Phrase

Ask: why would this class change?

If the answer contains multiple unrelated reasons — SRP is likely violated.

**Example:**
```
InvoiceService changes because:
- invoice formula changes
- database changes
- PDF format changes
```

Three reasons. Bad SRP.

---

## SRP and Microservices

Microservices are large-scale SRP. Each service handles a focused business capability:
- payment service
- user service
- notification service

---

## Interview Questions

**Q: What is SRP?**
A class should have only one reason to change, meaning it should focus on a single responsibility or business concern.

**Q: Why is SRP important?**
Easier maintenance, easier testing, reduced coupling, fewer side effects, better scalability.

---

## Red Flags

- Huge classes
- Too many unrelated methods
- God objects
- Massive controllers/services

---

## Cheat Sheet

```
SRP: focused responsibility
Bad: UserService does everything
Good: UserService + EmailService + PaymentService
```

---

## Practice Problems

**Beginner** — Refactor `StudentManager` containing `saveStudent()`, `sendEmail()`, `generateReport()`

**Intermediate** — Design `OrderService`, `PaymentService`, `InventoryService` with separate responsibilities

**Advanced** — Take any mini-project (ATM, Parking Lot, Food Delivery) and identify possible SRP violations

**Mini Challenge** — `ReportService` generates PDF, saves to DB, sends email, uploads to cloud. How many responsibilities exist? How would you refactor?
