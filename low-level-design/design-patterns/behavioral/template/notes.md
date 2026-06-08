# Template Method Pattern — Deep Dive

> "Define the skeleton of an algorithm in a base class and let subclasses override specific steps without changing the overall algorithm structure."

The Template Method Pattern defines the skeleton (template) of an algorithm in a base class while allowing subclasses to customize specific steps.

---

## 1. Concept Introduction

### Simple Beginner Explanation

Suppose you're building an application that generates reports.

All reports follow the same flow:

```
Load Data
   ↓
Process Data
   ↓
Generate Output
   ↓
Send Report
```

But different reports process data differently.

For example:

**Sales Report**
- Load Sales Data
- Process Sales Data
- Generate PDF
- Send Email

**Inventory Report**
- Load Inventory Data
- Process Inventory Data
- Generate PDF
- Send Email

Notice:

- Overall workflow = **SAME**
- Certain steps = **DIFFERENT**

Template Method solves exactly this problem.

### Core Idea

- Keep the algorithm structure fixed.
- Allow subclasses to customize some steps.

### One-Line Definition

Template Method defines the skeleton of an algorithm in a base class and lets subclasses override specific steps without changing the overall algorithm structure.

---

## 2. Problem It Solves

Without Template Method:

```java
class SalesReport {
    generateReport() {
        load();
        processSales();
        export();
        send();
    }
}

class InventoryReport {
    generateReport() {
        load();
        processInventory();
        export();
        send();
    }
}
```

Problems:

- duplicated workflow
- duplicated code
- difficult maintenance

If workflow changes:

> Add audit logging

Need modification everywhere. Bad design.

---

## 3. Real-World Analogy

### Making Tea vs Coffee

Both follow:

```
Boil Water
   ↓
Prepare Ingredient
   ↓
Pour Into Cup
   ↓
Serve
```

Different step:

- Tea → Add Tea Leaves
- Coffee → Add Coffee Powder

Workflow remains same. Specific step changes.

This is Template Method.

---

## 4. Structure

### UML Thinking

```
           +----------------------+
           | AbstractClass        |
           |----------------------|
           | templateMethod()     |
           | step1()              |
           | step2()              |
           | step3()              |
           +----------------------+
                     ^
                     |
      --------------------------------
      |                              |
      |                              |
+--------------+           +--------------+
| ConcreteA    |           | ConcreteB    |
+--------------+           +--------------+
```

### Components

**1. Abstract Class**

Contains:

- `templateMethod()`

This defines overall workflow.

**2. Concrete Subclasses**

Implement specific steps.

---

## 5. Implementation

### Step 1 — Abstract Class

```java
abstract class ReportGenerator {

    public final void generateReport() {

        loadData();

        processData();

        exportReport();

        sendReport();
    }

    protected abstract void processData();

    private void loadData() {
        System.out.println("Loading Data");
    }

    private void exportReport() {
        System.out.println("Exporting PDF");
    }

    private void sendReport() {
        System.out.println("Sending Report");
    }
}
```

**Why `final`?**

Very important.

```java
public final void generateReport()
```

Prevents subclasses from changing workflow. The algorithm structure must remain fixed.

### Step 2 — Sales Report

```java
class SalesReport extends ReportGenerator {

    @Override
    protected void processData() {
        System.out.println("Processing Sales Data");
    }
}
```

### Step 3 — Inventory Report

```java
class InventoryReport extends ReportGenerator {

    @Override
    protected void processData() {
        System.out.println("Processing Inventory Data");
    }
}
```

### Step 4 — Client

```java
public class Main {

    public static void main(String[] args) {

        ReportGenerator report =
                new SalesReport();

        report.generateReport();
    }
}
```

### Output

```
Loading Data
Processing Sales Data
Exporting PDF
Sending Report
```

---

## 6. Deep Understanding

The most important insight:

- Parent controls workflow
- Child customizes steps

Not:

- Child controls workflow

That's a critical interview point.

### Visual Thinking

```
generateReport()

    |
    +-- loadData()
    |
    +-- processData()   <-- child decides
    |
    +-- exportReport()
    |
    +-- sendReport()
```

---

## 7. Hook Methods

Very common interview topic.

Sometimes a step is optional.

Example:

```java
protected boolean shouldAudit() {
    return false;
}
```

Template:

