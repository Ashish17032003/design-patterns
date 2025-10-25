## BehavioralDesignPatterns.Observer
1. When one object changes, it notifies all registered (subscribed) observers automatically.
2. BehavioralDesignPatterns.Observer Interface ( what all subscribers must do )
3. Concrete BehavioralDesignPatterns.Observer -> Actual Subscriber  
(  Each Concrete BehavioralDesignPatterns.Observer must implement update() to define how it reacts to change )
4. Subject Interface
5. Concrete Subject 
6. Client
# 🧩 BehavioralDesignPatterns.Observer Design Pattern

## 🧠 Concept

The **BehavioralDesignPatterns.Observer Pattern** defines a **one-to-many relationship** between objects.  
When **one object (Subject)** changes state, **all its dependents (Observers)** are automatically notified and updated.

> “When one changes, everyone watching gets notified.”

---

## ⚙️ Structure

### 1. **Subject (Publisher)**
- Holds a list of observers.
- Provides methods to **attach**, **detach**, and **notify** observers.
- When its state changes → it calls `notifyObservers()`.

### 2. **BehavioralDesignPatterns.Observer (Subscriber)**
- Defines an interface with an `update()` method.
- Gets notified by the subject when a change occurs.

### 3. **ConcreteSubject**
- Actual class whose state is being observed.
- Calls `notifyObservers()` whenever its internal data changes.

### 4. **ConcreteObserver**
- Implements the `update()` method.
- Responds to changes from the subject.

---

## 🧩 UML-like Flow

