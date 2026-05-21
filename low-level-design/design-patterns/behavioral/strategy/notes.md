# Strategy Pattern

> "Don't hardcode behavior. Make behavior interchangeable."

Used heavily in: payment systems, sorting frameworks, navigation apps, authentication systems, pricing engines, notification systems, ML pipelines.

---

## Simple Explanation

A beginner builds a payment system like this:

```java
if (paymentType.equals("UPI")) { }
else if (paymentType.equals("CARD")) { }
else if (paymentType.equals("PAYPAL")) { }
```

As new payment methods come — code becomes huge, difficult to maintain, risky to modify, and violates OCP.

**Strategy Pattern solution:** move each behavior into a separate class. Each algorithm becomes a "strategy". Switch behavior dynamically at runtime.

> Define a family of algorithms, encapsulate each one, and make them interchangeable.

---

## Real-World Analogy — Google Maps

Google Maps can choose fastest route, shortest route, toll-free route, or bike-friendly route. The map system stays the same — only the routing algorithm changes.

```
Navigation App
├── FastestRouteStrategy
├── ShortestRouteStrategy
└── ScenicRouteStrategy
```

---

## Structure

**3 components:**

1. **Strategy Interface** — defines common behavior
2. **Concrete Strategies** — actual implementations
3. **Context** — uses a strategy

---

## Bad Design

```java
class PaymentService {
    public void pay(String type, int amount) {
        if (type.equals("UPI")) { }
        else if (type.equals("CARD")) { }
        else if (type.equals("PAYPAL")) { }
    }
}
```

Problems:
- Violates OCP — adding new payment requires modifying existing class
- Huge conditional logic as project grows
- Cannot independently test payment methods
- Tight coupling — `PaymentService` knows every implementation detail

---

## Refactored Using Strategy Pattern

**Step 1 — Strategy interface:**
```java
interface PaymentStrategy {
    void pay(int amount);
}
```

**Step 2 — Concrete strategies:**
```java
class UpiPaymentStrategy implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid using UPI: " + amount);
    }
}

class CardPaymentStrategy implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid using Card: " + amount);
    }
}
```

**Step 3 — Context:**
```java
class PaymentService {
    private PaymentStrategy paymentStrategy;

    PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    void processPayment(int amount) {
        paymentStrategy.pay(amount);
    }
}
```

**Step 4 — Client:**
```java
PaymentService service = new PaymentService(new UpiPaymentStrategy());
service.processPayment(1000);
```

---

## Key Insight

The context does NOT know HOW payment works, internal implementation, or business rules. It only knows `paymentStrategy.pay()`. This is **programming to interface** — a core senior engineering mindset.

---

## Runtime Strategy Switching

```java
paymentService.setStrategy(new CardPaymentStrategy());
```

Enables feature toggles, runtime algorithm selection, A/B testing, and dynamic business rules.

---

## Real Industry Examples

- **Payment Gateways** — `StripeStrategy`, `RazorpayStrategy`, `PaypalStrategy`
- **Compression** — `ZipCompression`, `RarCompression`, `7ZipCompression`
- **Authentication** — `OAuthStrategy`, `JWTStrategy`, `SSOStrategy`
- **Sorting** — `Collections.sort(list, comparator)` — `Comparator` itself is Strategy Pattern

---

## Strategy vs State Pattern

| Strategy | State |
|----------|-------|
| Client chooses behavior | Object changes behavior itself |
| Interchangeable algorithms | Object state transitions |
| Independent strategies | States usually know transitions |

**Strategy** — change algorithm/behavior (payment method, sorting algorithm)

**State** — behavior changes automatically based on internal state (vending machine, order lifecycle)

---

## Composition Over Inheritance

Strategy Pattern strongly promotes composition over inheritance.

Instead of `Dog extends FlyingDog`, we do `Dog HAS-A FlyBehavior`.

---

## Lambda Strategy (Java 8+)

```java
interface DiscountStrategy {
    double apply(double price);
}

DiscountStrategy festivalDiscount = price -> price * 0.8;
DiscountStrategy premiumDiscount  = price -> price * 0.7;

class PriceCalculator {
    double calculate(double price, DiscountStrategy strategy) {
        return strategy.apply(price);
    }
}
```

Modern Java frameworks use this style heavily.

---

## Common Mistakes

**Mistake 1** — Creating strategies for tiny logic. Overengineering.

**Mistake 2** — Context knowing implementation details:
```java
if (strategy instanceof UpiStrategy)  // destroys abstraction
```

**Mistake 3** — Too many unnecessary classes. Use wisely.

---

## Advantages

- Extensible — add new strategy without changing old code
- Cleaner code — removes giant conditionals
- Testable — each strategy testable independently
- Runtime flexibility — dynamic behavior selection

## Disadvantages

- More classes — can increase codebase size
- Client must understand strategies — someone must choose correctly
- Overengineering risk — for very small logic, simple if-else may be better

Senior engineers know **when NOT to use patterns**.

---

## Strategy Pattern in Spring Boot

```java
@Autowired
private PaymentProcessor processor;
```

Spring injects the implementation. This is practical Strategy Pattern usage.

---

## When to Use

```
Many if-else conditions
Multiple algorithms exist
Runtime behavior changes needed
Want extensibility
Want loose coupling
```

---

## Key Formula

```
Encapsulate changing behavior + Inject behavior dynamically = Strategy Pattern
```

---

## Practice Problems

**Beginner** — Payment system, Notification sender, File compression tool

**Intermediate** — Cab fare calculator, Tax calculation engine, Coupon application system

**Advanced** — Chess AI difficulty strategies, Recommendation engine ranking, Dynamic fraud detection rules

---

## One-Line Definition

Strategy Pattern allows selecting behavior dynamically by encapsulating algorithms into interchangeable classes.
