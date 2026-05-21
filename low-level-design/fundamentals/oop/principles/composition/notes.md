# Composition vs Inheritance — Complete Notes

## Core Difference

| Inheritance | Composition |
|-------------|-------------|
| IS-A relationship | HAS-A relationship |
| Dog IS-A Animal | Car HAS-A Engine |

**Visual thinking:**

```
Inheritance          Composition
Animal               Car
  ↑                  ├── Engine
 Dog                 ├── Wheel
                     └── MusicSystem
```

---

## Why Inheritance Feels Attractive

Inheritance gives code reuse, hierarchy, and shared behavior. So beginners start using it everywhere. That becomes dangerous.

---

## The Big Problem with Inheritance

### Tight Coupling

Child becomes heavily dependent on parent. If parent changes, child may break unexpectedly. This is called the **Fragile Base Class Problem**.

**Bad example:**
```java
class Bird {
    void fly() {}
}

class Penguin extends Bird {}  // Penguins can't fly!
```

**Another bad example:**
```java
class Vehicle {
    void startEngine() {}
}

class Bicycle extends Vehicle {}  // Bicycle has no engine!
```

Inheritance assumes the child fully satisfies parent behavior. But real-world domains are messy.

---

## Composition Solves This

Instead of forcing hierarchy, we combine objects.

```java
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine;

    Car() {
        this.engine = new Engine();
    }

    void startCar() {
        engine.start();
    }
}
```

Car does NOT inherit Engine. Car USES Engine. That is composition.

**Real-world analogy:** A smartphone has a battery, camera, and speaker. It doesn't inherit them — it's composed of them.

---

## Why Composition is Powerful

### Flexibility

You can replace components, change behavior dynamically, and swap implementations. Inheritance is rigid.

**Gaming character example:**

Using inheritance gets messy fast: `Warrior`, `Mage`, `Archer`, `Knight`...

Using composition:
```
Character
├── Weapon
├── Armor
├── MovementStyle
└── AttackStrategy
```

Modular and scalable.

### Runtime Flexibility

```java
car.setEngine(new ElectricEngine());
```

Inheritance cannot do this easily — it's mostly fixed at compile time.

---

## Composition + Interfaces = Professional Design

```java
interface Engine {
    void start();
}

class PetrolEngine implements Engine {}
class ElectricEngine implements Engine {}

class Car {
    private Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }

    void start() {
        engine.start();
    }
}
```

Same `Car` class, multiple engine types, easy extensibility. This is composition, abstraction, and polymorphism working together.

---

## Tight Coupling vs Loose Coupling

**Inheritance** often causes tight coupling — child depends heavily on parent internals.

**Composition** encourages loose coupling — objects interact through contracts/interfaces.

---

## Notification System Example

**Bad inheritance-heavy design:**
```
Notification
    ↑
EmailNotification
    ↑
MarketingEmailNotification
    ↑
UrgentMarketingEmailNotification
```

Nightmare hierarchy.

**Better composition design:**
```
Notification
├── SenderStrategy
├── RetryPolicy
└── TemplateEngine
```

Much cleaner and scalable.

---

## Refactoring Example

**Bad:**
```java
class Bird {
    void fly() {}
}
class Penguin extends Bird {}  // wrong hierarchy
```

**Better:**
```java
interface FlyBehavior {
    void fly();
}

class CanFly implements FlyBehavior {
    public void fly() { System.out.println("Flying"); }
}

class CannotFly implements FlyBehavior {
    public void fly() { System.out.println("Cannot fly"); }
}

class Bird {
    private FlyBehavior flyBehavior;

    Bird(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    void performFly() {
        flyBehavior.fly();
    }
}
```

- `Sparrow` → `CanFly`
- `Penguin` → `CannotFly`

This is actually the foundation of the **Strategy Design Pattern**.

---

## Key Engineering Insight

**Inheritance answers:** What IS this object?

**Composition answers:** What CAN this object DO?

Modern systems care more about behavior, capabilities, and modularity. So composition often wins.

---

## When to Use Inheritance

- True hierarchy exists
- Behavior is genuinely shared
- Relationship is stable
- Substitution makes sense

Examples: `Dog IS-A Animal`, `Manager IS-A Employee`

---

## When to Use Composition

- Behaviors vary
- Runtime flexibility needed
- Modular design needed
- Avoiding rigid hierarchy
- Components can be swapped

Examples: `Car HAS-A Engine`, `User HAS-A Address`, `Phone HAS-A Camera`

---

## Famous Industry Principle

> **Favor Composition Over Inheritance**

Because composition reduces coupling, improves extensibility, and supports modular architecture. Used heavily in Spring, game engines, microservices, and enterprise systems.

---

## Composition is Foundation of Design Patterns

- Strategy Pattern
- Decorator Pattern
- Bridge Pattern

These patterns avoid rigid inheritance by composing behaviors.

---

## Real Industry Example — Uber

Uber doesn't create: `UberBikeTaxiPremiumSharedLuxuryVehicle`

Instead, pricing strategy, routing strategy, and driver assignment strategy are composed dynamically. That's scalable engineering.

---

## Interview Question

**Which is better — inheritance or composition?**

Wrong answer: "Composition always better."

Correct answer: Use inheritance for true IS-A relationships. Prefer composition when flexibility and modularity are needed.

---

## Cheat Sheet

```
Inheritance  → IS-A relationship, rigid hierarchy
Composition  → HAS-A relationship, modular behavior
Golden Rule  → Prefer composition over inheritance unless true hierarchy exists
```

---

## Practice Problems

**Beginner** — `Car HAS-A Engine` using composition

**Intermediate** — Bird system: flying birds and non-flying birds, avoid bad inheritance

**Advanced** — Game character with weapon strategy, movement strategy, attack strategy using composition

**Mini Challenge** — Would inheritance-heavy architecture scale well for a payment system, notification system, or ride booking system? Or would composition + interfaces work better? Why?
