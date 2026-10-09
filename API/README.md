He creado la versión en texto plano/Markdown estructurado para que puedas seleccionarlo y pegarlo directamente en tu Google Doc o archivo `README.md`:

---

# Asynchronous API Integration & HTTP Client Projects

This directory contains practical hands-on activities focusing on client-side HTTP requests and RESTful API consumption using asynchronous JavaScript. These modules demonstrate full **CRUD** (Create, Read, Update, Delete) operations against a backend REST service using three distinct client-side approaches: **Fetch API**, **Axios**, and **jQuery AJAX**.

---

## 📂 Folder Structure

```
API/
├── Handling POST, PUT and DELETE requests with Fetch API/
│   ├── index.html
│   └── script.js
├── Handling requests with Axios/
│   ├── index.html
│   └── script.js
└── Handling GET, POST, PUT, and DELETE requests with jQuery/
    ├── index.html
    ├── product.html
    ├── add.html
    ├── edit.html
    └── index.js

```

---

## 🛠️ Projects & Activities Overview

### 1. Activity: Fetch API Implementation (/Handling POST, PUT and DELETE requests with Fetch API)

* **Project Name:** Shopping Cart CRUD (Fetch API Edition)
* **Description:** A native JavaScript implementation utilizing the standard web `fetch()` API and Promises (`async/await`) to execute asynchronous HTTP requests without relying on external libraries.
* **Key Features & Components:**
* **Asynchronous Requests:** Modern ES6+ syntax using `fetch()` for non-blocking HTTP communications.
* **Header Configuration:** Explicit setting of request headers (`Content-Type: application/json`).
* **Response Parsing:** Handling async stream parsing via `response.json()` and evaluating HTTP status flags (`response.ok`).
* **DOM Updates:** Direct manipulation of the Document Object Model (DOM) to reflect backend changes in real time.


* **Tech Stack:** Vanilla JavaScript (ES6+), HTML5, CSS3.

---

### 2. Activity: Axios HTTP Client Implementation (/Handling requests with Axios)

* **Project Name:** Shopping Cart CRUD (Axios Edition)
* **Description:** An HTTP client implementation built with Axios, leveraging its automatic JSON transformation and clean request configuration to interact with the product management REST API.
* **Key Features & Components:**
* **Simplified Syntax:** Streamlined syntax for `axios.get()`, `axios.post()`, `axios.put()`, and `axios.delete()`.
* **Automatic Data Transformation:** Automatic parsing of JSON request and response payloads via `response.data`.
* **Error Handling:** Robust exception management using `try/catch` blocks paired with Axios error object inspection (`error.response`).


* **Tech Stack:** JavaScript (ES6+), Axios, HTML5, CSS3.

---

### 3. Activity: jQuery AJAX Integration (/Handling GET, POST, PUT, and DELETE requests with jQuery)

* **Project Name:** Shopping Cart CRUD (jQuery Edition)
* **Description:** An interactive client application using jQuery's `$.ajax()` module to integrate frontend UI events with backend REST endpoints across dedicated application views.
* **Key Features & Components:**
* **Modular Request Handler:** Reusable utility function (`ajaxRequest()`) centralizing HTTP method configurations, JSON serialization (`JSON.stringify`), and content headers.
* **Dynamic View Rendering:** UI updates driven by jQuery DOM methods (`$.map()`, `.html()`, `.empty()`).
* **Deferred/Promise Flow Control:** Asynchronous callback chaining using `.done()` and `.fail()`.
* **Standardized Error Handling:** Centralized `handleError()` function mapping HTTP status codes (`404`, `403`, `500`, network failure `0`) to user alerts.


* **Tech Stack:** JavaScript, jQuery 3.x, HTML5, CSS3.

---

## ⚙️ Backend Prerequisites & Endpoints

All activities in this directory connect to a Spring Boot REST API service backed by a MySQL database (`products` table).

* **Backend Service:** Spring Boot REST API
* **Base API URL:** `http://localhost:8080/api/v1/products`

### Endpoint Mapping

| Method | Endpoint | Description | Request Body / Payload |
| --- | --- | --- | --- |
| `GET` | `/api/v1/products` | Fetch all products from database | N/A |
| `GET` | `/api/v1/products/{id}` | Fetch a single product by ID | N/A |
| `POST` | `/api/v1/products` | Create and store a new product | JSON object with product details |
| `PUT` | `/api/v1/products/{id}` | Update an existing product by ID | JSON object with updated fields |
| `DELETE` | `/api/v1/products/{id}` | Delete a product by ID | N/A |

---

## 💡 Key Concepts Covered

* **Asynchronous Web Operations:** Executing HTTP requests in the background without requiring full page reloads (AJAX paradigm).
* **Data Serialization:** Converting JavaScript objects to JSON strings via `JSON.stringify()` for `POST`/`PUT` bodies, and parsing returned JSON payloads.
* **Client Library Comparison:**
* **Fetch API:** Native browser support, minimal overhead, manual response state check (`response.ok`).
* **Axios:** Promise-based library with automatic JSON parsing and concise syntax.
* **jQuery AJAX:** Legacy-compatible library integrating AJAX network calls directly with DOM manipulation tools.


* **Error & Exception Handling:** Evaluating XHR status codes and network errors to provide appropriate UI feedback.

---

## 🚀 How to Run the Projects

1. Ensure the Spring Boot backend service is running locally at `http://localhost:8080`.
2. Open your terminal and navigate to the desired activity directory:
* **Fetch API Activity:**
```shell
cd "API/Handling POST, PUT and DELETE requests with Fetch API"

```


* **Axios Activity:**
```shell
cd "API/Handling requests with Axios"

```


* **jQuery Activity:**
```shell
cd "API/Handling GET, POST, PUT, and DELETE requests with jQuery"

```




3. Open `index.html` in your web browser directly or serve it using a local static file server (such as VS Code *Live Server* or Python's HTTP server):
```shell
python -m http.server 5500

```
