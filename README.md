# Amazon Software Developer Junior Portfolio

This repository contains various projects and hands-on activities developed as part of the **Amazon Junior Software Developer** training program. The primary goal is to apply Object-Oriented Programming (OOP) concepts, web development with Spring Boot, MVC (Model-View-Controller) architecture, and data persistence.

---

## 📂 Repository Structure

1. **`MVC/`**: Practical activities focused on the Model-View-Controller design pattern in Java using **Spring Boot**.
2. **`zoo-final-project/`**: Final console project simulating a zoo management and interaction system applying OOP concepts.

---

## 🛠️ Project Details

### 1. Spring Boot MVC (`/MVC`)
This section contains projects designed to understand separation of concerns in web architecture using Spring Boot MVC and server-side rendering with different template engines:

#### A. Activity Creating views with JSP/Starter
* **Description**: Basic e-commerce web application (**QuickCart**).
* **Key Structure**:
  - `Product.java`: Data model representing a product.
  - `ProductController.java`: Spring MVC controller (`@Controller`) mapping `/` and `/products` routes, injecting the product list into the model, and returning the `"products"` view.
  - `products.jsp` (`src/main/webapp/WEB-INF/jsp/`): JSP view for dynamic product rendering.
* **Technologies**: Java, Spring Boot MVC, JSP (JavaServer Pages), Maven.

#### B. Activity Creating views with Thymeleaf/Starter
* **Description**: Variant of the **QuickCart** application implemented with the Thymeleaf template engine.
* **Key Structure**:
  - `resources/templates/products.html`: Thymeleaf view for displaying the product list.
  - `resources/templates/add-new-product.html`: Form for registering new products.
  - `resources/static/css/`: CSS stylesheets.
* **Technologies**: Java, Spring Boot, Thymeleaf, HTML5, CSS3, Maven.

#### C. Activity Menu Management
* **Description**: Web application for managing a dynamic menu system featuring data persistence and code validation.
* **Key Structure**:
  - `MenuItem.java`: Data model representing menu items.
  - `MenuController.java`: Spring MVC controller (`@Controller`) mapping menu routes and handling view rendering.
  - `application.properties`: Configuration file establishing MySQL database integration and Checkstyle validation rules.
* **Technologies**: Java, Spring Boot MVC, MySQL, Checkstyle, Maven.

#### D. Activity Security and Authentication
* **Description**: Secure web application demonstrating custom authentication, access control, and integration testing.
* **Key Structure**:
  - `SecurityConfig.java`: Configuration class establishing role-based security filter chains and HTTP Basic authentication.
  - `LoginController.java`: Spring MVC controller handling custom form logins.
  - `SecurityTests.java`: Testing suite executing unit and integration tests using JUnit and TestRestTemplate.
* **Technologies**: Java, Spring Boot Security, JUnit, TestRestTemplate, Maven.

---

### 2. Zoo Final Project (`/zoo-final-project`)
* **Description**: Interactive console application simulating the management of a zoo with different animals (Tigers, Penguins, and Dolphins).
* **Applied Concepts**:
  - **Object-Oriented Programming (OOP)**: Encapsulation, Polymorphism, and Inheritance.
  - **Inheritance & Interfaces**: Abstract base class `Animal` and behavioral interfaces (`Eat`, `Walk`, `Swim`).
  - **Data Persistence**: Reading and writing animal states via File I/O in text files (`tiger.txt`, `penguin.txt`, `dolphin.txt`).
  - **Exception Handling**: Validation of user inputs in the console menu.
* **Key Structure**:
  - `Animal.java` (Abstract Base Class)
  - `Tiger.java`, `Penguin.java`, `Dolphin.java` (Subclasses)
  - `Eat.java`, `Walk.java`, `Swim.java` (Interfaces)
  - `Main.java` (Entry point and interactive menu)

---

## 🚀 Technologies & Tools

* **Language**: Java (JDK 17+)
* **Framework**: Spring Boot (Spring MVC)
* **Template Engines**: JSP, Thymeleaf
* **Web Development**: HTML5, CSS3
* **Dependency Management**: Maven
* **Recommended IDE**: IntelliJ IDEA

---

## 💻 How to Run

### Spring Boot MVC Projects (`/MVC`)
1. Navigate to the target project directory:
   ```bash
   cd "MVC/Activity Creating views with Thymeleaf/Starter"  
     
2. Run the application using the Maven wrapper: 
     
   ./mvnw spring-boot:run  
     
3. Access in your browser at: `http://localhost:8080/` or `http://localhost:8080/products`

###  Zoo Final Project (`/zoo-final-project`)

1. Open the `/zoo-final-project` directory in IntelliJ IDEA or your preferred IDE.  
2. Run the  `Main.java` class located in `src/`.  
3. Follow the console menu prompts.
