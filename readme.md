##  Student Management System (Java CLI)

A simple and efficient **Student Management System** built using **Java** and designed for practicing Object-Oriented Programming through a **Command-Line Interface (CLI)**.
The system provides full **CRUD operations** with clean modular design and multi-class architecture.

---

##  Project Structure

```
├── Main.java              # Entry point with interactive menu
├── Student.java           # Student class (inherits from Person)
├── Person.java            # Abstract class for shared attributes
├── StudentInterface.java  # Interface defining CRUD methods
└── StudentManager.java    # Implements CRUD logic with ArrayList
```

---

## ✨ Features

* ➕ Add new students
* 📄 View all students
* 🔍 Search students by ID
* ✏️ Update student details
* ❌ Delete a student
* ✔️ Score validation (0–100)
* 🧠 Follows OOP principles: Inheritance, Polymorphism, Interfaces, Abstraction

---

## 🔧 How to Run

### **1. Compile the program**

```bash
javac *.java
```

### **2. Run it**

```bash
java Main
```

---

## 🛠 Technologies Used

* **Java 17+**
* **Command-Line Interface (CLI)**
* **Object-Oriented Programming**

---

## 🧪 Program Flow (Example)

1. Run program: `java Main`
2. System displays a menu
3. User adds student → validation ensures correct input
4. Students can be viewed, edited, searched, or deleted
5. Delete operation asks for confirmation

---

