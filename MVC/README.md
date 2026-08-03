# Spring Boot MVC Activities & Projects

This directory contains practical projects and hands-on activities focusing on the Model-View-Controller (MVC) architectural pattern using Spring Boot. These modules demonstrate server-side rendering (SSR), template engine implementations (JSP and Thymeleaf), and multi-tier enterprise layered architecture (Controller-Service-Repository).  
---

## 📂 Folder Structure

```
MVC/
├── Activity Creating views with JSP/
│   └── Starter/                  # QuickCart application using Spring Boot + JSP + JSTL
├── Activity Creating views with Thymeleaf/
│   └── Starter/                  # QuickCart application with form binding using Spring Boot + Thymeleaf
└── menu/                         # Coffee Shop Menu application with layered architecture (Controller, Service, Repository)
```

---

## 🛠️ Projects & Activities Overview

### 1\. Activity: Creating Views with JSP (/Activity Creating views with JSP/Starter)

* Project Name: QuickCart (JSP Edition)  
* Description: A web-based e-commerce catalog application designed to introduce basic server-side view rendering using JavaServer Pages (JSP) within a Spring Boot application.  
* Key Features & Components:  
  * Model (Product.java): Represents the product domain entity with fields such as id, name, description, and price.  
  * Controller (ProductController.java): Annotated with @Controller, configures request mappings for / and /products. It populates the Spring Model object with mock product data (e.g., HP Laptop, Samsung Smartphone, Skullcandy Headphones) and routes requests to the "products" view.  
  * View (products.jsp): Located under src/main/webapp/WEB-INF/jsp/, uses JSTL core tags (\<c:forEach\>) to dynamically iterate over and display the list of products in an HTML table.  
* Tech Stack: Java 17+, Spring Boot MVC, JSP, JSTL, Embedded Tomcat (tomcat-embed-jasper), Maven.

---

### 2\. Activity: Creating Views with Thymeleaf (/Activity Creating views with Thymeleaf/Starter)

* Project Name: QuickCart (Thymeleaf Edition)  
* Description: An enhanced version of the QuickCart application built using Thymeleaf, a modern XHTML/HTML5 template engine. It extends the catalog feature by adding interactive form handling for adding new products.  
* Key Features & Components:  
  * Model (Product.java): Domain model used across controller mappings and form data bindings.  
  * Controller (ProductController.java): Handles @GetMapping requests for displaying products (/products), @GetMapping("/add") for loading the product form, and @PostMapping("/addNewProduct") for receiving form submissions and redirecting (redirect:/).  
  * Product Catalog View (resources/templates/products.html): Utilizes Thymeleaf attributes (th:each, th:text) to dynamically render product lists.  
  * Add Product View (resources/templates/add-new-product.html): HTML form structured with th:object and th:field for bi-directional model binding.  
  * Static Styling (resources/static/css/product-styles.css): Custom CSS styles for layout and presentation.  
* Tech Stack: Java 17+, Spring Boot, Thymeleaf, HTML5, CSS3, Maven.

---

### 3\. Coffee Shop Menu Project (/menu)

* Project Name: Coffee Shop Menu  
* Description: A full-featured enterprise-style MVC application that manages a coffee shop menu. It demonstrates a clean, layered architecture by separating concern into distinct Controller, Service, and Repository layers.  
* Key Features & Components:  
  * Layered Architecture:  
    * Model (com.coffeshop.menu.model.Product): Represents coffee shop items and menu offerings.  
    * Repository (com.coffeshop.menu.repository): Handles data persistence and data access logic for menu items.  
    * Service (com.coffeshop.menu.service): Enforces business logic and serves as an intermediary between the repository and controller layers.  
    * Controller (com.coffeshop.menu.controller.ProductController): Interacts exclusively with the Service layer to fetch menu data and pass it to the view.  
  * View (src/main/webapp/WEB-INF/jsp/menu.jsp): Custom JSP template designed to render coffee shop products and pricing in a clean menu layout.  
* Tech Stack: Java 17+, Spring Boot MVC, Layered Architecture (Service/Repository), JSP, JSTL, Embedded Tomcat, Maven.

---

## ⚙️ Key Concepts Covered

* MVC Pattern: Clear separation between domain models, HTTP request handlers/controllers, and presentation layer templates.  
* Layered Architecture: Decoupling business logic and data persistence using the Service and Repository design patterns.  
* Template Engine Comparison:  
  * JSP: Servlet-based rendering with JSTL support requiring webapp/WEB-INF/jsp directory configuration.  
  * Thymeleaf: Natural templating engine integrated directly into Spring Boot's default template location (resources/templates).  
* Form Binding & Data Processing: Mapping HTML form inputs directly to Java objects via Spring MVC.

---

## 🚀 How to Run the Projects

1. Open your terminal and navigate to the directory of the project you wish to run:  
   * JSP QuickCart:  
   * 

```shell
cd "MVC/Activity Creating views with JSP/Starter"
```

   * Thymeleaf QuickCart:

```shell
cd "MVC/Activity Creating views with Thymeleaf/Starter"
```

   * Coffee Shop Menu:  
   * 

```shell
cd "MVC/menu"
```

2. Execute the application with the Maven wrapper:

```shell
./mvnw spring-boot:run
```

3. Open your browser and visit the corresponding URL:  
   * QuickCart JSP: http://localhost:8080/products  
   * QuickCart Thymeleaf: http://localhost:8080/products  
   * Coffee Shop Menu: http://localhost:8080/ (or as mapped in the controller)

