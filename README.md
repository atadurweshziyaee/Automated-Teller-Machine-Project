# 💳 Banking Management System (ATM) 🏦💻

## 📌 About the System
The **Banking Management System (ATM)** is designed to manage basic banking operations, such as withdrawals, deposits, balance inquiries, mini statements, and user registrations. It provides a **secure and user-friendly interface** for both customers and bank administrators. This system simulates real-world ATM operations and ensures **data security** through ATM card numbers and PIN authentication. 🔐

---

## 🚀 Features
✔️ **Withdraw Funds** – Users can withdraw money from their account. 💵  
✔️ **Deposit Funds** – Allows users to deposit money into their accounts. 💰  
✔️ **Balance Inquiry** – View current account balance. 📊  
✔️ **Mini Statement** – View recent transactions made in the account. 📃  
✔️ **New User Registration** – Register new users by creating an ATM card and PIN. 📝  
✔️ **Secure Login System** – User login via ATM card and PIN for enhanced security. 🔒  
✔️ **User-Friendly GUI** – A simple interface for easy navigation and transactions. 🎨

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| ![Java](https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg) **Java** | Core logic using OOP principles for backend operations. |
| ![Swing](https://upload.wikimedia.org/wikipedia/commons/7/76/Swing-logo.png) **GUI (Swing, AWT)** | Graphical user interface for user interaction. |
| ![MySQL](https://upload.wikimedia.org/wikipedia/en/thumb/6/62/MySQL.svg/128px-MySQL.svg.png) **MySQL** | Database for storing user and transaction details. |
| ![IntelliJ IDEA](https://upload.wikimedia.org/wikipedia/commons/d/d5/IntelliJ_IDEA_Logo.svg) **IntelliJ IDEA** | Development & debugging environment for Java code. |

---

## 📥 Installation & Setup
1️⃣ **Clone the repository**:
```bash
 git clone https://github.com/atadurweshziyaee/BankingManagementSystem.git
```
2️⃣ Install Java Development Kit (JDK) – Make sure JDK 8 or higher is installed.
3️⃣ Install MySQL – Set up the database and create the necessary tables:
```
CREATE DATABASE banking_system;
USE banking_system;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    card_number VARCHAR(16) NOT NULL,
    pin VARCHAR(4) NOT NULL,
    balance DECIMAL(10, 2) DEFAULT 0.00
);
```
4️⃣ Run the application – You can either use an IDE (like IntelliJ IDEA) or compile the code from the command line to run the application.

## 💡 Conclusion
The Banking Management System (ATM) offers a simple yet secure way to manage banking operations, providing essential features like withdrawals, deposits, and balance checking. This system is ideal for simulating real-world ATM functionalities, focusing on data security, simplicity, and user experience. 🏦✨

## 🤝 Contribute & Improve! 🚀
Want to enhance this project? Fork the repo, add improvements, and submit a pull request! 💡
