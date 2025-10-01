# **RAIT Library Management System**

This is a guide I made to help my other members understand this project
this guide will MAKE you understand the basics, find out what some code-lines and components do, and help you prepare for the viva.

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

Please refer to the SET UP INSTRUCTIONS.pdf file in the root directory for a detailed, step-by-step guide on how to get all the services and the frontend application running.

## **Project Structure Explained**

Here we'll break down the most important files in each service, including their full code and a detailed explanation.

### **Frontend (capstone)**

This is the Next.js application that users see and interact with in their browser.

#### **capstone/services/api.js**

**Purpose**: This is one of the most important frontend files. It centralizes all communication with our backend microservices. Instead of writing fetch or axios calls in every component, we define them once here. This makes the code cleaner and easier to maintain.

import axios from 'axios';

// Defines the base URLs for each of our microservices. This makes it easy  
// to change a server's address in one place if needed.  
const API\_URLS \= {  
  auth: 'http://localhost:3001/api/auth',  
  books: 'http://localhost:8080/api',  
  payments: 'http://localhost:3002/api/payments',  
};

// \--- Auth Service Calls \---

// Sends a POST request to the auth service to log a user in.  
export const loginUser \= (credentials) \=\> axios.post(\`${API\_URLS.auth}/login\`, credentials);  
// Sends a POST request to the auth service to register a new user.  
export const registerUser \= (userData) \=\> axios.post(\`${API\_URLS.auth}/register\`, userData);

// \--- Book Service Calls \---

// Fetches a "page" of books, supporting our pagination feature.  
export const getBooks \= (page \= 0, size \= 10\) \=\> axios.get(\`${API\_URLS.books}/books?page=${page}\&size=${size}\`);  
// Fetches a single book by its ID.  
export const getBookById \= (id) \=\> axios.get(\`${API\_URLS.books}/books/${id}\`);

// A helper function to create the authorization headers required by the library service.  
// The backend needs to know which user is making the request, so we send the user's ID  
// in the 'X-User-Id' header.  
const getAuthHeaders \= (userId) \=\> ({ headers: { 'X-User-Id': userId } });

// Sends a POST request to borrow a book. The \`null\` is because we don't need to send a request body.  
export const borrowBook \= (bookId, userId) \=\> axios.post(\`${API\_URLS.books}/books/${bookId}/borrow\`, null, getAuthHeaders(userId));  
// Sends a POST request to return a book associated with a specific borrowing record.  
export const returnBook \= (recordId, userId) \=\> axios.post(\`${API\_URLS.books}/records/${recordId}/return\`, null, getAuthHeaders(userId));  
// Fetches all borrowing records for the currently logged-in user.  
export const getUserRecords \= (userId) \=\> axios.get(\`${API\_URLS.books}/users/me/records\`, getAuthHeaders(userId));  
// Sends a POST request to tell the backend that a fine has been paid.  
export const markFineAsPaid \= (recordId, userId) \=\> axios.post(\`${API\_URLS.books}/records/${recordId}/mark-paid\`, null, getAuthHeaders(userId));

// \--- Payment Service Calls \---

// Sends a POST request to the payment service to create a Razorpay payment order.  
export const createPaymentOrder \= (fineData) \=\> axios.post(\`${API\_URLS.payments}/create-order\`, fineData);

#### **capstone/lib/authSlice.js**

**Purpose**: This file defines a "slice" of our Redux state for authentication. Redux is like a central data store for our app. This slice manages everything related to the user's login status, token, and user information.

import { createSlice } from '@reduxjs/toolkit';

// This is the initial state, what the auth data looks like when the app first loads.  
const initialState \= {  
  token: null,  
  isAuthenticated: false,  
  user: null,  
};

const authSlice \= createSlice({  
  name: 'auth', // The name of this slice.  
  initialState,  
  // Reducers are functions that define how the state can change.  
  reducers: {  
    // This action is called when a user successfully logs in.  
    setCredentials: (state, action) \=\> {  
      const { token, user } \= action.payload; // We get the token and user from the action.  
      state.token \= token;  
      state.user \= user;  
      state.isAuthenticated \= true; // Set isAuthenticated to true.  
    },  
    // This action is called when a user logs out.  
    logout: (state) \=\> {  
      state.token \= null;  
      state.user \= null;  
      state.isAuthenticated \= false; // Reset the state to its initial values.  
    },  
  },  
});

// We export the actions so our components can use them to change the state.  
export const { setCredentials, logout } \= authSlice.actions;  
// We export the reducer so it can be added to our main Redux store.  
export default authSlice.reducer;

#### **capstone/src/app/dashboard/page.js**

**Purpose**: This page serves as the user's personal dashboard. It fetches and displays all the books they have currently borrowed and any overdue books with fines. It also allows them to return books and pay fines.

'use client';  
import { useEffect, useState, useCallback } from 'react';  
import { useSelector } from 'react-redux';  
import { useRouter } from 'next/navigation';  
import { getUserRecords, returnBook, createPaymentOrder, markFineAsPaid } from '@/services/api';

export default function DashboardPage() {  
  const { isAuthenticated, user } \= useSelector((state) \=\> state.auth);  
  const router \= useRouter();  
  const \[records, setRecords\] \= useState(\[\]);  
  const \[loading, setLoading\] \= useState(true);  
  const \[error, setError\] \= useState(null);  
  const \[success, setSuccess\] \= useState(null);  
  const \[returningId, setReturningId\] \= useState(null);

  const fetchRecords \= useCallback(async () \=\> {  
    try {  
      if (user?.userId) {  
        const response \= await getUserRecords(user.userId);  
        setRecords(response.data);  
      }  
    } catch (err) {  
      console.error('Failed to fetch records:', err);  
      setError('Could not load your records.');  
    } finally {  
      setLoading(false);  
    }  
  }, \[user\]);

  useEffect(() \=\> {  
    if (\!isAuthenticated) {  
      router.push('/login');  
    } else {  
      fetchRecords();  
    }  
  }, \[isAuthenticated, router, fetchRecords\]);

  const handleReturn \= async (recordId) \=\> {  
    setReturningId(recordId);  
    setError(null);  
    setSuccess(null);  
    try {  
      await returnBook(recordId, user.userId);  
      setSuccess('Book returned successfully\!');  
      fetchRecords();  
    } catch (err) {  
      setError('Failed to return book.');  
    } finally {  
      setReturningId(null);  
    }  
  };  
    
  const handlePayFine \= async (record) \=\> {  
    if (\!document.getElementById('razorpay-checkout-js')) {  
        const script \= document.createElement('script');  
        script.id \= 'razorpay-checkout-js';  
        script.src \= "\[https://checkout.razorpay.com/v1/checkout.js\](https://checkout.razorpay.com/v1/checkout.js)";  
        document.body.appendChild(script);  
        await new Promise(resolve \=\> script.onload \= resolve);  
    }  
      
    try {  
        const { data: order } \= await createPaymentOrder({  
            amount: record.fine \* 100,  
            currency: 'INR',  
            receipt: \`receipt\_fine\_${record.id}\`,  
            notes: { bookId: record.book.id, userId: user.userId, recordId: record.id }  
        });  
          
        const options \= {  
            key: process.env.NEXT\_PUBLIC\_RAZORPAY\_KEY\_ID,  
            amount: order.amount,  
            currency: order.currency,  
            name: "RAIT Library Fine",  
            description: \`Fine for: ${record.book.title}\`,  
            order\_id: order.id,  
            handler: async (response) \=\> {  
                try {  
                  await markFineAsPaid(record.id, user.userId);  
                  setSuccess(\`Payment successful\! The fine has been cleared.\`);  
                  setError(null);  
                  fetchRecords();  
                } catch (err) {  
                   setError("Payment was successful, but there was an error updating our records.");  
                }  
            },  
            prefill: { name: "Library User", email: user.email },  
            theme: { color: "\#000000" }  
        };  
          
        const rzp \= new window.Razorpay(options);  
        rzp.open();  
    } catch (err) {  
        setError("Could not initiate payment.");  
    }  
  };  
  // ... JSX to render the page is omitted for brevity ...  
}

### **Auth Service (auth-service)**

This Node.js microservice handles everything related to user accounts.

#### **auth-service/routes/auth.js**

**Purpose**: This file defines the actual API endpoints for authentication. It's the heart of the auth-service.

const express \= require('express');  
const bcrypt \= require('bcryptjs');  
const jwt \= require('jsonwebtoken');  
const User \= require('../models/User');  
const router \= express.Router();

// Route: POST /api/auth/register  
router.post('/register', async (req, res) \=\> {  
    try {  
        const { email, password } \= req.body;  
        if (\!email || \!password) {  
            return res.status(400).send('Email and password are required.');  
        }  
        const existingUser \= await User.findOne({ email });  
        if (existingUser) {  
            return res.status(400).send('User with this email already exists.');  
        }

        // We never store passwords in plain text. We "hash" them first.  
        const salt \= await bcrypt.genSalt(10);  
        const hashedPassword \= await bcrypt.hash(password, salt);  
        const user \= new User({ email, password: hashedPassword });

        await user.save();  
        res.status(201).send('User created successfully.');  
    } catch (error) {  
        res.status(500).send('Server error during registration.');  
    }  
});

// Route: POST /api/auth/login  
router.post('/login', async (req, res) \=\> {  
    try {  
        const { email, password } \= req.body;  
        const user \= await User.findOne({ email });  
        if (\!user) {  
            return res.status(400).send('Invalid credentials.');  
        }

        // Use bcrypt to compare the plain-text password from the request  
        // with the hashed password stored in the database.  
        const isMatch \= await bcrypt.compare(password, user.password);  
        if (\!isMatch) {  
            return res.status(400).send('Invalid credentials.');  
        }

        // If the passwords match, we create a JSON Web Token (JWT).  
        // This token is a secure string that the frontend can save and send  
        // with future requests to prove that the user is logged in.  
        const token \= jwt.sign(  
            { userId: user.\_id, email: user.email }, // The data we want to store in the token  
            process.env.JWT\_SECRET, // A secret key to sign the token  
            { expiresIn: '1h' } // The token will be invalid after one hour  
        );  
          
        // We send the token and some basic user info back to the frontend.  
        res.json({   
            token,   
            user: {  
                userId: user.\_id,  
                email: user.email  
            }  
        });

    } catch (error) {  
        res.status(500).send('Server error during login.');  
    }  
});

module.exports \= router;

### **Library Service (library\_service)**

This is the largest and most important microservice, built with Java and Spring Boot. It manages all the core library operations.

#### **library\_service/src/main/java/com/rait/library\_service/BorrowingController.java**

**Purpose**: This is the API "entry point" for the library service. It uses annotations to define the API routes and links them to the business logic in BorrowingService.

package com.rait.library\_service;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.data.domain.Page;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.\*;  
import java.util.List;

@RestController // Tells Spring this class defines API endpoints.  
@RequestMapping("/api") // All routes in this class will start with /api.  
public class BorrowingController {

    @Autowired // Spring automatically provides an instance of BorrowingService.  
    private BorrowingService borrowingService;

    // Defines a GET endpoint at /api/books  
    @GetMapping("/books")  
    public Page\<Book\> getAllBooks(@RequestParam(defaultValue \= "0") int page,  
                                  @RequestParam(defaultValue \= "10") int size) {  
        return borrowingService.getAllBooks(page, size);  
    }

    @GetMapping("/books/{id}")  
    public ResponseEntity\<Book\> getBookById(@PathVariable Long id) {  
        return borrowingService.getBookById(id)  
                .map(ResponseEntity::ok)  
                .orElse(ResponseEntity.notFound().build());  
    }

    // Defines a POST endpoint at /api/books/{id}/borrow  
    @PostMapping("/books/{id}/borrow")  
    public ResponseEntity\<?\> borrowBook(@PathVariable Long id, @RequestHeader("X-User-Id") String userId) {  
        try {  
            return ResponseEntity.ok(borrowingService.borrowBook(id, userId));  
        } catch (IllegalStateException e) {  
            return ResponseEntity.badRequest().body(e.getMessage());  
        }  
    }

    // Defines a POST endpoint at /api/records/{id}/return  
    @PostMapping("/records/{id}/return")  
    public ResponseEntity\<?\> returnBook(@PathVariable Long id, @RequestHeader("X-User-Id") String userId) {  
        try {  
            return ResponseEntity.ok(borrowingService.returnBook(id, userId));  
        } catch (IllegalStateException e) {  
            return ResponseEntity.badRequest().body(e.getMessage());  
        }  
    }

    // Defines a GET endpoint at /api/users/me/records  
    @GetMapping("/users/me/records")  
    public ResponseEntity\<List\<BorrowingRecord\>\> getUserRecords(@RequestHeader("X-User-Id") String userId) {  
        return ResponseEntity.ok(borrowingService.getUserRecords(userId));  
    }

    // Defines a POST endpoint at /api/records/{id}/mark-paid  
    @PostMapping("/records/{id}/mark-paid")  
    public ResponseEntity\<?\> markFineAsPaid(@PathVariable Long id, @RequestHeader("X-User-Id") String userId) {  
        try {  
            borrowingService.markFineAsPaid(id, userId);  
            return ResponseEntity.ok().body("{\\"message\\": \\"Fine marked as paid.\\"}");  
        } catch (IllegalStateException e) {  
            return ResponseEntity.badRequest().body(e.getMessage());  
        }  
    }  
}

#### **library\_service/src/main/java/com/rait/library\_service/BorrowingService.java**

**Purpose**: This file contains the core business logic of the application. It's where the rules for borrowing, returning, and fine calculation are implemented.

package com.rait.library\_service;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  
import java.time.LocalDate;  
import java.time.temporal.ChronoUnit;  
import java.util.List;  
import java.util.Optional;

@Service // Tells Spring that this is a service class containing business logic.  
@Transactional // Ensures that database operations are handled safely. If one part fails, the whole operation is rolled back.  
public class BorrowingService {

    @Autowired  
    private BookRepository bookRepository;

    @Autowired  
    private BorrowingRecordRepository borrowingRecordRepository;

    public BorrowingRecord borrowBook(Long bookId, String userId) {  
        // Find the book in the database or throw an error if it doesn't exist.  
        Book book \= bookRepository.findById(bookId)  
                .orElseThrow(() \-\> new IllegalStateException("Book not found."));  
        if (\!book.isAvailable()) {  
            throw new IllegalStateException("Book is not available for borrowing.");  
        }  
        // Update the book's status and save it.  
        book.setAvailable(false);  
        bookRepository.save(book);

        // Create a new record for this borrowing event.  
        BorrowingRecord record \= new BorrowingRecord();  
        record.setUserId(userId);  
        record.setBook(book);  
        record.setStatus(BorrowingRecord.Status.BORROWED);  
        record.setBorrowDate(LocalDate.now());  
        record.setDueDate(LocalDate.now().plusDays(14)); // Due in 14 days.  
        return borrowingRecordRepository.save(record);  
    }

    public BorrowingRecord returnBook(Long recordId, String userId) {  
        BorrowingRecord record \= borrowingRecordRepository.findByIdAndUserId(recordId, userId)  
                .orElseThrow(() \-\> new IllegalStateException("Borrowing record not found."));  
          
        record.setReturnDate(LocalDate.now());

        // Check if the book is being returned after its due date.  
        if (record.getReturnDate().isAfter(record.getDueDate())) {  
            // Calculate the number of days it's overdue.  
            long overdueDays \= ChronoUnit.DAYS.between(record.getDueDate(), record.getReturnDate());  
            // Calculate the fine (10.0 per day).  
            record.setFine(overdueDays \* 10.0);  
            record.setStatus(BorrowingRecord.Status.RETURNED\_LATE);  
        } else {  
            record.setStatus(BorrowingRecord.Status.RETURNED);  
        }  
          
        // Make the book available again for other users.  
        Book book \= record.getBook();  
        book.setAvailable(true);  
        bookRepository.save(book);  
        return borrowingRecordRepository.save(record);  
    }

    public BorrowingRecord markFineAsPaid(Long recordId, String userId) {  
        BorrowingRecord record \= borrowingRecordRepository.findByIdAndUserId(recordId, userId)  
                .orElseThrow(() \-\> new IllegalStateException("Borrowing record not found."));  
        if (record.getStatus() \!= BorrowingRecord.Status.RETURNED\_LATE) {  
            throw new IllegalStateException("This record has no fine to be paid.");  
        }  
        record.setFine(0.0); // Reset the fine to zero.  
        record.setStatus(BorrowingRecord.Status.PAID);  
        return borrowingRecordRepository.save(record);  
    }  
      
    // ... other methods to get books and user records are omitted for brevity ...  
}

### **Payment Service (payment-service)**

A small Node.js and Express.js microservice that handles the integration with the Razorpay payment gateway.

#### **payment-service/index.js**

**Purpose**: This is the starting point for the payment service. It sets up the Express server and applies the necessary middleware.

require('dotenv').config();  
const express \= require('express');  
const cors \= require('cors');  
const paymentRoutes \= require('./routes/payment');

const app \= express();  
const PORT \= process.env.PORT || 3002;

app.use(cors());  
app.use(express.json());

app.use('/api/payments', paymentRoutes);

app.listen(PORT, () \=\> {  
  console.log(\`Payment service running on port ${PORT}\`);  
});

#### **payment-service/routes/payment.js**

**Purpose**: Defines the API endpoint that communicates with Razorpay to create a payment order.

const express \= require('express');  
const Razorpay \= require('razorpay');  
const router \= express.Router();

// Route: POST /api/payments/create-order  
router.post('/create-order', async (req, res) \=\> {  
    console.log("Received request to /create-order with body:", req.body);

    // Initialize the Razorpay client with our secret keys from the .env file.  
    const razorpay \= new Razorpay({  
        key\_id: process.env.RAZORPAY\_KEY\_ID,  
        key\_secret: process.env.RAZORPAY\_KEY\_SECRET  
    });

    // These are the details for the payment order.  
    const options \= {  
        amount: req.body.amount, // The amount in paise.  
        currency: req.body.currency,  
        receipt: req.body.receipt,  
        notes: req.body.notes // We can add extra info here, like the book ID.  
    };

    if (\!options.amount || typeof options.amount \!== 'number' || options.amount \<= 0\) {  
        console.error("Validation Error: Invalid 'amount' received:", options.amount);  
        return res.status(400).send("Invalid amount provided.");  
    }

    // Create the order using the Razorpay SDK.  
    try {  
        const order \= await razorpay.orders.create(options);  
        console.log("Razorpay order created successfully:", order);  
        res.json(order); // Send the order details back to the frontend.  
    } catch (error) {  
        console.error("Error creating Razorpay order:", error);  
        res.status(500).send("Error creating Razorpay order");  
    }  
});

module.exports \= router;  
