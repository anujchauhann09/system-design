# State Pattern

> "Allow an object to change its behavior when its internal state changes."

Used heavily in: ATM machines, order lifecycle systems, media players, workflow engines, authentication/session management.

---

## Simple Explanation

State Pattern is a behavioral design pattern where an object behaves differently depending on its current state.

Same object. Different behavior. Depending on internal state.

## Real-World Analogy — Order Lifecycle

An order in an e-commerce app can be:

- PLACED
- PAID
- SHIPPED
- DELIVERED
- CANCELLED

Behavior depends on current state.

If order is **PLACED**:
- pay() 
- cancel() 
- deliver() 

If order is **SHIPPED**:
- deliver() 
- pay() 

Same `Order` object, different behavior based on state.

That is State Pattern.

---

## Why Not Use If-Else?

Most beginners write:

```java
if(orderState.equals("PLACED")) { }
else if(orderState.equals("PAID")) { }
else if(orderState.equals("SHIPPED")) { }
```

Problems:
- giant conditional logic
- hard to add new state
- invalid transitions can happen
- violates Open Closed Principle

---

## Structure

### 1. State Interface
Common contract for all states.

```java
interface OrderState {
    void next(Order order);
}
```

### 2. Concrete State Classes

- PlacedState
- PaidState
- ShippedState
- DeliveredState

### 3. Context

The object that owns the current state.

Example:

```java
Order
```

---

## Implementation

### State Interface

```java
interface OrderState {
    void next(Order order);
}
```

### PlacedState

```java
class PlacedState implements OrderState {
    public void next(Order order) {
        System.out.println("Payment completed");
        order.setState(new PaidState());
    }
}
```

### PaidState

```java
class PaidState implements OrderState {
    public void next(Order order) {
        System.out.println("Order shipped");
        order.setState(new ShippedState());
    }
}
```

### ShippedState

```java
class ShippedState implements OrderState {
    public void next(Order order) {
        System.out.println("Order delivered");
        order.setState(new DeliveredState());
    }
}
```

### Context

```java
class Order {
    private OrderState state;

    public Order() {
        state = new PlacedState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }
}
```

---

## Core Insight

Most important idea:

**Behavior is delegated to the current state object**

Meaning:

```java
order.next();
```

internally becomes:

```java
currentState.next(order);
```

The Order does not decide behavior.

Current state decides behavior.

---

## Strategy vs State

| Strategy | State |
|---|---:|
| Client chooses behavior | State decides behavior |
| Interchangeable algorithms | State-driven behavior |
| Independent strategies | States usually transition |

### Strategy Example
UPI / Card / Wallet

### State Example
Placed → Paid → Shipped → Delivered

---

## Real Industry Examples

### ATM Machine
- IdleState
- HasCardState
- PinVerifiedState
- CashDispenseState

### Media Player
- Playing
- Paused
- Stopped

### Traffic Signal
- Red
- Yellow
- Green

### Authentication System
- LoggedOut
- LoggedIn
- SessionExpired
- Locked

---

## Advantages

- Cleaner code
- Better encapsulation
- Easier extension
- Safer state transitions

## Disadvantages

- More classes
- Can become complex with too many transitions

---

## When to Use

Use State Pattern when:

- object has multiple states
- behavior changes with state
- many conditionals exist
- transitions matter
- invalid flow must be prevented

---

## Practice Problems

### Beginner
- Traffic Light System
- Media Player
- Door System

### Intermediate
- ATM Machine
- Order Management System
- Authentication Session System

### Advanced
- Vending Machine
- Cab Ride Lifecycle
- Payment Workflow
- Document Approval Workflow

---

# One-Line Definition

**State Pattern allows an object to change behavior automatically when its internal state changes.**