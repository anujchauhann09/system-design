# Liskov Substitution Principle (LSP)

## Simple Definition

Objects of a child class should be replaceable with objects of the parent class **without breaking correctness**.

> If Child IS-A Parent, then Child should behave like Parent safely.

---

## Easier Meaning

If code expects `Animal animal`, then any subclass — `Dog`, `Cat`, `Lion` — should work correctly. If one subclass breaks expected behavior, LSP is violated.

**Real-world analogy:** A socket expects a standard charger. Any charger fitting the standard should work. If one charger physically fits but explodes the socket — that violates substitution expectations.

---

## Why LSP Exists

Inheritance is dangerous because child classes can change expected behavior, violate assumptions, and break existing code. LSP protects the correctness of polymorphism.

---

## Famous Bird/Penguin Problem

**Bad design:**
```java
class Bird {
    void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {}
```

```java
Bird bird = new Penguin();
bird.fly(); // Penguin can't fly!
```

System expects a bird can fly. Penguin cannot. LSP violated.

**Deep insight:** Even though biologically a Penguin IS-A Bird, from a software behavior perspective — substitution fails. Software design is about behavior contracts, not real-world naming only.

---

## Correct Design

```java
class Bird {}

interface Flyable {
    void fly();
}

class Sparrow extends Bird implements Flyable {
    public void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {}  // doesn't implement Flyable
```

Only flying birds implement flying behavior. LSP preserved.

---

## Rectangle/Square Problem

**Bad design:**
```java
class Rectangle {
    protected int width;
    protected int height;

    void setWidth(int width)   { this.width = width; }
    void setHeight(int height) { this.height = height; }
    int area() { return width * height; }
}

class Square extends Rectangle {
    @Override
    void setWidth(int width) {
        this.width = width;
        this.height = width;  // forces both equal
    }

    @Override
    void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}
```

```java
Rectangle rect = new Square();
rect.setWidth(5);
rect.setHeight(10);
System.out.println(rect.area()); // Expected: 50, Actual: 100
```

Square changes Rectangle's behavior assumptions. LSP violated.

**Key insight:** Inheritance is not about code reuse only — it's about behavioral compatibility.

---

## Behavioral Contracts

LSP is fundamentally about contracts. Parent class defines expectations. Child class must honor them.

**Example:** If parent guarantees `withdraw(amount)` reduces balance, child should not suddenly throw an unsupported exception or behave unpredictably.

---

## Real Industry Example — Payment Systems

```java
interface PaymentMethod {
    void pay(double amount);
}
```

All implementations should successfully process payment or fail predictably. One implementation should NOT randomly ignore payments, silently fail, or violate the contract. Otherwise upper systems break.

---

## Common Signs of LSP Violation

**Red Flag 1** — Child throws `UnsupportedOperationException`:
```java
class Penguin extends Bird {
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

**Red Flag 2** — Child changes expected behavior.

**Red Flag 3** — Child weakens guarantees.

**Red Flag 4** — Code starts checking actual types:
```java
if (obj instanceof Penguin)
```

Often indicates a broken hierarchy.

---

## Refactoring Example

**Bad:**
```java
class Employee {
    void work() {}
}

class RobotEmployee extends Employee {
    @Override
    void work() {
        throw new RuntimeException(); // violates expected behavior
    }
}
```

**Better:**
```java
interface Worker {
    void work();
}
// Only actual workers implement it
```

---

## LSP + OCP Connection

OCP depends on polymorphism. Polymorphism depends on safe substitution. Safe substitution requires LSP. This is how SOLID principles connect.

---

## Inheritance Should Preserve Meaning

Child should **extend** behavior, not **contradict** it.

- `SavingsAccount IS-A BankAccount` — usually safe
- `Penguin IS-A FlyingBird` — unsafe abstraction

---

## Senior Engineer Thinking

Ask: can this child truly replace the parent safely?

If the answer is uncertain — avoid inheritance, prefer composition.

---

## Interview Questions

**Q: What is LSP?**
Objects of child classes should be replaceable with objects of parent classes without breaking correctness or expected behavior.

**Q: Why is Penguin/Bird bad?**
Penguin cannot satisfy the flying behavior expected from Bird. Substitution fails.

**Q: How to fix?**
Use composition, interfaces, and better abstractions instead of forcing bad hierarchy.

---

## Visual Thinking

**Good LSP:**
```
Flyable
   ↑
Sparrow  Parrot  Eagle
```
All satisfy fly behavior safely.

**Bad LSP:**
```
Bird
  ↑
Penguin
```
If Bird assumes flying — substitution fails.

---

## Red Flags

- `UnsupportedOperationException` in child
- Broken expectations
- `instanceof` checks
- Behavior contradictions

---

## Cheat Sheet

```
Inheritance requires: behavior compatibility
Bad:  Penguin extends FlyingBird
Good: Flyable interface
```

---

## Practice Problems

**Beginner** — Fix Bird/Penguin design

**Intermediate** — Design `PaymentMethod` with different payment types ensuring LSP compliance

**Advanced** — Analyze Rectangle/Square problem: why does substitution fail? How would you redesign?

**Mini Challenge** — `ReadOnlyFile extends File` but `write()` throws exception. Is LSP violated? Why?
