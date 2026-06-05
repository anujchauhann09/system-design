# Chain of Responsibility Pattern

> "Pass a request along a chain of handlers. Each handler decides either to process the request or to forward it to the next handler in the chain."

Used heavily in: API gateways, web middleware, Servlet/Spring filter chains, approval workflows, event/exception handling, logging pipelines.

---

## Simple Explanation

Suppose a request wants to reach your business logic. Before it gets there it must pass a series of checks:

```
Request
   |
Authentication
   |
Authorization
   |
Rate Limiting
   |
Validation
   |
Controller
```

Each step checks one thing. If a step fails → **STOP**. Otherwise → **pass the request to the next handler**.

**Core idea:** instead of one giant nested `if`:

```java
if (authenticated) {
    if (authorized) {
        if (rateLimitPassed) {
            if (validRequest) {
                processRequest();
            }
        }
    }
}
```

...you create independent handlers, and each one decides:

```
Handle?  or  Pass to next?
```

That is Chain of Responsibility.

---

## Real-World Analogy — Airport Security

```
Passenger
   |
ID Verification
   |
Security Scan
   |
Immigration
   |
Boarding Check
```

If any checkpoint fails → **Access Denied**. Otherwise → continue to the next.
Each checkpoint is a handler. The whole journey is the chain.

| Airport | Chain of Responsibility |
|---|---|
| Passenger | Request |
| Each checkpoint | Concrete Handler |
| "Pass to next gate" | Forwarding |
| "Access denied" | Short-circuit |

---

## Problem It Solves

Imagine an API gateway that must: authenticate the user, check permission, validate the request, check rate limit, and audit. Without the pattern:

```java
class ApiService {
    public void process(Request request) {
        // auth
        // authorization
        // validation
        // rate limiting
        // auditing
        // business logic
    }
}
```

Problems:

- one huge class doing everything
- hard to **extend** (new check ⇒ edit the method)
- hard to **reorder** the checks
- violates the **Single Responsibility Principle**
- difficult to test each step in isolation

---

## Structure

```
Request
   |
   v
+-----------+      +-----------+      +-----------+
| Handler A | ---> | Handler B | ---> | Handler C |
+-----------+      +-----------+      +-----------+
```

**Components**

1. **Handler** (abstract) — declares `handle(request)` and holds a reference to the `next` handler.
2. **Concrete Handlers** — `AuthHandler`, `ValidationHandler`, `RateLimitHandler`, ... each implements its own check.
3. **Client** — builds the chain (`a.setNext(b); b.setNext(c)`) and submits the request to the head.

---

## Bad Design First

```java
class RequestProcessor {
    public void process(Request request) {
        if (!authenticated) return;
        if (!authorized)    return;
        if (!validRequest)  return;
        processBusinessLogic();
    }
}
```

- **Huge method** — all responsibilities mixed together.
- **Hard to reorder** — want rate limiting before auth? Edit the method.
- **Hard to extend** — want an audit check? Edit the method again.

---

## Refactor Using Chain of Responsibility

**Step 1 — Abstract Handler**

```java
abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handle(Request request);
}
```

**Step 2 — A Concrete Handler**

```java
class AuthenticationHandler extends Handler {
    @Override
    public void handle(Request request) {
        if (!request.isAuthenticated()) {
            System.out.println("Authentication Failed");
            return;                       // short-circuit
        }
        if (next != null) next.handle(request);   // forward
    }
}
```

`AuthorizationHandler` and `ValidationHandler` follow the exact same shape — check, then either short-circuit or forward.

**Step 3 — Build the chain & execute**

```java
Handler auth          = new AuthenticationHandler();
Handler authorization = new AuthorizationHandler();
Handler validation    = new ValidationHandler();

auth.setNext(authorization);
authorization.setNext(validation);

auth.handle(request);   // enter at the head
```

> **Tip:** a tiny `forward(request)` helper on the base `Handler` removes the repeated
> `if (next != null) next.handle(request)` from every concrete handler.

---

## Deep Understanding — The Handler's Three Choices

Every handler has exactly three options. This is the essence of the pattern:

1. **Handle and Stop** — process the request, do not forward (approval chains).
2. **Handle and Pass** — do your part, then forward (middleware / logging).
3. **Ignore and Pass** — not mine, forward as-is.

Each handler obeys the **Single Responsibility Principle**: the auth handler only authenticates, the validator only validates, the rate limiter only rate limits — nothing else.

---

## The Two Variants

These notes' practice problems split cleanly into the two ways CoR is used. Knowing which one you mean is a common interview distinction.

