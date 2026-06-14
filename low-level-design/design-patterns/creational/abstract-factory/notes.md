# Abstract Factory Pattern — Deep Dive

> "Provide an interface for creating **families of related objects** without specifying their concrete classes."

Factory Pattern creates **one** type of object. Abstract Factory creates **families of related objects** that are designed to work together. This is one of the most commonly misunderstood patterns in LLD interviews — the key word throughout is **family**.

---

## 1. Concept Introduction

### First Understand The Problem

Suppose you're building a UI framework. You need `Button`, `Checkbox`, `TextBox` — for both `Windows UI` and `Mac UI`.

Without Abstract Factory, the OS check leaks into every creation site:

```java
Button button;
if (os.equals("WINDOWS")) {
    button = new WindowsButton();
} else {
    button = new MacButton();
}

Checkbox checkbox;
if (os.equals("WINDOWS")) {
    checkbox = new WindowsCheckbox();
} else {
    checkbox = new MacCheckbox();
}

TextBox textbox;
if (os.equals("WINDOWS")) {
    textbox = new WindowsTextBox();
} else {
    textbox = new MacTextBox();
}
```

This logic ends up **everywhere**.

### Why Does Abstract Factory Exist?

Because we often need **a group of related objects that should work together**:

```
Windows Button + Windows Checkbox + Windows TextBox
```

or

```
Mac Button + Mac Checkbox + Mac TextBox
```

We must **never** end up with a mixed family:

```
Windows Button + Mac Checkbox + Windows TextBox   ✗
```

---

## 2. Real-World Analogy

### Furniture Store

A furniture company sells collections:

- **Modern Collection** — Modern Chair, Modern Sofa, Modern Table
- **Victorian Collection** — Victorian Chair, Victorian Sofa, Victorian Table

The customer chooses *"Modern"* and receives matching furniture. They do **not** individually assemble Modern Chair + Victorian Sofa + Modern Table — that would look terrible.

> Abstract Factory ensures objects belong to the **same family**.

---

## 3. Theory

### Factory Pattern — creates **one** product

```java
VehicleFactory.createVehicle()
```

### Abstract Factory Pattern — creates a **family** of products

```java
GUIFactory.createButton()
GUIFactory.createCheckbox()
GUIFactory.createTextBox()
```

---

## 4. Visual Thinking

**Factory Pattern** — one method, many product variants:

```
VehicleFactory
    |
    +--> Car
    +--> Bike
    +--> Truck
```

**Abstract Factory** — one factory per family, each producing the whole set:

```
WindowsFactory                 MacFactory
     |                              |
     +--> WindowsButton            +--> MacButton
     +--> WindowsCheckbox          +--> MacCheckbox
     +--> WindowsTextBox           +--> MacTextBox
```

---

## 5. UML

```
                   GUIFactory
                 +---------------+
                 | createButton  |
                 | createCheckbox|
                 +---------------+
                       ▲
             ┌─────────┴─────────┐
             │                   │
       WindowsFactory         MacFactory
             │                   │
     WindowsButton          MacButton
     WindowsCheckbox        MacCheckbox
```

---

## 6. Code Implementation

### Product Interfaces

```java
public interface Button {
    void render();
}

public interface Checkbox {
    void render();
}
```

### Windows Products

```java
public class WindowsButton implements Button {
    @Override
    public void render() { System.out.println("Windows Button"); }
}

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() { System.out.println("Windows Checkbox"); }
}
```

### Mac Products

```java
public class MacButton implements Button {
    @Override
    public void render() { System.out.println("Mac Button"); }
}

public class MacCheckbox implements Checkbox {
    @Override
    public void render() { System.out.println("Mac Checkbox"); }
}
```

### Abstract Factory Interface

