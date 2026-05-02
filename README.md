# myKart (LocalKart)

A hyperlocal marketplace platform that digitizes neighborhood commerce by allowing customers to browse nearby shops, pre-book items, and pick them up without waiting in queues.

---

## 🚀 Features

### Customer Features
- Hyperlocal city-based shop discovery
- Browse categorized products from nearby stores
- Real-time shop open/closed status
- Persistent cart using localStorage
- Live order tracking (Confirmed → Preparing → Ready → Picked Up)
- Community reviews and ratings

### Shop Owner Features
- Shop registration with category and location mapping
- Product catalog management dashboard
- Live order queue management
- Dynamic order status updates

---

## 🛠 Tech Stack

### Frontend
- Next.js 14
- TypeScript
- Tailwind CSS
- Lucide React
- Leaflet.js

### Backend
- Java Spring Boot
- RESTful APIs

### Database
- H2 In-Memory Database

---

## 🏗 Architecture

The project follows a modern decoupled full-stack architecture:

- **Frontend:** Handles UI, state management, routing, and cart persistence
- **Backend:** Provides REST APIs for authentication, products, shops, and orders
- **Database:** Stores mock and runtime data for development/demo purposes

---

## 📂 Project Structure

```bash
frontend/
│── src/
│   ├── types/        # TypeScript data models
│   ├── context/      # Auth and Cart Context
│   └── app/          # Next.js App Router pages

backend/
│── src/main/java/com/localkart/backend/
│   ├── controller/   # REST Controllers
│   ├── model/        # Entity Models
│   └── LocalKartApplication.java
```

---

## ⚙️ Installation & Setup

### Clone Repository
```bash
git clone https://github.com/yourusername/myKart.git
cd myKart
```

### Frontend Setup
```bash
cd frontend
npm install
npm run dev
```

### Backend Setup
```bash
cd backend
./mvnw spring-boot:run
```

---

## 📌 Current Status

- ✅ Production Ready
- ✅ 0 TypeScript Errors
- ✅ 0 Lint Errors
- ✅ Stable Backend Architecture

---

## 🎯 Vision

myKart aims to bridge the gap between traditional local shops and modern digital convenience by enabling neighborhood businesses to establish an online presence and offer queue-free shopping experiences.

---

## 👨‍💻 Author

**Yash Mittal**  
B.Tech CSE | Full Stack Developer  

---

## 📜 License

This project is for educational and portfolio purposes.