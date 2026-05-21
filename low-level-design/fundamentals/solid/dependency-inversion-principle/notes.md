# Dependency Inversion Principle (DIP)

## Simple Definition

- High-level modules should not depend on low-level modules.
- Both should depend on abstractions.
- Abstractions should not depend on details.
- Details should depend on abstractions.

> Business logic should NOT depend directly on concrete implementations. Both should depend on interfaces/contracts.

---

## Real-World Analogy

TV, Laptop, Washing Machine all connect to a standard power socket. Appliances do NOT directly depend on the internal wiring of the power station — they depend on an abstraction (socket standard). This gives flexibility. That's DIP.

---

## Why DIP Exists

Without DIP, systems become tightly coupled, hard to test, hard to extend, and hard to maintain. DIP reduces coupling dramatically.

---

## Bad Design (Violating DIP)

```java
class EmailService {
    void sendEmail(String message) {
        System.out.println("Sending email");
    }
}

class NotificationManager {
    private EmailService emailService;

    NotificationManager() {
        emailService = new EmailService(); // direct dependency
    }

    void notifyUser() {
        emailService.sendEmail("Hello");
    }
}
```

High-level module `NotificationManager` depends directly on concrete class `EmailService`. Tomorrow when SMS, WhatsApp, or Push is needed — `NotificationManager` must change. Testing is also painful because you can't replace `EmailService` easily.

---

## Proper DIP Design

**Step 1 — Create interface:**
```java
interface MessageService {
    void sendMessage(String message);
}
```

**Step 2 — Implementations:**
```java
class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending Email");
    }
}

class SmsService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending SMS");
    }
}
```

**Step 3 — High-level module depends on abstraction:**
```java
class NotificationManager {
    private MessageService messageService;

    NotificationManager(MessageService messageService) {
        this.messageService = messageService;
    }

    void notifyUser() {
        messageService.sendMessage("Hello");
    }
}
```

`NotificationManager` doesn't care if it's Email, SMS, WhatsApp, or Push — it only cares about the `MessageService` contract.

---

## Visual Thinking

**Bad design:**
```
NotificationManager
        ↓
   EmailService  (tightly coupled)
```

**Good design:**
```
NotificationManager
        ↓
  MessageService
        ↑
---------------------
↑         ↑         ↑
Email    SMS      Push  (flexible)
```

---

## DIP + Dependency Injection

DIP naturally leads to **Dependency Injection (DI)**.

**Bad — object creates its own dependency:**
```java
emailService = new EmailService();
```

**Good — dependency comes from outside:**
```java
NotificationManager(MessageService service)
```

This is constructor injection. Modern frameworks heavily use this.

---

## Real Framework Example — Spring

Spring is built around DIP and dependency injection. Spring injects dependencies automatically:

```java
@Autowired
MessageService service;
```

Framework provides the implementation dynamically. That's why Spring is flexible.

---

## Real Industry Example — Payment Gateway

`OrderService` depending directly on `RazorpayService` breaks when Stripe, PayPal, or Cashfree is needed.

**Better:**
```java
interface PaymentGateway {}

class RazorpayGateway implements PaymentGateway {}
class StripeGateway    implements PaymentGateway {}
class PaypalGateway    implements PaymentGateway {}
```

`OrderService` stays stable. Beautiful scalable architecture.

---

## DIP + Testing

Use fake implementations for testing:
```java
class FakePaymentGateway implements PaymentGateway {}
```

Testing becomes easy. Without DIP, testing real payment systems becomes a nightmare.

---

## DIP Reverses Dependency Direction

**Normally:**
```
Business Logic
      ↓
Low-level details
```

**With DIP:**
```
Both depend on abstraction
```

This inversion is why it's called the Dependency Inversion Principle.

---

## Refactoring Example

**Bad:**
```java
class ReportService {
    PdfGenerator generator = new PdfGenerator();
}
```

**Good:**
```java
interface ReportGenerator {
    void generate();
}

class PdfGenerator   implements ReportGenerator {}
class ExcelGenerator implements ReportGenerator {}

class ReportService {
    private ReportGenerator generator;

    ReportService(ReportGenerator generator) {
        this.generator = generator;
    }
}
```

---

## Cloud Provider Example

Application should NOT directly depend on AWS SDK, Azure SDK, or GCP SDK. Instead:

```java
interface CloudStorage {}
```

This avoids vendor lock-in. Huge real-world architecture advantage.

---

## How SOLID Connects

- **SRP** — Focused responsibility
- **OCP** — Extensible systems
- **LSP** — Correct substitution
- **ISP** — Focused interfaces
- **DIP** — Depend on abstractions, not concrete details

All five reduce complexity and coupling. DIP completes SOLID.

---

## Common Beginner Mistakes

**Mistake 1** — Creating interfaces for everything. Not every class needs abstraction. Use DIP where variability exists and flexibility matters.

**Mistake 2** — Confusing DI with DIP. DI is a tool. DIP is a principle. DIP is the architectural principle; DI is the technique for supplying dependencies.

**Mistake 3** — Using `new` everywhere inside business classes:
```java
PaymentService payment = new RazorpayService();
```

This tightly couples the system.

---

## Interview Questions

**Q: What is DIP?**
High-level modules should not depend on low-level modules. Both should depend on abstractions.

**Q: Why is DIP important?**
Loose coupling, easier testing, extensibility, maintainability, scalable architecture.

**Q: How is DIP achieved?**
Using interfaces, abstraction, and dependency injection.

---

## Red Flags

- `new` inside business logic
- Tight coupling to concrete classes
- Hardcoded dependencies

---

## Cheat Sheet

```
BAD:  OrderService → RazorpayService
GOOD: OrderService → PaymentGateway
```

---

## Practice Problems

**Beginner** — Refactor `NotificationManager` + `EmailService` using DIP

**Intermediate** — Design `PaymentGateway` abstraction with multiple payment providers

**Advanced** — Design storage system for AWS, Azure, GCP using DIP + OCP

**Mini Challenge** — Code contains:
```java
class UserService {
    MySQLDatabase db = new MySQLDatabase();
}
```
What problem exists? Which SOLID principle is violated? How would you redesign?
