# Singleton Pattern — Deep Dive

> "Ensure a class has only one instance, and provide a global point of access to it."

Singleton is the first of the **Creational Patterns** — and the most famous (and most abused) pattern in the catalog. It guarantees that exactly **one** object of a class exists in the entire application and gives everyone a single, shared way to reach it.

---

## 1. Concept Introduction

### Simple Explanation

Singleton ensures:

> "Only one object of a class can exist in the entire application."

and provides:

> "A global access point to that object."

Typical examples — things you want exactly **one** of:

- One Logger
- One Configuration Manager
- One Cache Manager
- One Database Connection Pool Manager

You don't want multiple copies of these floating around.

### Why Does Singleton Exist?

Imagine creating a config manager freely:

```java
ConfigManager c1 = new ConfigManager();
ConfigManager c2 = new ConfigManager();
ConfigManager c3 = new ConfigManager();
```

Now:

```java
c1.setTheme("Dark");
c2.getTheme(); // Light
```

Different instances hold **different state** → **inconsistency**.

Singleton fixes this:

```java
ConfigManager c1 = ConfigManager.getInstance();
ConfigManager c2 = ConfigManager.getInstance();
ConfigManager c3 = ConfigManager.getInstance();
```

All three point to the **same object**. One state, one source of truth.

---

## 2. Real-World Analogy

### Country President

A country usually has:

- One President
- One Prime Minister

Not 5 Presidents or 10 Prime Ministers.

Whenever anyone needs to interact with the President, they interact with the **same person**.

```
Citizen A
      \
Citizen B ---> President   (only one instance exists)
      /
Citizen C
```

Singleton works exactly the same way.

---

## 3. Theory

### Definition

> Ensures a class has only one instance and provides a global point of access to it.

### Key Characteristics

**1. Private Constructor** — prevents external creation.

```java
private Singleton() {}
```

**2. Static Instance Variable** — stores the only object.

```java
private static Singleton instance;
```

**3. Public Access Method** — returns the same object every time.

```java
public static Singleton getInstance()
```

### UML

```
+----------------------+
|      Singleton       |
+----------------------+
| - instance           |
+----------------------+
| - Singleton()        |
| + getInstance()      |
+----------------------+
```

---

## 4. Bad Design First

Without Singleton:

```java
class Logger {
}

Logger l1 = new Logger();
Logger l2 = new Logger();
Logger l3 = new Logger();
```

Problems:

- multiple objects
- more memory
- different states
- harder management

---

## 5. Variant 1 — Lazy Initialization

Object created only when first needed.

```java
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

Usage:

```java
Singleton s1 = Singleton.getInstance();
Singleton s2 = Singleton.getInstance();
System.out.println(s1 == s2); // true
```

### Visual Flow

```
First call:
  instance == null → create object → instance -> Object

Second call:
  instance already exists → return instance (no new object)
```

### The Problem — Not Thread Safe

Two threads enter at the same time:

```
Thread A checks: instance == null → TRUE
Thread B checks: instance == null → TRUE
Both create objects → Object1, Object2
```

Singleton is **broken** under concurrency.

---

## 6. Variant 2 — Synchronized Method

```java
public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

**Problem:** every single call acquires the lock, even after the instance exists.

```
Thread A waits
Thread B waits
Thread C waits
```

Correct, but slow — the lock is only needed **once**, yet we pay for it forever.

---

## 7. Variant 3 — Double-Checked Locking

The classic interview answer.

