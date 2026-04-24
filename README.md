# SmartCampus: Sensor & Room Management API

**Student Name:** Senith Chandul Sagarage  
**Student ID:** w2120309 / 20231705  
**Module:** Client-Server Architectures (5COSC022W)

## 📌 Project Overview

The **SmartCampus** API is a robust, scalable RESTful web service built using **Jakarta EE 10** and **JAX-RS**. Designed as part of the university's "Smart Campus" initiative, this backend system facilitates the management of thousands of rooms and their associated sensor arrays, including CO2 monitors and occupancy trackers.

### Key Features

- **Resource Hierarchy:** Implements a logical physical structure reflecting the campus layout.
- **In-Memory Storage:** Uses thread-safe data structures (`ConcurrentHashMap`) for high-performance retrieval without a database dependency.
- **Advanced Error Handling:** Features a global safety net to prevent internal information leakage and raw stack traces.

---

## 🚀 Build and Launch Instructions

Follow these steps to deploy the API on **Apache Tomcat 10.1**:

### 1. Prerequisites

- JDK 17 or higher
- Apache Maven
- Apache Tomcat 10.1 (Jakarta EE 10 compatible)

### 2. Clone and Build

```bash
git clone https://github.com/Senith-Chandul/SmartCampus.git
cd SmartCampus
mvn clean install
```

### 3. Deployment

- Locate the `SmartCampus.war` file in the `target` directory.
- Copy the `.war` file to your Tomcat `webapps` folder.

### 4. Access the API

Base endpoint:

```text
http://localhost:8080/SmartCampus/api/v1/
```

## 🧪 Sample cURL Commands

Use these commands to interact with the system:

### 1. System Discovery (GET)

```bash
curl -X GET http://localhost:8080/SmartCampus/api/v1/
```

### 2. Create a Room (POST)

```bash
curl -X POST -H "Content-Type: application/json" -d '{"id":"LIB-101", "name":"Library Study Room", "capacity":15}' http://localhost:8080/SmartCampus/api/v1/rooms
```

### 3. Register a Sensor (POST)

```bash
curl -X POST -H "Content-Type: application/json" -d '{"id":"TEMP-01", "type":"Temperature", "roomId":"LIB-101"}' http://localhost:8080/SmartCampus/api/v1/sensors
```

### 4. Filter Sensors by Type (GET)

```bash
curl -X GET "http://localhost:8080/SmartCampus/api/v1/sensors?type=Temperature"
```

### 5. View Room Historical Sensors (Sub-Resource GET)

```bash
curl -X GET http://localhost:8080/SmartCampus/api/v1/rooms/LIB-101/sensors
```

## 📄 Other Resources

- Report: [Click Here](https://drive.google.com/file/d/1ZdFDkhcDmeIdgWCN6uZI1-tHyEYwSqZh/view?usp=sharing)
- Demo Video: [Click Here](https://drive.google.com/file/d/1gUNrb6V_TfRG4vWyzsNsVjFqm36ZSMPY/view?usp=sharing)



> **Note:** Technical answers for the Conceptual Report are located in the separate PDF submission.
