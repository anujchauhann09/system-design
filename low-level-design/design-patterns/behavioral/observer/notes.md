# Observer Pattern

> "Don't tightly connect systems that react to events. Publish changes and let interested parties react independently."

Used heavily in: event-driven systems, notifications, UI frameworks, microservices, messaging systems, real-time apps, stock market systems, Kafka-like architectures.

---

## Simple Explanation

A beginner builds a YouTube system like this:

```java
class YoutubeChannel {
    EmailService emailService;
    AnalyticsService analyticsService;
    RecommendationService recommendationService;

    public void uploadVideo() {
        emailService.send();
        analyticsService.track();
        recommendationService.update();
    }
}
```

The channel becomes tightly coupled to every service. Adding new behavior means modifying existing code repeatedly. Violates OCP, loose coupling, and maintainability.

**Observer Pattern solution:** Subject announces "something changed!" — observers decide whether and how to react.

> Observer Pattern defines a one-to-many dependency so that when one object changes state, all dependents are automatically notified.

---

## Real-World Analogy — YouTube

YouTube Channel uploads a video. Subscribers receive notification automatically. The channel does NOT know who you are, what device you use, or how notification works. It simply publishes the event. Subscribers react independently.

---

## Structure

**4 components:**

1. **Subject (Publisher)** — maintains list of observers, handles subscribe/unsubscribe/notify
2. **Observer (Subscriber)** — receives updates via `update()`
3. **Concrete Subject** — actual state holder that triggers notifications
4. **Concrete Observer** — actual implementations (`EmailNotification`, `SMSNotification`, `AnalyticsObserver`)

---

## Bad Design

```java
class WeatherStation {
    PhoneDisplay phone;
    TVDisplay tv;

    public void setTemperature(int temp) {
        phone.update(temp);
        tv.update(temp);
    }
}
```

`WeatherStation` knows all consumers. Adding a new observer requires modifying `WeatherStation`. Violates OCP.

---

## Refactored Using Observer Pattern

**Observer interface:**
```java
interface Observer {
    void update(int temperature);
}
```

**Subject interface:**
```java
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

**Concrete Subject:**
```java
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer observer)    { observers.add(observer); }
    public void removeObserver(Observer observer) { observers.remove(observer); }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
```

**Concrete Observers:**
```java
class PhoneDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("Phone Display: " + temperature);
    }
}

class TVDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("TV Display: " + temperature);
    }
}
```

**Client:**
```java
WeatherStation station = new WeatherStation();
station.addObserver(new PhoneDisplay());
station.addObserver(new TVDisplay());
station.setTemperature(35);
```

---

## Key Insight

Subject does NOT know what observers do, how they work, or their internal logic. It only knows `observer.update()`. This is **loose coupling** — a very important engineering principle.

---

## Push vs Pull Model

**Push Model** — Subject sends data directly: `observer.update(temperature)`
- Pros: simple, efficient
- Cons: pushes unnecessary data sometimes

**Pull Model** — Observer gets notification only, then fetches data: `observer.update()` → `subject.getTemperature()`
- Pros: flexible
- Cons: extra calls

---

## Real-World Examples

- **YouTube** — Channel → Subscribers
- **Stock Market** — `StockPriceSubject` → `MobileApp`, `TradingBot`, `Dashboard`
- **Kafka/Event Systems** — Producer publishes, consumers subscribe independently
- **GUI Frameworks** — `button.addActionListener(listener)` — classic Observer Pattern
- **Spring Boot** — `@EventListener` is Observer Pattern internally

---

## Observer vs Strategy Pattern

| Strategy | Observer |
|----------|----------|
| One active strategy | Multiple observers |
| Behavior selection | Event notification |
| Client chooses | Subject broadcasts |
| Focus on algorithms | Focus on communication |

---

## Real Engineering Problems

**Memory Leaks** — Observers not removed properly. If observer remains subscribed, object never gets garbage collected. Huge real-world issue in Android and GUI listeners.

**Notification Storm** — Too many observers. One event triggers thousands of reactions. Performance issue.

**Circular Updates** — Observer modifies subject again. Infinite loop risk.

---

## Synchronous vs Asynchronous

**Synchronous** — `notifyObservers()` executes all observers immediately. Simple but slow observer blocks others.

**Asynchronous** — Modern systems use queues, event buses, Kafka, RabbitMQ. Observers react independently. Much more scalable.

---

## Event-Driven Architecture Connection

Observer Pattern is the foundation of event-driven systems:

```
OrderPlaced Event
├── Payment Service
├── Inventory Service
├── Notification Service
└── Analytics Service
```

Small systems use direct Observer Pattern. Large systems evolve to Event Bus, Pub/Sub, Kafka, Domain Events.

---

## Common Mistakes

**Mistake 1** — Subject knowing observer details:
```java
if (observer instanceof EmailObserver)  // breaks abstraction
```

**Mistake 2** — Not unsubscribing observers → memory leaks.

**Mistake 3** — Heavy business logic inside notify loop → dangerous for scalability.

**Mistake 4** — Using Observer everywhere. Not every callback system needs it.

---

## Interview Questions

**Q: Difference between Pub/Sub and Observer?**
Observer is usually in-process with direct references. Pub/Sub uses a broker/message queue for distributed systems.

**Q: Can Observer Pattern cause tight coupling?**
Yes, if the observer interface becomes too specific.

**Q: How to avoid notification failure breaking others?**
Use async execution, retry, and exception isolation.

---

## When to Use

```
One-to-many dependency
Event-driven behavior
Automatic notifications needed
Loose coupling required
Extensibility needed
```

## Core Formula

```
State Change
+ Broadcast Notification
+ Independent Reactions
= Observer Pattern
```

---

## Practice Problems

**Beginner** — YouTube subscription system, Weather monitoring app, News notification system

**Intermediate** — Stock market tracker, Chat room notifications, Multiplayer game events

**Advanced** — Kafka-like event bus, Distributed notification service, Real-time analytics pipeline

---

## One-Line Definition

Observer Pattern defines a one-to-many dependency where a subject automatically notifies all registered observers when its state changes.
