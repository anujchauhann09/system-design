# Interface Segregation Principle (ISP)

## Simple Definition

Clients should NOT be forced to implement interfaces they don't need.

> Prefer small focused interfaces over giant "god interfaces".

---

## Easier Meaning

Suppose an interface contains `eat()`, `fly()`, `swim()`, `run()`. Now Fish is forced to implement `fly()` and Penguin is forced to implement `fly()`. Bad design. That violates ISP.

**Real-world analogy:** A restaurant forces every customer to order Pizza + Sushi + Burger + Ice Cream even if they only want pizza. Similarly, classes should only depend on methods they actually need.

---

## Why ISP Exists

Large interfaces become rigid, hard to maintain, difficult to extend, and full of unused methods. This creates tight coupling, unnecessary dependencies, and messy implementations.

---

## Bad Design Example

```java
interface Worker {
    void work();
    void eat();
    void sleep();
}
```

`HumanWorker` — fine, implements all three.

```java
class RobotWorker implements Worker {
    public void work() {}
    public void eat()  { throw new UnsupportedOperationException(); }
    public void sleep(){ throw new UnsupportedOperationException(); }
}
```

Robot is forced to implement `eat()` and `sleep()` which make no sense. This violates ISP and indirectly LSP.

---

## Proper ISP Design

```java
interface Workable  { void work(); }
interface Eatable   { void eat(); }
interface Sleepable { void sleep(); }

class HumanWorker implements Workable, Eatable, Sleepable {
    public void work()  {}
    public void eat()   {}
    public void sleep() {}
}

class RobotWorker implements Workable {
    public void work() {}
}
```

Each interface represents one capability, one role, one behavior group.

---

## Interface Design Thinking

Good interfaces answer: **what capability does this object have?**

Not: what giant set of methods can we dump together?

**Bad:**
```java
interface Machine {
    void print();
    void scan();
    void fax();
}
```

Simple printer is forced to implement `scan()` and `fax()`.

**Better:**
```java
interface Printable { void print(); }
interface Scannable { void scan(); }
interface Faxable   { void fax(); }
```

- Simple printer → `Printable`
- Advanced machine → multiple interfaces

---

## Real Engineering Example — Notification System

**Bad:**
```java
interface NotificationService {
    void sendEmail();
    void sendSMS();
    void sendPush();
    void sendWhatsApp();
}
```

`EmailNotificationService` is forced to implement irrelevant methods.

**Better:**
```java
interface EmailSender { void sendEmail(); }
interface SmsSender   { void sendSMS(); }
```

Systems depend only on the required capability.

---

## ISP + Composition

Small interfaces work beautifully with composition and dependency injection:

```java
class Bird {
    private Flyable flyable;
    private Swimmable swimmable;
}
```

Behavior becomes modular. Huge architecture advantage.

---

## Refactoring Example

**Bad:**
```java
interface Vehicle {
    void drive();
    void fly();
    void sail();
}
```

Car cannot fly. Boat cannot drive. Bad abstraction.

**Good:**
```java
interface Drivable { void drive(); }
interface Flyable  { void fly(); }
interface Sailable { void sail(); }
```

- `Car` → `Drivable`
- `Plane` → `Flyable`
- `Boat` → `Sailable`

---

## ISP vs SRP

Students confuse these sometimes.

| SRP | ISP |
|-----|-----|
| Focuses on class responsibility | Focuses on interface design |
| Keep classes focused | Keep interfaces focused |

---

## Common Beginner Mistakes

**Mistake 1** — Creating giant utility interfaces:
```java
interface UserOperations {
    login(); payment(); upload(); notification(); analytics();
}
```

**Mistake 2** — Creating interfaces too broad "for the future." That's overengineering.

**Mistake 3** — Throwing `UnsupportedOperationException`. Major red flag — usually indicates bad abstraction, ISP violation, and LSP violation.

---

## Real Framework Insight

Java Collections use many focused interfaces:
```
List  Set  Queue  Iterable  Comparable  Runnable
```

Each interface has focused responsibility. That's ISP thinking.

---

## Interview Questions

**Q: What is ISP?**
Clients should not be forced to depend on methods they do not use. Interfaces should be small and focused.

**Q: Why are fat interfaces bad?**
They increase coupling, force unnecessary implementation, reduce flexibility, and violate clean design.

**Q: Sign of ISP violation?**
`UnsupportedOperationException` — very important answer.

---

## Red Flags

- `UnsupportedOperationException` in implementations
- Fat interfaces with unrelated methods
- Unused methods in implementing classes

---

## Cheat Sheet

```
Bad:  One huge interface with everything
Good: Many small focused interfaces
```

---

## Practice Problems

**Beginner** — Refactor `Machine` interface with print/scan/fax problem

**Intermediate** — Design notification capabilities and upload/download/share capabilities using focused interfaces

**Advanced** — Design vehicle system with flyable, drivable, rechargeable, refuelable without giant interfaces

**Mini Challenge** — Interface `SmartDevice` contains `call()`, `takePhoto()`, `playMusic()`, `projectHologram()`. Should ALL devices implement all methods? How would you redesign using ISP?
