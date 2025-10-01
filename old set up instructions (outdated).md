# **RAIT Library \- Full Stack Application**

This project is a modern, full-stack online library application built with a microservices architecture. It features a complete user authentication system, a book catalog, and functionality for borrowing and returning books, with a fine and payment system for overdue items.

## **Technology Stack**

### **Backend**

* **Book Service:** Java, Spring Boot, Spring Security  
* **Auth Service:** Node.js, Express.js, JWT  
* **Payment Service:** Node.js, Express.js, Razorpay  
* **Database:** MongoDB

### **Frontend**

* **Framework:** React, Next.js  
* **Styling:** Tailwind CSS  
* **Animation:** GSAP (GreenSock Animation Platform)  
* **State Management:** Redux Toolkit

## **Getting Started: Setup and Testing Guide**

This guide will walk you through setting up and running the entire application on your local machine for development and testing.

### **1\. Prerequisites**

Ensure you have the following software installed on your machine:

* [Node.js](https://nodejs.org/) (LTS version)  
* [Java JDK 17](https://learn.microsoft.com/java/openjdk/download) or newer  
* [Docker Desktop](https://www.docker.com/products/docker-desktop/)  
* [Postman](https://www.postman.com/downloads/) (Optional, for backend API testing)

### **2\. Starting the Environment**

You must have **four separate terminal windows** open to run the entire application.

#### **Step 1: Start the Database**

The MongoDB database runs inside a Docker container.

1. Open your first terminal.  
2. Run the following command to start the container. This command uses a bind mount to store the database files in C:\\Users\\YourUsername\\mongo-data for persistence.  
   docker run \-d \-p 27017:27017 \--name my-mongo \-v "C:\\Users\\Avanish Wankhede\\mongo-data":/data/db mongo

3. To confirm it's running, you can use the command docker ps. You should see my-mongo in the list.

#### **Step 2: Start the Backend Services**

You need to start each of the three backend microservices in their own terminal.

1. **Auth Service (Port 3001):**  
   * Open your second terminal.  
   * Navigate to the auth-service directory.  
   * Run the command:  
     node index.js

2. **Payment Service (Port 3002):**  
   * Open your third terminal.  
   * Navigate to the payment-service directory.  
   * Run the command:  
     node index.js

3. **Book Service (Port 8080):**  
   * Open a fourth terminal.  
   * Navigate to the library\_service (or book-service) directory.  
   * Run the command using the Maven wrapper:  
     ./mvnw spring-boot:run

At this point, your entire backend is running.

#### **Step 3: Start the Frontend Application**

1. Open a new terminal (or use an existing one after a backend service has started).  
2. Navigate to your frontend project directory (capstone).  
3. Run the command:  
   npm run dev  
