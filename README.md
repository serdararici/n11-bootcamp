# n11-bootcamp
N11 TalentHub Backend Bootcamp practice repository


# 💳 Payment System – SOLID Bootcamp Project

This project is a simple console-based payment processing system developed as part of the N11 TalentHub Backend Bootcamp.  
The main goal of this project is to practice **SOLID principles**, **design patterns**, and clean backend architecture using Java.

---

## 🚀 Features

- Console-based user interaction
- Multiple payment methods support
- Extensible architecture (easy to add new payment methods)
- Logging system (Console-based logger)
- Input validation and exception handling
- Continuous payment loop (multiple transactions)

---

## 🧱 Architecture Overview

The project is designed with a layered and modular structure:

### 📦 Main Components

- **PaymentMethod (Interface)**  
  Defines the contract for all payment types.

- **CreditCardPayment / PayPalPayment**  
  Concrete implementations of payment methods.

- **PaymentFactory**  
  Responsible for creating payment method instances (Factory Pattern).

- **PaymentService**  
  Core business logic layer that handles:
  - Payment validation
  - Payment execution
  - Logging operations

- **Logging System**
  - AbstractLogger (base class)
  - ConsoleLogger (implementation)

---

## 🧠 Applied Design Principles

### ✅ SOLID Principles

- **S (Single Responsibility Principle)**  
  Each class has a single responsibility (payment, logging, creation, etc.)

- **O (Open/Closed Principle)**  
  New payment methods can be added without modifying existing code.

- **L (Liskov Substitution Principle)**  
  All payment methods are interchangeable via `IPaymentMethod`.

- **I (Interface Segregation Principle)**  
  Payment behavior is separated from other concerns.

- **D (Dependency Inversion Principle)**  
  `PaymentService` depends on abstractions (`IPaymentMethod`, `AbstractLogger`), not concrete classes.

---

### 🏭 Design Patterns Used

- **Factory Pattern** → Payment object creation is centralized
- **Strategy Pattern (implicit)** → Different payment methods behave independently

---

## ⚙️ How It Works

1. User selects a payment method from console
2. User enters the payment amount
3. `PaymentFactory` creates the appropriate payment method
4. `PaymentService` processes the payment
5. Logger records each step of the process

---

## 📌 Example Flow


Select Payment Method:
1 - Credit Card
2 - PayPal
0 - Exit

Your choice: 1
Enter amount: 100

Processing payment...

Payment completed successfully!


---

## ⚠️ Validation Rules

- Payment amount must be greater than 0
- Payment method must be valid
- Invalid inputs are handled safely with exception handling

---

## 🛠️ Technologies Used

- Java 21
- OOP (Object-Oriented Programming)
- SOLID Principles
- Design Patterns (Factory, Strategy)
- Console I/O

---

## 📁 Project Structure


com.n11.bootcamp.payment
├── Main.java
├── factory/
│ └── PaymentFactory.java
├── payment/
│ ├── IPaymentMethod.java
│ ├── CreditCardPayment.java
│ └── PayPalPayment.java
├── service/
│ └── PaymentService.java
├── logging/
│ ├── AbstractLogger.java
│ └── ConsoleLogger.java


---

## 📈 Future Improvements

- Add more payment methods (Apple Pay, Crypto, etc.)
- Replace console logger with file/database logger
- Add transaction ID (UUID)
- Improve UI with richer console interaction
- Introduce Spring Boot version of the system

---

## 👨‍💻 Author

Developed as part of **N11 TalentHub Backend Bootcamp**  
Focused on learning clean code, SOLID principles, and backend design fundamentals.

---