```java
public final void execute() {

    process();

    if(shouldAudit()) {
        audit();
    }
}
```

Subclass:

```java
@Override
protected boolean shouldAudit() {
    return true;
}
```

This optional extension point is called a **Hook Method**.

---

## 8. Real Industry Examples

### A. Spring Framework

Many Spring classes use Template Method.

Example:

- `JdbcTemplate`
- `RestTemplate`

Huge interview point.

**JdbcTemplate Flow**

```
Open Connection
Execute Query
Handle Result
Close Connection
```

Workflow fixed. You customize query logic. Perfect Template Method.

### B. JUnit

When writing tests:

- `@BeforeEach`
- `@Test`
- `@AfterEach`

Framework controls workflow. You fill specific parts.

### C. Servlet Container

Lifecycle:

- `init()`
- `service()`
- `destroy()`

Container controls flow. Subclass customizes behavior.

### D. ETL Pipelines

```
Extract
Transform
Load
```

Transform step varies. Common enterprise example.

---

## 9. Template Method vs Strategy

This is asked frequently.

**Template Method**

- Uses: **Inheritance**
- Workflow fixed in parent.

**Strategy**

- Uses: **Composition**
- Behavior injected.

| Template Method        | Strategy                     |
| ---------------------- | ---------------------------- |
| Child customizes steps | Choose algorithm dynamically |

### Example

Template:

> Generate Report — fixed workflow.

Strategy:

> Choose Pricing Algorithm — runtime choice.

### Easy Memory Trick

Template Method asks:

> "What steps can child customize?"

Strategy asks:

> "What algorithm should be used?"

---

## 10. Advantages

- **Code Reuse** — common workflow written once.
- **Consistency** — all subclasses follow same process.
- **Enforces Business Rules** — workflow cannot be broken.
- **Reduces Duplication** — huge benefit.

---

## 11. Tradeoffs

- **Inheritance Coupling** — relies on inheritance.
- **Harder to Change Workflow** — parent controls everything.
- **Deep Hierarchies Can Become Messy** — common enterprise problem.

---

## 12. Practice Problems

### Beginner

**1. Beverage Maker**

Workflow:

```
Boil Water
Add Ingredient
Pour
Serve
```

Implement:

- TeaMaker
- CoffeeMaker

**2. Report Generator**

Implement:

- SalesReport
- InventoryReport
- EmployeeReport

**3. Document Export**

Workflow:

```
Load
Format
Export
```

Formats:

- PDF
- CSV
- Excel

### Intermediate

**4. Online Payment Processing**

Workflow:

```
Validate
Process
Notify
```

Implement:

- UPI
- Card
- Wallet

**5. Data Import Pipeline**

Workflow:

```
Read
Validate
Transform
Store
```

Implement:

- CSV Import
- JSON Import
- XML Import

**6. Authentication Flow**

Workflow:

```
Validate Credentials
Authenticate
Generate Token
Audit
```

Implement:

- PasswordAuth
- OAuthAuth
- SSOAuth

### Advanced

**7. DICOM File Processing Pipeline**

Very relevant to your project.

Workflow:

```
Receive File
Validate DICOM
Extract Metadata
Store Study
Send Notification
```

Different modalities:

- CT
- MRI
- Ultrasound

can customize extraction logic.

**8. Healthcare Worklist Processing**

Workflow:

```
Receive Worklist
Validate
Transform
Persist
Publish Event
```

Different providers:

- Provider A
- Provider B
- Provider C

override transformation step.

**9. ETL Engine**

Workflow:

```
Extract
Transform
Load
Audit
```

Different data sources implement transform differently.

### Mini Project Challenge 

Build:

**File Import Framework**

Workflow:

```
Read File
Validate
Parse
Store
Generate Summary
```

Implement:

- CSVImporter
- JSONImporter
- XMLImporter
- ExcelImporter

Use Template Method.

---

## Revision Summary

### Core Idea

```
Fixed Workflow
       +
Customizable Steps
       =
Template Method Pattern
```

### Mental Model

- Parent owns algorithm
- Child fills gaps

### Use When

Use Template Method when:

- workflow is fixed
- some steps vary
- code duplication exists
- business process must be enforced
- inheritance is acceptable

### One-Line Definition

Template Method defines an algorithm skeleton in a base class and allows subclasses to customize specific steps without changing the algorithm structure.
