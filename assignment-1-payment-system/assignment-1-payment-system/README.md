# 💳 Payment System – Advanced SOLID Bootcamp Project

This project is a sophisticated console-based payment processing system developed as part of the **N11 TalentHub Backend Bootcamp**. It demonstrates high-level software architecture by combining **SOLID principles** with advanced **Design Patterns** and **Java Reflection API**.

---

## 🚀 Key Features & Advanced Implementations

- **Dynamic Object Creation:** Utilizes **Java Reflection** to instantiate payment methods, achieving strict adherence to the **Open/Closed Principle (OCP)**.
- **Decoupled Validation:** Implements the **Chain of Responsibility (CoR)** pattern to handle business rules (amount checks, null checks) independently from the core service logic.
- **Data-Driven Configuration:** Selection logic is managed via `Map` structures, completely eliminating traditional `if-else` or `switch` blocks in the UI layer.
- **Unified Logging:** Integrated `AbstractLogger` across all layers, including the validation chain, injected via **Dependency Injection**.
- **High Extensibility:** New payment methods can be integrated by simply adding a new class and updating a map entry—no modification to the Factory or Service logic is required.

---

## 🧱 Architecture Overview

The project follows a modular, layered architecture to ensure "Separation of Concerns":

### 📦 Key Components

- **IPaymentMethod (Interface):** Defines the contract for all payment strategies.
- **PaymentFactory:** A dynamic factory that uses **Reflection** to load and instantiate payment classes at runtime.
- **PaymentService:** The orchestrator that triggers the validation chain and executes the payment.
- **Validation Chain (CoR):**
  - `AmountValidator`: Validates if the payment amount is positive.
  - `MethodValidator`: Ensures the payment method instance is correctly initialized.
- **Logging System:** An abstracted logging mechanism injected into both the Service and the Validation handlers.

---

## 🧠 Applied Design Principles & Patterns

### ✅ SOLID Principles
- **S (Single Responsibility):** Validation, Logging, Object Creation, and Execution are encapsulated in their respective specialized classes.
- **O (Open/Closed):** Implementation of **Reflection** in the factory ensures the system is open for expansion but closed for modification.
- **D (Dependency Inversion):** `PaymentService` and `Validators` depend on abstractions (`IPaymentMethod`, `AbstractLogger`), not on concrete implementations.

### 🏭 Design Patterns
- **Factory Pattern (Reflection-based):** Removes conditional logic for object creation, making the factory truly generic.
- **Chain of Responsibility:** Decouples the validation logic into a chain of independent handlers, making it easy to add or remove business rules.
- **Strategy Pattern:** Encapsulates different payment algorithms (Credit Card, PayPal) behind a common interface.

---

## ⚙️ How It Works

1. **Mapping:** User selection is mapped to a specific class name via a configuration `Map`.
2. **Dynamic Creation:** `PaymentFactory` uses **Reflection** to find and instantiate the class in the `payment` package.
3. **Chain Validation:** `PaymentService` passes the data through the `ValidatorChain`. Each handler logs its own step.
4. **Execution:** If all validation handlers pass, the payment strategy is executed.

---

## 📌 Example Flow

```text
Select Payment Method:
1 - Credit Card
2 - PayPal
0 - Exit

Your choice: 1
Enter amount: 100

[LOG] --- Payment process started ---
[LOG] [VALIDATION] Checking payment amount: 100.0
[LOG] [VALIDATION] Checking payment method instance.
Processing payment via Credit Card...
[LOG] --- Payment process completed ---
```

🛠️ Installation & Running
Clone the repository:

Bash```
git clone [https://github.com/your-username/n11-bootcamp.git](https://github.com/your-username/n11-bootcamp.git)
Navigate to the project directory:
```

Bash```
cd n11-bootcamp
Compile the project:
```

Bash```
javac Main.java
Run the application:
```

Bash```
java Main
```
---

📁 Project Structure
Plaintext
com.n11.bootcamp.payment
├── Main.java                # Application entry point with Map configuration
├── factory/
│   └── PaymentFactory.java  # Reflection-based Dynamic Factory
├── payment/
│   ├── IPaymentMethod.java  # Strategy Abstraction
│   ├── CreditCardPayment.java
│   └── PayPalPayment.java
├── service/
│   ├── PaymentService.java  # Core Orchestrator
│   └── validation/          # Chain of Responsibility Package
│       ├── PaymentValidator.java
│       ├── AmountValidator.java
│       └── MethodValidator.java
└── logging/
    ├── AbstractLogger.java  # Logging Abstraction
    └── ConsoleLogger.java   # Concrete Logger Implementation
	
---
👨‍💻 Author
Serdar Arıcı – Computer Engineering Graduate

Developed for the N11 TalentHub Backend Bootcamp.