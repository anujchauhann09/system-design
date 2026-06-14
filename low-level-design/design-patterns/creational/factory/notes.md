# Factory Pattern — Deep Dive

> "Define an interface for creating an object, but let a factory decide which concrete class to instantiate."

After Singleton, Factory is the next most important **Creational Pattern**. Where Singleton controls *how many* objects exist, Factory controls *who creates* them — moving the `new` out of your business logic and into one dedicated place.

---

## 1. Concept Introduction

### Simple Explanation

Factory Pattern means:

> Instead of creating objects using `new`, delegate object creation to a **Factory**.

Instead of:

```java
Vehicle vehicle = new Car();
```

we do:

```java
Vehicle vehicle = VehicleFactory.createVehicle("CAR");
```

The factory decides which object to create.

### Why Does It Exist?

Imagine an application supports `Car`, `Bike`, `Truck`, `Bus`, `Auto`. Without a factory, this leaks everywhere:

```java
if (type.equals("CAR")) {
    return new Car();
} else if (type.equals("BIKE")) {
    return new Bike();
} else if (type.equals("TRUCK")) {
    return new Truck();
}
```

...copy-pasted into every file that needs a vehicle.

Problems:

- Duplicate object-creation logic
- Tight coupling to concrete classes
- Difficult maintenance
- Hard to add new types

Factory **centralizes** object creation.

---

## 2. Real-World Analogy

### Restaurant

A customer says *"I want Pizza."* The customer does **not**:

- Create dough
- Add cheese
- Bake
- Package

The kitchen handles creation.

```
Customer
    ↓
Order Counter
    ↓
Kitchen (Factory)
    ↓
Pizza
```

The factory works exactly like the kitchen — you order by name, it builds and hands back the finished product.

---

## 3. Theory

### Definition

> Defines an interface or method for creating objects while allowing a factory class (or subclass) to decide which concrete object to instantiate.

### Main Goal

Separate **object creation** from **object usage**.

The client codes against an abstraction (`Vehicle`) and never names a concrete class.

---

## 4. Problem Before Factory

Suppose we build a **Notification System**.

### Bad Design

```java
class NotificationService {
    public void send(String type) {
        if (type.equals("EMAIL")) {
            EmailNotification email = new EmailNotification();
            email.send();
        } else if (type.equals("SMS")) {
            SmsNotification sms = new SmsNotification();
            sms.send();
        }
    }
}
```

### Problems

**Violation of OCP** — adding Push means editing this method:

```java
else if (type.equals("PUSH")) ...
```

**Tight Coupling** — the service knows the concrete classes `EmailNotification`, `SmsNotification`.

**Hard Testing** — many baked-in dependencies, nothing to mock.

---

## 5. Refactoring Using Factory Pattern

### Step 1: Common Interface

```java
public interface Notification {
    void send();
}
```

### Step 2: Concrete Implementations

```java
public class EmailNotification implements Notification {
    @Override
    public void send() { System.out.println("Email Sent"); }
}

public class SmsNotification implements Notification {
    @Override
    public void send() { System.out.println("SMS Sent"); }
}

public class PushNotification implements Notification {
    @Override
    public void send() { System.out.println("Push Sent"); }
}
```

### Step 3: Factory Class

```java
public class NotificationFactory {
    public static Notification createNotification(String type) {
        switch (type) {
            case "EMAIL": return new EmailNotification();
            case "SMS":   return new SmsNotification();
            case "PUSH":  return new PushNotification();
            default:
                throw new IllegalArgumentException("Invalid Type");
        }
    }
}
```

### Step 4: Client

```java
Notification notification = NotificationFactory.createNotification("EMAIL");
notification.send();
```

The client never knows which concrete class was created.

---

## 6. Visual Thinking

**Without Factory** — client depends on everything:

```
Client
  ├── new EmailNotification()
  ├── new SmsNotification()
  └── new PushNotification()
```

**With Factory** — client depends only on the factory:

```
Client
   │
   ▼
NotificationFactory
   │
   ├── EmailNotification
   ├── SmsNotification
   └── PushNotification
```

---

## 7. UML