| | **Approval chain** | **Pipeline / middleware** |
|---|---|---|
| Who handles it? | **Exactly one** link — the first that qualifies | **Every** link, in order |
| Forwarding means | "Not mine — pass it on" | "My part is done — next, do yours" |
| Stops early when | a handler **accepts** | a handler **rejects** (short-circuit) |
| Real-world name | escalation / approval | filter chain, gateway |
| Examples here | leave, expense, support escalation | api-request, food-delivery, loan, gateway, payment |

**Stateless vs. stateful handlers:** most handlers are stateless checks, but a handler may own state — e.g. `RateLimitingHandler` keeps a `Map<clientId, count>` across requests. The state lives *inside* the handler, not in the request.

---

## Ordering Is a Design Decision

In an approval chain, order is just escalation rank. In a pipeline, **the order encodes business rules**:

- **Cost gradient** — put cheap, likely-to-fail checks first so you do the least work to reject (credit score before an expensive fraud-scoring API).
- **Side effects** — never do irreversible work before the gates that guard it (authorize/validate *before* capturing money, so you never refund what you should not have charged).
- **Security** — authenticate before you rate-limit by identity; log *after* auth so you record only admitted traffic.

Reordering can change correctness, not just performance — that trade-off is worth naming out loud.

---

## Real Industry Examples

- **Spring Security Filter Chain** — `AuthenticationFilter → AuthorizationFilter → CSRF → JWT`.
- **Servlet Filters** — `LoggingFilter → AuthFilter → ValidationFilter` (`FilterChain.doFilter`).
- **API Gateways** (Kong, Envoy, Spring Cloud Gateway) — `Auth → RateLimit → Audit → Route`.
- **Exception handling** — try handler 1, then 2, then 3 until one handles it.
- **Customer support escalation** — `Agent → Team Lead → Manager → Director`.

---

## Advantages

- **Loose coupling** — the sender doesn't know which handler will process the request.
- **Open/Closed** — add a `FraudCheckHandler` without touching existing handlers.
- **Flexible ordering** — rearrange the chain without rewriting logic.
- **Maintainability** — small, focused, independently testable classes.

## Trade-offs

- **Harder to debug** — a request flows through many handlers; tracing can be tricky.
- **Performance** — very long chains add overhead.
- **Request may never be handled** — a misconfigured chain can drop a request silently.

---

## Chain of Responsibility vs. Strategy vs. Command

| Pattern | Goal | Example |
|---|---|---|
| **Strategy** | choose **ONE** algorithm | UPI vs. Card vs. Wallet — one selected |
| **Chain of Responsibility** | pass through **MANY** handlers | Auth → Validation → RateLimit → Logging — many may run |
| **Command** | represent an **action as an object** | `RefundPaymentCommand`, queued/logged/undone |

**Remember:** Strategy = *choose one*. Chain = *process through many*. Command = *action as object*.

---

## Practice Problems

All problems live under `practice-problems/`. Each is a runnable Java demo
(`javac *.java && java Client`).

**Beginner — approval chains (one handler claims it):**

| Problem | Chain | Routing key |
|---|---|---|
| `leave-approval-system` | TeamLead → Manager → Director | leave days |
| `expense-approval` | Supervisor → Manager → Finance Head | amount |
| `customer-support-escalation` | Level1 → Level2 → Level3 | ticket severity |

**Intermediate — validation pipelines (all must pass):**

| Problem | Chain | Note |
|---|---|---|
| `api-request-processing` | Authentication → Authorization → Validation → Logging | first pipeline; short-circuit on failure |
| `food-delivery-order-validation` | RestaurantOpen → DriverAvailable → PaymentSuccess → InventoryAvailable | boolean-flag checks |
| `loan-approval-system` | CreditScore → IncomeVerification → FraudCheck → FinalApproval | numeric thresholds |

**Advanced — production-grade pipelines:**

| Problem | Chain | Note |
|---|---|---|
| `api-gateway` | JWT → RateLimiting → AuditLogging → Routing | stateful rate limiter (per-client counts) |
| `payment-processing-pipeline` | FraudDetection → BalanceCheck → Authorization → Capture → Notification | capture is the irreversible side effect — gated by every check above |

**Further ideas to build:**

- **DICOM Gateway Pipeline** — DICOM Validation → Metadata Extraction → Patient Validation → Compression Check → Storage → Transmission → Audit.
- **Document Processing System** — Upload → Virus Scan → Format Validation → Metadata Extraction → Storage → Notification.

---

## Revision Summary

```
Request  +  Handlers  +  Forwarding Logic  =  Chain of Responsibility
```

**Use CoR when:**

- multiple processing steps exist
- order matters
- handlers should be independent
- the request may be stopped early
- a pipeline architecture is needed

**One-line definition:** Chain of Responsibility lets multiple handlers process a request sequentially, without tightly coupling the sender to the receiver.
