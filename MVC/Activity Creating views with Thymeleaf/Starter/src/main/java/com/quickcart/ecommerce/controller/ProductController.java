package com.quickcart.ecommerce.controller;

import com.quickcart.ecommerce.model.Product;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private List<Product> products = new ArrayList<>(List.of(
            new Product(1, "Laptop", "A laptop for work and play", 500.0),
            new Product(2, "Smartphone", "A smartphone for communication", 300.0),
            new Product(3, "Headphones", "A pair of headphones for music", 50.0)
    ));

    @GetMapping({"/", "/products"})
    public String getProducts(Model productModel) {
        productModel.addAttribute("products", products);
        return "products";
    }
    @RequestMapping("/add")  // Maps to the URL http://localhost:8080/add
    public String showProductForm(Model productAddFormModel) {
        productAddFormModel.addAttribute("product", new Product());  // Add a new product instance to the model
        return "add-new-product";
    }

    @PostMapping("/addNewProduct")  // Handles the form submission
    public String addProduct(Product product) {
        products.add(product);  // Adds the submitted product to productsList
        System.out.println(products);  // Logs the updated product list
        return "redirect:/";  // Redirects back to the main product list view
    }


    /*

@PostMapping("/addNewProduct")
public String addProduct(@Valid Product product, BindingResult result) {
    // Si la validación falla (ej. el ID es 0), result.hasErrors() será true
    if (result.hasErrors()) {
        // En lugar de guardar, regresamos la misma vista del formulario
        // Los errores viajarán automáticamente hacia Thymeleaf
        return "add-new-product";
    }
    products.add(product);
    System.out.println(products);
    return "redirect:/";
}
     */
}
