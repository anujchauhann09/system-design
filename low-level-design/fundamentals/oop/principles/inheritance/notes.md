# Inheritance — Complete Notes

## What is Inheritance?

Inheritance allows one class to acquire properties and behaviors of another class.

> Child class inherits from parent class.

---

## Real-World Analogies

**Animals** — Dog, Cat, Lion all eat, sleep, breathe. Instead of duplicating code, create a common parent `Animal`.

**Company Employees** — All employees have name, salary, employeeId. But Developer writes code, Manager manages teams, Tester tests software. Common things go to `Employee`, specialized behavior goes to child classes.

---

## Why Inheritance Exists

Without inheritance:
```java
class Dog { void eat() {} }
class Cat { void eat() {} }
```

Duplicate code everywhere. Inheritance promotes reuse, hierarchy, and extensibility.

---

## Basic Syntax

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

```java
Dog dog = new Dog();
dog.eat();   // inherited
dog.bark();  // own method
```

---

## IS-A Relationship

Inheritance models an **IS-A** relationship:
- Dog IS-A Animal 
- Car IS-A Vehicle
- Manager IS-A Employee

If the relationship is not naturally IS-A, inheritance is wrong.

**Wrong example:**
```
Engine IS-A Car
```

Engine is PART OF a car — that's composition, not inheritance.

---

## Code Reuse

**Without inheritance (duplicate fields):**
```java
class Developer { String name; int salary; }
class Manager   { String name; int salary; }
```

**With inheritance:**
```java
class Employee {
    String name;
    int salary;
}

class Developer extends Employee {
    void writeCode() {}
}

class Manager extends Employee {
    void manageTeam() {}
}
```

---

## Constructor Flow

Parent constructor executes first — always.

```java
class Animal {
    Animal() { System.out.println("Animal constructor"); }
}

class Dog extends Animal {
    Dog() { System.out.println("Dog constructor"); }
}
```

Output:
```
Animal constructor
Dog constructor
```

Why? Because the child object contains the parent part first. Parent initialization must happen before child initialization.

```
Dog Object
----------------
Animal Part
Dog Part
```

---

## Method Overriding

Child class provides its own implementation of a parent method.

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
```

Overriding enables specialization, runtime polymorphism, and flexible architectures. Frameworks heavily rely on it.

---

## super Keyword

**Call parent constructor:**
```java
class Dog extends Animal {
    Dog() {
        super("Dog Animal");
    }
}
```

**Call parent method:**
```java
super.sound();
```

Useful when extending behavior instead of replacing it completely.

---

## Types of Inheritance in Java

**Single:** `A → B`

**Multilevel:** `A → B → C`

**Hierarchical:**
```
Animal
/  |  \
Dog Cat Lion
```


**Multiple inheritance of classes:** NOT supported in Java — causes the **Diamond Problem**.

If both B and C override the same method from A, and D inherits from both, ambiguity occurs. Java avoids this for classes.

**But interfaces support multiple inheritance:**
```java
interface Flyable {}
interface Swimmable {}

class Duck implements Flyable, Swimmable {}
```

---

## Inheritance is Powerful BUT Dangerous

Beginners overuse inheritance. Senior engineers prefer composition, interfaces, and loose coupling unless a true hierarchy exists.

**Problems with deep inheritance chains:**
- Tight coupling
- Fragile code
- Hard debugging
- Ripple effects
- Difficult testing

---

## Golden Rule

> Use inheritance ONLY for true IS-A relationships.

---

## Fragile Base Class Problem

If a parent class changes internally, all child classes may break unexpectedly. This is why inheritance increases coupling. Senior engineers are cautious.

---

## Inheritance vs Composition

| Inheritance | Composition |
|-------------|-------------|
| IS-A relationship | HAS-A relationship |
| Rigid hierarchy | Flexible |
| Tight coupling | Loose coupling |

**Example:**
```
Car HAS-A Engine  (composition)
Car IS-A Engine   (wrong inheritance)
```

Composition gives flexibility and runtime behavior changes. Modern systems often prefer it.

---

## Refactoring Example

**Bad design:**
```java
class Bird {
    void fly() {}
}

class Penguin extends Bird {}  // Penguins can't fly!
```

**Better:**
```java
interface Flyable {
    void fly();
}

class Sparrow implements Flyable {}
class Penguin {}  // doesn't implement Flyable
```

This is a very famous OOP interview example.

---

## Real Framework Usage

Spring and Hibernate use inheritance, interfaces, abstraction, and overriding heavily:
- Controllers inherit framework behavior
- Adapters override methods
- Lifecycle hooks use inheritance

---

## Interview Questions

**Q: What is inheritance?**
Inheritance allows one class to acquire properties and behaviors of another class, promoting reuse and hierarchy.

**Q: Why use inheritance?**
Code reuse, hierarchy modeling, polymorphism support.

**Q: When should inheritance NOT be used?**
When the relationship is not a true IS-A, when flexibility is needed, when hierarchy becomes rigid.

---

## Key Rules

1. Use `extends` for inheritance
2. IS-A relationship must be genuine
3. `@Override` for specialized behavior
4. `super` to access parent
5. Prefer composition over inheritance unless true hierarchy exists

---

## Cheat Sheet

```
Inheritance  → IS-A relationship
Composition  → HAS-A relationship
extends      → inherit class
@Override    → specialized behavior
super        → parent reference
```

---

## Practice Problems

**Beginner** — `Animal`, `Dog`, `Cat` with inherited methods

**Intermediate** — `Employee`, `Developer`, `Manager` with common + specialized behavior

**Advanced** — Payment hierarchy or Vehicle hierarchy. Think: which methods should be overridden? Which should stay common?

**Mini Challenge** — Should `Penguin` inherit from `Bird`? Why can this become bad design? How would you redesign it?