```java
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

### Concrete Factories

```java
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() { return new WindowsButton(); }
    @Override
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() { return new MacButton(); }
    @Override
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}
```

### Client

```java
public class Application {

    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button   = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }
}
```

Notice: `Application` does **not** know `WindowsButton`, `MacButton`, `WindowsCheckbox`, or `MacCheckbox` — only the interfaces.

---

## 7. How Creation Happens

```java
GUIFactory factory = new WindowsFactory();
Application app = new Application(factory);
```

Creates `WindowsButton` + `WindowsCheckbox` automatically. Change one line:

```java
GUIFactory factory = new MacFactory();
```

The **entire application switches family** — no client code changes.

---

## 8. Bad Design vs Good Design

**Bad** — repeated `if (os...)` at every creation site:

```java
if (os.equals("WINDOWS")) { new WindowsButton(); }
if (os.equals("WINDOWS")) { new WindowsCheckbox(); }
```

**Good** — everything comes from one place:

```java
GUIFactory factory = new WindowsFactory();
```

---

## 9. Real Industry Examples

**Database Drivers** — MySQL / PostgreSQL / Oracle each provide a family: `Connection`, `Statement`, `TransactionManager`.

**Cloud Providers** — AWS (`S3`, `SQS`, `SNS`) vs Azure (`Blob Storage`, `Service Bus`, `Notification Hub`). One factory creates related services together.

**Payment Ecosystem** — Stripe family vs PayPal family, each with `PaymentProcessor`, `RefundProcessor`, `SubscriptionProcessor`.

---

## 10. Interview Perspective

**Difference between Factory and Abstract Factory?**

| | Creates | Example |
|---|---|---|
| **Factory** | One product | `VehicleFactory.createVehicle()` |
| **Abstract Factory** | A family of related products | `GUIFactory.createButton()` + `createCheckbox()` + `createTextBox()` |

**Cheat line:**

> Factory creates an object. Abstract Factory creates a **family** of related objects.

That one sentence alone impresses interviewers.

---

## 11. SOLID Principles

- **OCP** — add a new family (`LinuxFactory`) without changing client code.
- **DIP** — client depends only on `GUIFactory`, `Button`, `Checkbox` interfaces — never concrete classes.

---

## 12. Real Engineering Perspective — Advantages

- **Family Consistency** — prevents mixing Windows Button with Mac Checkbox.
- **Loose Coupling** — client doesn't know concrete classes.
- **Easy Platform Switching** — swap `WindowsFactory` → `MacFactory` without touching business code.
- **Testability** — mock the factory and its products for easy testing.

---

## 13. Drawbacks

- **More Classes** — `Button` × `Checkbox` × `TextBox` over `Windows` × `Mac` × `Linux` creates many classes.
- **Complexity** — overkill for small systems.

---

## 14. LLD Example

An e-commerce platform's payment layer:

- **Stripe Family** — `StripePayment`, `StripeRefund`, `StripeSubscription`
- **PayPal Family** — `PayPalPayment`, `PayPalRefund`, `PayPalSubscription`

`PaymentFactory` creates the complete payment ecosystem. Very common interview discussion.

---

## 15. Practice Problems

**Beginner**
- Furniture Factory — Chair / Table over Modern / Victorian → `practice-problems/furniture-factory`

**Intermediate**
- Notification Provider — Email / SMS sender over AWS / Azure → `practice-problems/notification-provider`

**Advanced**
- Cloud Provider SDK — Storage / Queue / Notification over AWS / Azure / GCP → `practice-problems/cloud-provider-sdk`

---

## 16. Mini Project — Food Delivery App

→ `practice-problems/food-delivery-app`

Families: **Swiggy Integration** and **Zomato Integration**, each providing `OrderService`, `PaymentService`, `DeliveryService`.

`PartnerFactory` returns a **complete partner ecosystem** — this is exactly where Abstract Factory shines.

---

## 17. Revision Summary (Cheat Sheet)

**Factory Pattern** — creates ONE object: `VehicleFactory.createVehicle()`

**Abstract Factory Pattern** — creates a FAMILY of objects: `GUIFactory` → `Button` + `Checkbox` + `TextBox`

**Components**
- Abstract Products
- Concrete Products
- Abstract Factory
- Concrete Factories
- Client

**Advantages**
- Loose coupling
- Family consistency
- Easy extension
- OCP
- DIP

**Disadvantages**
- Many classes
- More complexity
- Overkill for simple apps

### Common Interview Trap

> *"We have `CarFactory`, `BikeFactory`, `TruckFactory`. Is this Abstract Factory?"*

**Not necessarily.** That's usually just multiple Factory classes.

It becomes Abstract Factory only when a factory creates a **family of related objects**:

```
TeslaFactory:        BMWFactory:
   Battery              Battery
   Motor                Motor
   Dashboard            Dashboard
```

Each factory produces a complete related ecosystem.

**Rule of thumb:** Factory controls *which object*; Abstract Factory controls *which family*.
