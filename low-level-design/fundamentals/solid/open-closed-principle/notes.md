# Open/Closed Principle (OCP)

## Simple Definition

Software entities should be:
- **Open for Extension**
- **Closed for Modification**

> Add new behavior WITHOUT changing existing stable code.

---

## Why OCP Exists

In real companies, features constantly evolve, new requirements keep coming, and integrations change. If every new feature requires modifying old code — bugs increase, regression issues appear, and deployments become risky. OCP reduces this danger.

**Real-world analogy:** A phone socket remains stable. New chargers can still be added. The system is designed for extension while the existing design remains unchanged.

---

## Bad Design (Violating OCP)

```java
class PaymentService {
    void pay(String type) {
        if (type.equals("UPI")) {
            System.out.println("UPI Payment");
        } else if (type.equals("CARD")) {
            System.out.println("Card Payment");
        }
    }
}
```

Tomorrow business says: add Wallet, Crypto, Net Banking. You keep adding `else if` blocks. Every modification risks breaking existing logic, introducing bugs, and causing regression issues.

---

## OCP-Compliant Design

**Step 1 — Create interface:**
```java
interface PaymentMethod {
    void pay(double amount);
}
```

**Step 2 — Create implementations:**
```java
class UpiPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("UPI Payment");
    }
}

class CardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Card Payment");
    }
}
```

**Step 3 — Use abstraction:**
```java
class PaymentService {
    void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}
```

Adding `CryptoPayment` now requires zero changes to existing code — just add a new class.

---

## Visual Thinking

**Bad design:**
```
PaymentService
├── if UPI
├── if CARD
├── if WALLET
├── if CRYPTO
└── keeps growing (rigid)
```

**Good design:**
```
PaymentMethod
      ↑
-------------------------
↑           ↑           ↑
UPI        CARD       WALLET  (extensible)
```

---

## OCP Minimizes Stable Code Changes

Stable production code should rarely change. Instead, add new modules, new implementations, and plug new behavior. Companies like Netflix or Amazon cannot constantly modify core stable systems — millions of users depend on them and bugs are expensive.

---

## Plugin Architecture

An IDE supports plugins. Core IDE remains unchanged. New plugins (Git, Docker, AI) are added without touching the core. That's OCP in real life.

---

## Refactoring Example

**Bad:**
```java
class ReportGenerator {
    void generate(String type) {
        if (type.equals("PDF")) {}
        else if (type.equals("EXCEL")) {}
    }
}
```

**Good:**
```java
interface ReportGenerator {
    void generate();
}

class PdfReportGenerator implements ReportGenerator {}
class ExcelReportGenerator implements ReportGenerator {}
```

---

## Real Backend Example — Discounts

**Bad:**
```java
if (customerType.equals("PREMIUM")) {}
else if (customerType.equals("NEW")) {}
else if (customerType.equals("FESTIVAL")) {}
```

**Better:**
```java
interface DiscountStrategy {
    double applyDiscount(double price);
}

class PremiumDiscount implements DiscountStrategy {}
class FestivalDiscount implements DiscountStrategy {}
class NewUserDiscount implements DiscountStrategy {}
```

This is OCP + Strategy Pattern working together.

---

## OCP + Testing

Use fake implementations for testing:
```java
class FakePayment implements PaymentMethod {}
```

Testing becomes easy without touching real implementations.

---

## Common Beginner Mistakes

**Mistake 1** — Thinking every if-else violates OCP. Small/simple logic is fine. Don't overengineer.

**Bad overengineering:**
```
IUniversalFuturePaymentProviderManager
```

**Rule:** Apply OCP where variation is expected and extension is likely.

**Mistake 2** — Creating inheritance-heavy designs. Modern systems prefer interfaces, composition, and strategies instead of rigid hierarchies.

---

## Stable vs Changing Parts

Professional engineers identify what changes frequently — those parts become abstractions, strategies, or plugins. Stable parts remain unchanged.

**Uber pricing example:** Surge pricing, festival pricing, dynamic pricing — instead of giant if-else, they use pluggable pricing strategies. Classic OCP.

---

## Interview Questions

**Q: What is OCP?**
Software entities should be open for extension but closed for modification — new behavior should be added without changing stable existing code.

**Q: How is OCP achieved?**
Using abstraction, interfaces, polymorphism, and composition.

---

## Red Flags

- Huge if-else chains
- Switch explosions
- Constant modifications to existing classes
- Rigid code that breaks on every new feature

---

## Cheat Sheet

```
BAD:  if (type == X) else if (type == Y)
GOOD: interface + polymorphism
```

---

## Practice Problems

**Beginner** — Refactor shape calculator for Circle, Rectangle, Triangle without giant if-else

**Intermediate** — Notification system for Email, SMS, Push using OCP

**Advanced** — Pricing engine with surge pricing, coupon pricing, festival pricing using strategies

**Mini Challenge** — Tomorrow business adds WhatsApp, Slack, Discord notifications. Would your existing notification system require modifying old code? If yes, OCP is violated. How would you redesign?
