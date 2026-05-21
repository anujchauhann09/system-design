# Polymorphism — Complete Notes

## What is Polymorphism?

One interface, many forms.

> Same operation. Different behavior.

---

## Real-World Analogies

**Payment** — You click "Pay ₹1000". UPI, Credit Card, and Wallet all behave differently internally, but you perform the same action: `pay()`.

**Remote Control** — You press ON. TV turns on, AC starts cooling, Speaker starts audio. Same command. Different behavior.

---

## Why Polymorphism Exists

Without polymorphism:
```java
if (paymentType.equals("UPI")) { }
else if (paymentType.equals("CARD")) { }
else if (paymentType.equals("WALLET")) { }
```

This becomes ugly, hard to maintain, hard to extend, and violates clean design. Polymorphism removes this mess.

---

## Types of Polymorphism in Java

### Compile-Time Polymorphism (Method Overloading)

Same method name, different parameters. Compiler decides which method to call during compilation.

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

```java
calc.add(2, 3);
calc.add(2, 3, 4);
```

Real-world example: `search()` could mean search by name, by ID, or by email — different inputs, same operation idea.

---

### Runtime Polymorphism (Method Overriding)

This is the real powerful one.

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}
```

**The magic:**
```java
Animal animal = new Dog();
animal.sound(); // Output: Bark
```

Reference type is `Animal`, actual object is `Dog`, but Dog's method runs. Java decides the method at **runtime**.

---

## Dynamic Method Dispatch

This mechanism is called **Dynamic Method Dispatch**.

```java
Animal animal = new Dog();
```

At runtime, JVM checks: actual object type = `Dog`, then calls `Dog.sound()`.

**Memory thinking:**
```
Reference Type → Animal
Object Type    → Dog

Compile time checks: reference type
Runtime execution uses: actual object type
```

---

## Why This is So Powerful

**Without polymorphism:**
```java
if (type.equals("EMAIL")) {}
if (type.equals("SMS")) {}
if (type.equals("PUSH")) {}
```

**Using polymorphism:**
```java
interface NotificationSender {
    void send();
}

NotificationSender sender = new EmailSender();
sender.send();
```

No if-else chaos. This is professional engineering.

---

## Real Industry Example — Payment Gateway

```
PaymentMethod
      ↑
--------------------------
↑           ↑           ↑
UPI     CreditCard    Wallet
```

`OrderService` simply does:
```java
payment.pay(amount);
```

No need to care which payment type. System becomes extensible, maintainable, scalable.

---

## Polymorphism + Abstraction

Polymorphism works beautifully with interfaces and abstract classes.

```java
PaymentMethod payment = new UpiPayment();
```

`payment` could refer to `UpiPayment`, `CardPayment`, or `WalletPayment`. Upper layer depends on abstraction. This is the foundation of Clean Architecture, SOLID, and Dependency Injection.

---

## Open/Closed Principle Connection

Polymorphism helps achieve: **open for extension, closed for modification**.

Add `CryptoPayment` — no need to modify existing payment flow. Just add a new implementation. That's a huge scalability advantage.

---

## Program to Interfaces, Not Implementations

One of the most important OOP lines:

**Bad:**
```java
Dog dog = new Dog();
```

**Better:**
```java
Animal animal = new Dog();
// or
PaymentMethod payment = new UpiPayment();
```

This creates flexibility.

---

## Refactoring Example

**Bad design:**
```java
class ReportGenerator {
    void generate(String type) {
        if (type.equals("PDF")) { }
        else if (type.equals("EXCEL")) { }
    }
}
```

**Good design:**
```java
interface ReportGenerator {
    void generate();
}

class PdfReportGenerator implements ReportGenerator {}
class ExcelReportGenerator implements ReportGenerator {}
```

Now extensible — add new report types without touching existing code.

---

## Common Beginner Mistakes

**Mistake 1** — Thinking polymorphism = only overriding. The core idea is same interface, different behavior.

**Mistake 2** — Using giant if-else instead of polymorphism.

**Mistake 3** — Overusing inheritance for polymorphism. Interfaces are often better. Modern systems heavily prefer interfaces and composition.

---

## Real Framework Usage

Spring injects different implementations dynamically:

```java
PaymentService service;
// could receive StripePaymentService or RazorpayPaymentService
// without changing upper-layer code
```

That's real-world polymorphism.

---

## Polymorphism Reduces Coupling

Upper systems depend on contracts/interfaces, not concrete implementations. This allows:
- Independent evolution
- Easier testing
- Mocking
- Plugin architectures

---

## Interview Questions

**Q: What is polymorphism?**
Polymorphism allows the same interface or method call to behave differently depending on the actual object.

**Q: Types of polymorphism?**
Compile-time (overloading) and runtime (overriding).

**Q: Why is runtime polymorphism important?**
Flexibility, extensibility, loose coupling, scalable architectures.

---

## Cheat Sheet

```
Overloading          → same method, different parameters (compile-time)
Overriding           → child changes parent behavior (runtime)
Runtime polymorphism → method resolved at runtime based on actual object
```

---

## Practice Problems

**Beginner** — `Animal`, `Dog`, `Cat`, override `sound()`

**Intermediate** — `PaymentMethod` interface, `UPI`, `CreditCard`, `Wallet`, use polymorphism

**Advanced** — Notification system, Report generator, Storage service using interfaces + polymorphism

**Mini Challenge** — Tomorrow your app adds WhatsApp, Push, and Slack notifications. Would polymorphism make the system easier to extend? Why?
