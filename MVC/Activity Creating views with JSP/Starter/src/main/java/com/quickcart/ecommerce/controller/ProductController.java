package com.quickcart.ecommerce.controller;

import com.quickcart.ecommerce.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping({"/", "/products"}) //handles both index and products url
    public String getProducts (Model model) {
        List<Product> products = new ArrayList<>();
        Product laptop = new Product(1, "laptop", "HP portable laptop", 799.3);
        Product smartphone = new Product(2, "smartphone", "Samsung s26 Ultra", 599.3);
        Product headphones = new Product(3, "headphones", "Skullcandy crusher evo 2", 189.90);
        products.add(laptop);
        products.add(smartphone);
        products.add(headphones);
        model.addAttribute("products", products); //Add the List of Products to the Model object with the key "products".
        return "products"; //returns model key (jsp file name)
    }
}
