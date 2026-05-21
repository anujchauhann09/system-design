# Encapsulation — Complete Notes

## What is Encapsulation?

Bundling data and methods together while restricting direct access to internal data.

> Hide internal data + Allow controlled access

---

## Why It Exists

Imagine a banking system with a public field:

```java
class BankAccount {
    public double balance;
}
```

Anyone can do:
```java
account.balance = -999999;
```

The object becomes invalid. Encapsulation prevents this.

---

## Real-World Analogy

**Car** — you press accelerator/brake but never directly control fuel injection or engine combustion. The car hides complexity. That's encapsulation.

---

## Without Encapsulation (Bad Design)

```java
class Employee {
    public String name;
    public int salary;
}
```

```java
emp.salary = -50000; // invalid, no validation, dangerous
```

In large systems (payroll, banking, healthcare) — this causes bugs, security issues, and broken business rules.

---

## Proper Encapsulation

```java
class Employee {
    private String name;
    private int salary;

    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public int getSalary() {
        return salary;
    }
}
```

Now modification goes through controlled methods — you can validate, log, restrict, monitor.

---

## Deep Engineering Thinking

### Encapsulation Protects Invariants

An **invariant** is a rule that must always remain true:
- bank balance cannot be negative
- age cannot be negative
- email cannot be empty

Encapsulation enforces these rules.

### Expose Behavior, Not Raw Data

```java
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) return;
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

Notice: no `setBalance()` — because balance should NOT be arbitrarily modified. Expose meaningful behaviors instead.

---

## Beginner vs Senior Thinking

**Beginner:**
```java
setBalance()
setAge()
setPrice()
```
Everything gets a setter. This is weak design.

**Senior:**
Ask — *should this field really be directly modifiable?*

Amazon would never allow:
```java
order.setTotalAmount(-5000);
```

Instead:
```java
order.addItem()
order.removeItem()
order.applyDiscount()
```

---

## Getters and Setters

Getters read data, setters update data safely.

**Bad setter (no validation):**
```java
public void setAge(int age) {
    this.age = age;
}
```

**Better:**
```java
public void setAge(int age) {
    if (age < 0) throw new IllegalArgumentException("Invalid age");
    this.age = age;
}
```

> Encapsulation is NOT just getters/setters. Blindly generating them for everything defeats encapsulation.

---

## Access Modifiers

| Modifier | Purpose |
|----------|---------|
| `private` | hide internal data |
| `public` | expose safe behavior |

**Industry rule:** most fields should be `private`.

---

## Encapsulation vs Abstraction

| Encapsulation | Abstraction |
|---------------|-------------|
| Hides data/internal state | Hides implementation complexity |
| Focuses on protection | Focuses on simplification |
| Achieved using access modifiers | Achieved using abstract classes/interfaces |

**Simple analogy:**
- Encapsulation — ATM protects bank data
- Abstraction — ATM hides banking complexity

---

## Encapsulation + Maintainability

If internals are exposed, changing them breaks everything. Encapsulation hides implementation so internals can evolve safely — critical in real companies.

---

## Encapsulation + Security

Sensitive data (passwords, balances, tokens, medical records) must never be directly exposed.

---

## Interview Questions

**Q: What is encapsulation?**
Bundling data and methods together while restricting direct access to internal object state through controlled interfaces.

**Q: Why use private fields?**
Protect data, enforce validation, improve maintainability, reduce coupling.

**Q: Are getters/setters always good?**
No. Too many setters can break encapsulation. Senior engineers expose meaningful behavior instead.

---

## Key Rules

1. Fields should usually be `private`
2. Expose behavior, not raw data — prefer `deposit()`/`withdraw()` over `setBalance()`
3. Protect invariants
4. Objects should prevent invalid state

---

## Practice Problems

**Beginner** — `Student`: private marks, validate 0–100

**Intermediate** — `BankAccount`: deposit, withdraw, no direct balance modification

**Advanced** — `ShoppingCart`: addItem(), removeItem(), calculateTotal(), avoid direct price manipulation

**Mini Challenge** — `PasswordManager`: which fields private? expose raw password? what methods? how to enforce security?
