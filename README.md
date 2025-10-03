# **RAIT Library Management System**

This document provides a comprehensive overview of the RAIT Library Management System, a full-stack application designed for educational and practical use. It is intended to help project members understand the architecture, technologies, and core functionalities.

## **Table of Contents**

1. [Project Overview](https://www.google.com/search?q=%23project-overview)  
2. [Technology Stack](https://www.google.com/search?q=%23technology-stack)  
3. [Setup and Installation](https://www.google.com/search?q=%23setup-and-installation)  
4. [Project Structure Explained](https://www.google.com/search?q=%23project-structure-explained)  
   * [Frontend (capstone)](https://www.google.com/search?q=%23frontend-capstone)  
   * [Auth Service (auth-service)](https://www.google.com/search?q=%23auth-service-auth-service)  
   * [Library Service (library\_service)](https://www.google.com/search?q=%23library-service-library_service)  
   * [Payment Service (payment-service)](https://www.google.com/search?q=%23payment-service-payment-service)

## **Project Overview**

This application provides a seamless experience for library users. Key features include:

* **User Authentication**: Secure registration and login for users.  
* **Book Catalog**: A browsable, searchable, and filterable list of all library books with pagination.  
* **Borrowing System**: Users can borrow and return books from their dashboard.  
* **Fine System**: Automatic fine calculation for overdue books.  
* **Payment Integration**: Pay fines online using Razorpay.

The project is split into four main parts: a frontend application and three backend microservices. This separation is a professional practice that makes the application more scalable and easier to manage.

## **Technology Stack**

This project uses a modern and powerful set of technologies:

* **Frontend**:  
  * **Next.js**: A React framework for building fast, user-friendly web applications.  
  * **React**: A JavaScript library for building user interfaces.  
  * **Redux Toolkit**: For managing the application's global state (like user login status).  
  * **Tailwind CSS**: A utility-first CSS framework for rapid styling.  
  * **GSAP (GreenSock Animation Platform)**: For creating smooth, high-performance animations.  
* **Backend**:  
  * **Node.js & Express.js**: Used for the Auth and Payment services.  
  * **Java & Spring Boot**: Used for the main Library service that handles books and borrowing.  
  * **JWT (JSON Web Tokens)**: For securing the application and authenticating users.  
* **Databases**:  
  * **MongoDB**: A NoSQL database used for storing user information.  
  * **PostgreSQL**: A relational database used for storing book and borrowing records.

## **Setup and Installation**

To run this project on your local machine, you'll need a few prerequisites: **Node.js**, **Java (JDK 17+)**, **Maven**, **MongoDB**, and **PostgreSQL**.

Please refer to the SETUP\_INSTRUCTIONS.md file in the root directory for a detailed, step-by-step guide on how to get all the services and the frontend application running.

## **Project Structure Explained**

Here we'll break down the most important files in each service.

### **Frontend (capstone)**

This is the Next.js application that users see and interact with in their browser.

#### **capstone/services/api.js**

**Purpose**: This file centralizes all communication with our backend microservices. Instead of writing API calls in every component, we define them once here.

import axios from 'axios';

// Defines the base URLs for each of our microservices.  
const API\_URLS \= {  
  auth: 'http://localhost:3001/api/auth',  
  books: 'http://localhost:8080/api',  
  payments: 'http://localhost:3002/api/payments',  
};

// \--- Auth Service Calls \---  
export const loginUser \= (credentials) \=\> axios.post(\`${API\_URLS.auth}/login\`, credentials);  
export const registerUser \= (userData) \=\> axios.post(\`${API\_URLS.auth}/register\`, userData);

// \--- Book Service Calls \---  
// ... and so on for other API calls

#### **capstone/lib/authSlice.js**

**Purpose**: This file defines a "slice" of our Redux state for authentication. This slice manages the user's login status, token, and user information.

import { createSlice } from '@reduxjs/toolkit';

const initialState \= {  
  token: null,  
  isAuthenticated: false,  
  user: null,  
};

const authSlice \= createSlice({  
  name: 'auth',  
  initialState,  
  reducers: {  
    // Action for when a user successfully logs in.  
    setCredentials: (state, action) \=\> {  
      const { token, user } \= action.payload;  
      state.token \= token;  
      state.user \= user;  
      state.isAuthenticated \= true;  
    },  
    // Action for when a user logs out.  
    logout: (state) \=\> {  
      state.token \= null;  
      state.user \= null;  
      state.isAuthenticated \= false;  
    },  
  },  
});

export const { setCredentials, logout } \= authSlice.actions;  
export default authSlice.reducer;

### **Auth Service (auth-service)**

This Node.js microservice handles everything related to user accounts.

#### **auth-service/routes/auth.js**

**Purpose**: This file defines the API endpoints for registration and login.

// POST /api/auth/register  
router.post('/register', async (req, res) \=\> {  
    // ... logic to check for existing user, hash password, and save new user to MongoDB  
});

// POST /api/auth/login  
router.post('/login', async (req, res) \=\> {  
    // ... logic to find user, compare password, and generate a JWT token  
});

### **Library Service (library\_service)**

The core microservice, built with Java and Spring Boot. It manages all library operations.

#### **library\_service/src/main/java/com/rait/library\_service/BorrowingController.java**

**Purpose**: This is the API "entry point" for the library service. It defines the API routes and links them to the business logic in BorrowingService.

@RestController  
@RequestMapping("/api")  
public class BorrowingController {  
    // ... autowired BorrowingService

    @GetMapping("/books")  
    public Page\<Book\> getAllBooks(...) { /\* ... \*/ }

    @PostMapping("/books/{id}/borrow")  
    public ResponseEntity\<?\> borrowBook(...) { /\* ... \*/ }

    @PostMapping("/records/{id}/return")  
    public ResponseEntity\<?\> returnBook(...) { /\* ... \*/ }  
}

#### **library\_service/src/main/java/com/rait/library\_service/BorrowingService.java**

**Purpose**: This file contains the core business logic. It's where the rules for borrowing, returning, and fine calculation are implemented.

@Service  
@Transactional  
public class BorrowingService {  
    // ... autowired repositories

    public BorrowingRecord borrowBook(Long bookId, String userId) {  
        // ... logic to find book, check availability, update status, create borrowing record  
    }

    public BorrowingRecord returnBook(Long recordId, String userId) {  
        // ... logic to find record, calculate fines if late, update book availability  
    }  
}

### **Payment Service (payment-service)**

A small Node.js microservice that handles integration with the Razorpay payment gateway.

#### **payment-service/routes/payment.js**

**Purpose**: Defines the API endpoint that communicates with Razorpay to create a payment order.

// POST /api/payments/create-order  
router.post('/create-order', async (req, res) \=\> {  
    // ... logic to initialize Razorpay client and create an order  
});  