```java
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {                 // 1st check — no lock (fast path)
            synchronized (Singleton.class) {
                if (instance == null) {         // 2nd check — inside lock
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### Why Two Checks?

- **First check** — avoids locking on every call once the instance exists.
- **Second check** — prevents two threads that both passed the first check from creating duplicates.

### Why `volatile`?

`instance = new Singleton()` is **not** atomic. It is roughly three steps:

```
1. allocate memory
2. assign reference to `instance`
3. run the constructor / initialize the object
```

The CPU/JVM may **reorder** these (2 before 3). Another thread could then see a **non-null but partially initialized** object. `volatile` forbids that reordering and guarantees visibility.

---

## 8. Variant 4 — Bill Pugh Singleton (Recommended)

The cleanest modern Java approach — interviewers love it.

```java
public class Singleton {

    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

### Why It's Great

- **Lazy** — `Holder` is not loaded until `getInstance()` is first called, so the instance is created only when needed.
- **Thread Safe** — the JVM guarantees class initialization happens exactly once and is thread-safe. No locks in our code.
- **No synchronization cost** — the fast path is a plain field read.
- **Clean & readable.**

This is the variant used across all the practice problems in this folder.

---

## 9. Variant 5 — Enum Singleton (Best per Joshua Bloch)

```java
public enum Singleton {

    INSTANCE;

    public void print() {
        System.out.println("Hello");
    }
}

// Usage
Singleton.INSTANCE.print();
```

### Advantages

Handles automatically:

- Thread safety
- Serialization (no duplicate on deserialize)
- Reflection attacks (cannot instantiate an enum via reflection)

The only downsides: not lazy, and enums can't extend a class.

---

## 10. Real-World Engineering Perspective

Good use cases:

| Use case | Why one instance |
|----------|------------------|
| `Logger.getInstance()` | Whole app shares one logger |
| `ConfigManager.getInstance()` | Load config once |
| `CacheManager.getInstance()` | Single shared cache |
| `ConnectionPoolManager.getInstance()` | Central pool of connections |

---

## 11. Why Singleton Is Often Criticized

Many juniors think *Singleton = best practice*. Often it's an **anti-pattern**.

### Problem 1 — Hidden Dependency

Bad:

```java
class PaymentService {
    Logger logger = Logger.getInstance();   // dependency is hidden
}
```

Better — **Dependency Injection**:

```java
class PaymentService {
    private final Logger logger;
    public PaymentService(Logger logger) {  // dependency is explicit
        this.logger = logger;
    }
}
```

### Problem 2 — Hard Testing

`Logger.getInstance()` is baked in and cannot easily be replaced with a mock.

### Problem 3 — Global State

Many modules read and mutate the same object → spooky action at a distance → hard-to-trace bugs.

---

## 12. Distributed Systems Caveat

> **Singleton is per JVM, not per distributed system.**

If the app runs on **20 servers**, each JVM has its own singleton:

```
Server 1  → JVM 1  → instance #1
Server 2  → JVM 2  → instance #2
...
Server 20 → JVM 20 → instance #20
```

You get **20 independent copies** of the "single" object → configuration drift. For a true cluster-wide single source of truth, move state to an external store (ZooKeeper / etcd / Consul / a DB) and use the per-node Singleton only as a **local cache/handle** that watches or polls that store.

---

## 13. When NOT to Use Singleton

Avoid for domain entities that naturally need **many** instances:

```
User, Order, Product, Cart, Customer, Employee, Invoice
```

Singleton would be wrong for these.

---

## 14. Interview Perspective

**"Implement a thread-safe Singleton."** → Double-Checked Locking **or** Bill Pugh.

Follow-up answers:

| Question | Answer |
|----------|--------|
| Why private constructor? | Prevent external object creation |
| Why static? | One shared instance, accessible without an object |
| Why `volatile`? | Prevent instruction reordering / partial init |
| Why not synchronized method? | Performance overhead on every call |
| Best Singleton in Java? | Enum or Bill Pugh, depending on the discussion |

---

## 15. Practice Problems 

**Beginner**
- Logger → `practice-problems/logger`
- Configuration Manager → `practice-problems/configuration-manager`
- Printer Manager → `practice-problems/printer-manager`

**Intermediate (thread-safe)**
- Cache Manager 
- Database Connection Manager 

**Advanced**
- Distributed Configuration Service — *How would Singleton behave on 20 servers?* (per-JVM, not per-cluster — see §12)

**Mini Project**
- Library Catalog → `practice-problems/library-catalog` (add / remove / search books, Bill Pugh)

---

## 16. Revision Summary (Cheat Sheet)

**Purpose**
- One object
- Global access

**Components**
- Private Constructor
- Static Instance
- Public Getter

**Variants**

| Variant | Lazy | Thread-safe | Notes |
|---------|------|-------------|-------|
| Lazy Initialization | Yes | No | Simple but broken under concurrency |
| Synchronized Method | Yes | Yes | Correct but slow (locks every call) |
| Double-Checked Locking | Yes | Yes | Needs `volatile`; classic interview answer |
| **Bill Pugh (holder)** | Yes | Yes | **Recommended** — clean, no lock cost |
| Enum | No | Yes | Safest (serialization + reflection proof) |

**Recommended:** Bill Pugh Singleton, or Enum Singleton.

**Drawbacks**
- Hidden dependencies
- Global state
- Hard testing
- Tight coupling
