# 🏺 Antique Shop Management System

## 📌 Overview
The Antique Shop Management System is a desktop-based application developed using Java (NetBeans IDE) and SQL database. It is designed to help manage daily operations of an antique shop, including inventory tracking, product management, sales records, and customer information in an efficient and organized way.

This system replaces manual record-keeping with a digital solution, improving accuracy, speed, and reliability.

## 🚀 Features
- Manage antique product inventory (add, update, delete, view items)
- Customer management system
- Sales and billing management
- Stock tracking and updates
- Search functionality for products and customers
- Basic reporting for sales and inventory status
- Secure database connectivity using SQL

## 🛠️ Technologies Used
- Programming Language: Java
- IDE: NetBeans
- Database: MySQL / SQL Server
- Database Connectivity: JDBC




## ⚙️ Installation & Setup

### 1. Clone the Repository
git clone <your-repository-link>

### 2. Open in NetBeans
- Open NetBeans IDE
- Click File → Open Project
- Select the project folder

### 3. Database Setup
Open your SQL tool (MySQL Workbench / phpMyAdmin / SQL Server) and run:

CREATE DATABASE antique_shop;

Then import the .sql file from the database folder.

### 4. Configure Database Connection
Update your JDBC connection in the Java code:

Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/antique_shop",
    "root",
    "your_password"
);

### 5. Run the Project
- Click Run Project in NetBeans
- Start managing your antique shop system



## 👨‍🎓 Author
Developed by: Ramisa Ali Salwa


## 📜 License
This project is for educational purposes only.
