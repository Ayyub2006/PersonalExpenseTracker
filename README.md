# 💰 Ledgerly

<p align="center">

A modern **Full-Stack Personal Finance Management Application** built with **Spring Boot**, **React**, and **MySQL** that helps users efficiently manage expenses, income, budgets, and financial insights through an intuitive dashboard.

</p>

<p align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-6DB33F?style=for-the-badge&logo=springboot)
![React](https://img.shields.io/badge/React-19-61DAFB?style=for-the-badge&logo=react)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker)
![Render](https://img.shields.io/badge/Backend-Render-46E3B7?style=for-the-badge)
![Railway](https://img.shields.io/badge/Database-Railway-0B0D0E?style=for-the-badge)
![Vercel](https://img.shields.io/badge/Frontend-Vercel-black?style=for-the-badge&logo=vercel)

</p>

---

## 🚀 Live Demo

### 🌐 Frontend

**https://personal-expense-tracker-wine-omega.vercel.app**

### ⚙ Backend API

**https://ledgerly-api-enny.onrender.com**

---

# 📖 About Ledgerly

Managing personal finances shouldn't be complicated.

**Ledgerly** is a full-stack expense management platform that enables users to track income, monitor expenses, organize categories, manage monthly budgets, and visualize financial data through an interactive dashboard.

The application follows a modern client-server architecture using **React** for the frontend and **Spring Boot** for the backend, secured with **JWT Authentication** and deployed completely on the cloud.

The project focuses on building production-ready backend APIs, secure authentication, responsive user interfaces, and real-world deployment practices.

---

# ✨ Features

## 🔐 Authentication

- Secure JWT Authentication
- User Registration
- User Login
- Protected Routes
- Session Persistence

---

## 💰 Expense Management

- Add Expenses
- Edit Expenses
- Delete Expenses
- Search Expenses
- Category-wise Filtering
- Monthly Expense Tracking

---

## 💵 Income Management

- Add Income
- Edit Income
- Delete Income
- Search Income
- Monthly Income Records

---

## 📂 Category Management

- Create Categories
- Update Categories
- Delete Categories
- Organize Expenses by Category

---

## 📊 Dashboard Analytics

- Total Income
- Total Expenses
- Remaining Balance
- Monthly Budget
- Budget Utilization
- Expense Distribution Chart
- Monthly Income Graph
- Monthly Expense Graph
- Recent Transactions

---

## 🎯 Budget Tracking

- Set Monthly Budget
- Budget Progress Indicator
- Remaining Budget Calculation
- Budget Utilization Percentage

---

## 👤 User Profile

- Profile Information
- Update User Details
- Secure Logout

---

## 🎨 User Experience

- Responsive Design
- Dark Mode Support
- Modern Dashboard
- Interactive Charts
- Material UI Components
- Clean Navigation
- Fast Performance

---

# 🌟 Highlights

- ✅ Full Stack Application
- ✅ RESTful API Architecture
- ✅ JWT Authentication
- ✅ Spring Security
- ✅ Cloud Deployment
- ✅ Dockerized Backend
- ✅ Responsive React Frontend
- ✅ MySQL Database
- ✅ Production Ready
- ✅ Clean UI/UX

---

# 🏆 Why Ledgerly?

Unlike basic CRUD applications, Ledgerly demonstrates practical software engineering concepts including:

- REST API Development
- Authentication & Authorization
- State Management
- Database Design
- Cloud Deployment
- Secure Backend Development
- Frontend & Backend Integration
- Production Configuration
- Modern UI Development
- Real-world Project Structure

This project was built to simulate how modern SaaS finance applications are designed and deployed.

---

---

# 🛠 Tech Stack

## Frontend

| Technology | Purpose |
|------------|----------|
| React 19 | User Interface |
| Vite | Frontend Build Tool |
| Material UI | UI Components |
| React Router DOM | Client-side Routing |
| Axios | REST API Communication |
| Chart.js | Dashboard Analytics & Charts |

---

## Backend

| Technology | Purpose |
|------------|----------|
| Java 17 | Programming Language |
| Spring Boot 4 | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT | Secure User Authentication |
| Spring Data JPA | Database Operations |
| Hibernate | ORM |
| Maven | Dependency Management |

---

## Database

| Technology | Purpose |
|------------|----------|
| MySQL | Relational Database |
| Railway | Cloud Database Hosting |

---

## DevOps & Deployment

| Technology | Purpose |
|------------|----------|
| Docker | Containerization |
| Render | Backend Deployment |
| Vercel | Frontend Deployment |
| Git | Version Control |
| GitHub | Source Code Management |

---

# 🏗 System Architecture

```
                        User
                          │
                          ▼
                  React + Vite Frontend
                     (Hosted on Vercel)
                          │
                     REST API Calls
                          │
                          ▼
             Spring Boot REST API Server
                  (Hosted on Render)
                          │
                 Spring Security + JWT
                          │
                          ▼
                 Spring Data JPA
                          │
                          ▼
                MySQL Database (Railway)
```

---

# 🔄 Application Workflow

```
User Login/Register
        │
        ▼
JWT Authentication
        │
        ▼
JWT Token Generated
        │
        ▼
Stored in Browser
        │
        ▼
Every API Request
        │
        ▼
Authorization Header
        │
        ▼
Spring Security Filter
        │
        ▼
JWT Validation
        │
        ▼
Business Logic
        │
        ▼
MySQL Database
        │
        ▼
JSON Response
        │
        ▼
React UI Update
```

---

# 📂 Project Structure

```
Ledgerly
│
├── backend
│   ├── src
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   ├── dto
│   │   ├── security
│   │   ├── config
│   │   ├── exception
│   │   └── util
│   │
│   ├── Dockerfile
│   ├── pom.xml
│   └── application.properties
│
├── frontend
│   ├── src
│   │   ├── pages
│   │   ├── components
│   │   ├── services
│   │   ├── hooks
│   │   ├── layouts
│   │   ├── utils
│   │   └── assets
│   │
│   ├── package.json
│   ├── vite.config.js
│   └── vercel.json
│
├── assets
│   └── screenshots
│
└── README.md
```

---

# 🗄 Database Modules

The application is designed around the following core entities.

```
User
│
├── Categories
│
├── Expenses
│
├── Income
│
└── Monthly Budget
```

Each user has complete isolation of their own financial records through secure JWT-based authentication.

---

# 📡 REST API Overview

## Authentication

```
POST    /api/auth/register

POST    /api/auth/login
```

---

## Expenses

```
GET     /api/expenses

POST    /api/expenses

PUT     /api/expenses/{id}

DELETE  /api/expenses/{id}
```

---

## Income

```
GET     /api/income

POST    /api/income

PUT     /api/income/{id}

DELETE  /api/income/{id}
```

---

## Categories

```
GET     /api/categories

POST    /api/categories

PUT     /api/categories/{id}

DELETE  /api/categories/{id}
```

---

## Budget

```
GET     /api/budget

POST    /api/budget
```

---

## User

```
GET     /api/user/profile

PUT     /api/user/profile
```

---

# 📸 Application Preview

## 🔐 Login Page

![Login](assets/screenshots/login.png)

---

## 📊 Dashboard

![Dashboard](assets/screenshots/dashboard.png)

---

## 💸 Expense Management

![Expenses](assets/screenshots/expenses.png)

---

## 💵 Income Management

![Income](assets/screenshots/income.png)

---

## 🗂 Category Management

![Categories](assets/screenshots/categories.png)

---

## 🎯 Budget Tracking

![Budget](assets/screenshots/budget.png)

---

## 👤 User Profile

![Profile](assets/screenshots/profile.png)

---

## ➕ Add Expense

![Add Expense](assets/screenshots/add-expense.png)

---

## ➕ Add Income

![Add Income](assets/screenshots/add-income.png)

---

## ✏ Update Monthly Budget

![Budget Dialog](assets/screenshots/budget-dialog.png)

---

---

# ⚙️ Getting Started

Follow the steps below to set up Ledgerly on your local machine.

## Prerequisites

Before running the project, ensure you have the following installed:

- Java 17+
- Node.js 18+
- MySQL 8+
- Maven
- Git

---

# 📥 Clone the Repository

```bash
git clone https://github.com/Ayyub2006/Ledgerly.git

cd Ledgerly
```

---

# ⚙️ Backend Setup

Navigate to the backend directory.

```bash
cd backend
```

Install dependencies and run the Spring Boot application.

```bash
mvn clean install

mvn spring-boot:run
```

Backend will start on

```
http://localhost:8084
```

---

# 💻 Frontend Setup

Navigate to the frontend.

```bash
cd frontend
```

Install dependencies.

```bash
npm install
```

Start the development server.

```bash
npm run dev
```

Frontend runs on

```
http://localhost:5173
```

---

# 🌍 Environment Variables

## Backend

Configure the following properties in `application.properties`.

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

jwt.secret=

jwt.expiration=
```

---

## Frontend

Create a `.env` file.

```env
VITE_API_BASE_URL=http://localhost:8084
```

---

# 🐳 Docker

Run the backend using Docker.

```bash
docker build -t ledgerly .

docker run -p 8084:8084 ledgerly
```

---

# ☁️ Deployment

| Service | Platform |
|----------|----------|
| Frontend | Vercel |
| Backend | Render |
| Database | Railway |

---

## Live Application

### Frontend

https://personal-expense-tracker-wine-omega.vercel.app

### Backend

https://ledgerly-api-enny.onrender.com

---

# 🔒 Security Features

- JWT Authentication
- Spring Security
- Password Encryption
- Protected REST APIs
- User-specific Data Isolation
- CORS Configuration
- Environment Variable Support

---

# 🚀 Future Enhancements

- Email Verification
- Forgot Password
- Export Reports as PDF
- Excel Export
- Financial Goals
- Savings Tracker
- Multi-Currency Support
- Notifications
- Recurring Transactions
- AI-powered Expense Insights
- Mobile Application
- Admin Dashboard

---

# 🤝 Contributing

Contributions are welcome!

If you'd like to improve Ledgerly:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push to your branch.
5. Open a Pull Request.

---

# 📜 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

**Mohd Ayyub Khan**

- GitHub: https://github.com/Ayyub2006
- LinkedIn: *(Add your LinkedIn profile link here)*

---

# ⭐ Support

If you found this project helpful,

⭐ Star this repository on GitHub.

It helps others discover the project and motivates future improvements.

---

<p align="center">

Made with ❤️ using Spring Boot, React, and MySQL.

</p>