```
                +----------------+
                | Notification   |
                +----------------+
                | +send()        |
                +----------------+
                        ▲
          ┌─────────────┼─────────────┐
          │             │             │
          ▼             ▼             ▼
+----------------+ +---------------+ +---------------+
| EmailNotif     | | SmsNotif      | | PushNotif     |
+----------------+ +---------------+ +---------------+

            ^
            |
+-------------------------+
| NotificationFactory     |
+-------------------------+
| createNotification()    |
+-------------------------+
```

---

## 8. Real Industry Example — Payment Gateway

Suppose: `Razorpay`, `Stripe`, `PayPal`.

Without Factory, this is scattered everywhere:

```java
new StripePayment();
new RazorpayPayment();
new PaypalPayment();
```

Using Factory:

```java
Payment payment = PaymentFactory.create("STRIPE");
```

Cleaner, and the choice lives in exactly one place.

---

## 9. Factory + Dependency Inversion

Factory pairs naturally with DIP. Define the abstraction:

```java
public interface PaymentGateway {
    void pay();
}
```

Implementations: `StripeGateway`, `PaypalGateway`, `RazorpayGateway`.

```java
PaymentGateway gateway = Factory.create("STRIPE");
```

The client only knows `PaymentGateway` — never the concrete classes.

---

## 10. Interview Perspective

**Why Factory?**
- Encapsulates object creation
- Reduces coupling
- Improves maintainability
- Supports OCP

**Difference between Singleton and Factory?**

| | Question it answers | Responsibility |
|---|---|---|
| **Singleton** | *How many objects?* | Exactly one |
| **Factory** | *Who creates objects?* | The factory creates them |

Completely different purposes.

**Does Factory create one object?** Not necessarily — a factory may create 1, 10, or 1000 objects. **Singleton controls the count; Factory controls creation.**

---

## 11. Real-World Engineering Perspective

- **Centralized Creation Logic** — one place to manage creation
- **Loose Coupling** — clients depend on an abstraction
- **Easier Extension** — add new implementations without touching callers
- **Cleaner Code** — no scattered `new` operators

---

## 12. Limitations

A factory can degrade into a **God Factory**:

```java
Factory.createVehicle()
Factory.createUser()
Factory.createOrder()
Factory.createPayment()
Factory.createInvoice()
```

One giant class doing everything — avoid it. Split by domain instead:

```
VehicleFactory
PaymentFactory
NotificationFactory
```

Also note the classic `switch`-based factory still **violates OCP** (every new type edits the method). When the type set grows or comes from plugins, prefer a **registry-based factory** — see the Cloud Storage problem below.

---

## 13. Practice Problems

**Beginner**
- Shape (Circle / Rectangle / Square) → `practice-problems/shape-factory`

**Intermediate**
- Payment Gateway (Stripe / PayPal / Razorpay) → `practice-problems/payment-gateway-factory`

**Advanced**
- Cloud Storage (S3 / GCS / Azure Blob) → `practice-problems/cloud-storage-factory`
  - *How will you add new providers?* — new class + one `register()` call.
  - *How will you avoid modifying factory code repeatedly?* — use a **registry** (`Map<String, Supplier<T>>`) instead of a `switch`, so adding a provider mutates data, not the factory class (OCP-compliant). `ServiceLoader` / DI scanning can even make registration automatic.

---

## 14. Mini Project — Vehicle Rental System

→ `practice-problems/vehicle-rental-system`

Support: `Bike`, `Car`, `Truck`.

- Design: `Vehicle` interface
- Implement: `Bike`, `Car`, `Truck`
- Use: `VehicleFactory` to create vehicles

Later this project extends using:

- **Strategy Pattern** (pricing)
- **Observer Pattern** (notifications)
- **Builder Pattern** (vehicle configuration)

which is how real LLD systems evolve.

---

## 15. Revision Summary (Cheat Sheet)

**Purpose**
- Encapsulate object creation

**Components**
- Product Interface
- Concrete Products
- Factory
- Client

**Advantages**
- Loose coupling
- Centralized creation
- Cleaner code
- Supports OCP
- Easy maintenance

**Disadvantages**
- Extra abstraction
- Factory can become huge (God Factory)
- `switch`-based factory needs modification when adding types (use a registry to avoid this)

**Common Examples**
- Notification Factory
- Payment Factory
- Vehicle Factory
- Document Factory
- Storage Factory
- Parser Factory

**Factory vs Singleton:** Singleton controls *how many*; Factory controls *who creates*.
