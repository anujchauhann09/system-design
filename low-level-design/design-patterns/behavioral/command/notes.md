# Command Pattern

> "Encapsulate a request as an object, letting you parameterize, queue, log, and undo operations."

Used heavily in: remote controls, undo/redo engines, job schedulers, message queues, menu systems, payment workflows.

---

## Simple Explanation

Imagine a remote control with buttons:

- ON
- OFF
- VOLUME UP
- VOLUME DOWN

A beginner wires the button straight to the device:

```java
if (button.equals("ON")) {
    tv.turnOn();
} else if (button.equals("OFF")) {
    tv.turnOff();
}
```

Works initially. But then you need to support TV, AC, Fan, Lights, Music System...
and the remote becomes a giant messy `if-else`.

**Core idea:** instead of the button knowing *what* to do, the button stores a
**command object** and simply calls:

```java
command.execute();
```

Convert the action/request into an object. That is the Command Pattern.

---

## Real-World Analogy — Restaurant Waiter

A customer says "Bring pizza". The waiter writes an order slip. The kitchen executes it.

| Restaurant | Command Pattern |
|---|---|
| Customer | Client |
| Waiter | Invoker |
| Order Slip | Command |
| Chef | Receiver |

The waiter doesn't cook. The chef doesn't talk to the customer.
The waiter only **carries the command**. Perfect Command Pattern.

---

## Problem It Solves

Without Command Pattern the sender calls the receiver directly:

```
Button → TV.turnOn()
```

Very tightly coupled. Problems:

- sender knows too much
- hard to add new actions
- hard to queue requests
- hard to log requests
- hard to undo operations

Command Pattern **decouples the sender from the receiver**.

---

## Structure

```
Client
  |
  v
Command ---> Receiver
  ^
  |
Invoker
```

### 1. Command Interface
Defines `execute()`, sometimes `undo()`.

```java
interface Command {
    void execute();
}
```

### 2. Concrete Command
The actual implementation — `TurnOnCommand`, `TurnOffCommand`, `RefundPaymentCommand`.

### 3. Receiver
The real worker that holds the business logic — `TV`, `Fan`, `Light`, `PaymentGateway`.

### 4. Invoker
Triggers the command — `RemoteControl`, `Button`, `MenuItem`, `Scheduler`.

### 5. Client
Creates and wires the objects together.

---

## Bad Design First

```java
class Remote {
    private TV tv;

    public void press(String action) {
        if (action.equals("ON")) {
            tv.turnOn();
        }
        if (action.equals("OFF")) {
            tv.turnOff();
        }
    }
}
```

Problems:
- **Tight coupling** — Remote knows TV details.
- **Hard to extend** — need AC? Modify Remote. Need Fan? Modify Remote.
- violates Open/Closed Principle.

---

## Refactor Using Command Pattern

### Step 1 — Command Interface

```java
interface Command {
    void execute();
}
```

### Step 2 — Receiver

```java
class TV {
    public void turnOn() {
        System.out.println("TV ON");
    }

    public void turnOff() {
        System.out.println("TV OFF");
    }
}
```

### Step 3 — Concrete Commands

```java
class TurnOnCommand implements Command {
    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}
```

```java
class TurnOffCommand implements Command {
    private TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOff();
    }
}
```

### Step 4 — Invoker

```java
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

### Step 5 — Client

```java
public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        Command onCommand = new TurnOnCommand(tv);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(onCommand);
        remote.pressButton();
    }
}
```

Output:

```
TV ON
```

---

## Core Insight

The **invoker does not know the business logic**.

```java
order.next();   // invoker only knows:
command.execute();
```

The real logic lives in the receiver. This creates loose coupling — the invoker
treats every request the same way, no matter what it does.

---

## Undo — Superpower of the Command Pattern

Because an action is now an **object**, you can store a history:

```
command1
command2
command3
```

and reverse it with `undo()`. Each command knows how to undo itself
(store the operand, or snapshot state before executing when the operation
isn't trivially invertible).

For **redo**, keep two stacks — an `undoStack` and a `redoStack`. A fresh
action clears the redo history.

Used in: text editors, Photoshop, Figma, IDEs, Google Docs.

---

## Real Industry Examples

- **Button click handlers** — click → execute command.
- **Undo/Redo systems** — Ctrl+Z.
- **Job queues** — `SendEmailCommand`, `GenerateInvoiceCommand` executed later by a worker.
- **Background workers** — Kafka consumers process messages like commands.
- **Menu systems** — Copy, Paste, Delete, Rename as command objects.
- **Payment retry systems** — `RefundPaymentCommand`, `CapturePaymentCommand`, `RetryChargeCommand`.

---

## Advantages

- **Loose coupling** — invoker and receiver separated.
- **Undo/Redo support** — actions are objects, easy to reverse.
- **Queueing** — commands can be stored and executed later.
- **Logging/Auditing** — store executed commands.
- **Scheduling** — run later via cron/background workers.
- **Extensible** — add a new command without changing the invoker.

## Tradeoffs

- **More classes** — one per command.
- **Indirection** — an extra abstraction layer.
- **Overkill** for simple use cases — sometimes a direct method call is enough.

---

## Command vs Strategy

Frequently confused.

| Strategy | Command |
|---|---|
| Choose an **algorithm** | Represent a **request/action** as an object |
| `PaymentStrategy`, `DiscountStrategy` | `TurnOnCommand`, `RefundPaymentCommand` |
| Asks: **HOW** should I do this? | Asks: **WHAT** action should be executed? |

---

## When to Use

Use Command Pattern when:

- action/request should be an object
- need undo/redo
- need queueing
- need delayed execution
- need logging/auditing
- need loose coupling between sender and executor

---

## Practice Problems

### Beginner
- TV Remote Control — `TurnOn`, `TurnOff`, `VolumeUp`, `VolumeDown`
- Light Switch — `SwitchOn`, `SwitchOff`, `DimLight`
- Calculator Undo — `AddCommand`, `SubtractCommand`, `MultiplyCommand` (support undo)

### Intermediate
- Text Editor Undo/Redo — `WriteTextCommand`, `DeleteTextCommand`, `PasteTextCommand`
- Food Delivery Order Processing — `PlaceOrderCommand`, `CancelOrderCommand`, `AssignDeliveryPartnerCommand`
- Job Scheduler — `SendEmailCommand`, `GenerateReportCommand`, `CleanupLogsCommand` (execute later)

### Advanced
- Payment Gateway Workflow — `AuthorizePaymentCommand`, `CapturePaymentCommand`, `RefundPaymentCommand`, `RetryPaymentCommand`
- Distributed Task Queue — store commands in Kafka / RabbitMQ / Redis; workers execute asynchronously
- IDE Undo/Redo Engine — like IntelliJ, VS Code, Google Docs

---

# One-Line Definition

**Command Pattern converts a request into an object so it can be executed, stored, queued, logged, or undone.**
