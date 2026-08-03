package com.coffeshop.menu.controller;

import com.coffeshop.menu.model.Product;
import com.coffeshop.menu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/products") // This means all URLs start with http://localhost:8080/products/
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "menu";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-new-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update-product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        this.productService.deleteProductById(id);
        return "redirect:/";
    }

    private List<Product> productsList = new ArrayList<>(List.of(
        new Product(1, "Espresso", 2.50),
        new Product(2, "Latte", 3.50),
        new Product(3, "Croissant", 2.00),
        new Product(4, "Chocolate Muffin", 2.25),
        new Product(5, "Americano", 2.75)
    ));


    /*
    @RequestMapping("/") // This maps to the URL http://localhost:8080/
    public String listProducts(Model productListModel) { // Model argument is used to pass data to the view
        productListModel.addAttribute("products", productsList); // Add the productsList to the model
        return "menu";  // This returns the view name, that is, the JSP file name
    }

     */


    @RequestMapping("/details/{id}") // This maps to the URL http://localhost:8080/products/details/{id}
    @ResponseBody
    public String getProductDetailsByID(@PathVariable int id){
        for (Product product : productsList) {
            if (product.getId() == id) {
                return "<strong>Requested Product Details: </strong> <hr> Product ID: " + product.getId() + "<br> Name: " + product.getName() + "<br> Price: $" + product.getPrice();
            }
        }
        return "Product not found!";
    }

    @RequestMapping("/add")  // Maps to the URL http://localhost:8080/add
    public String showProductForm(Model productAddFormModel) {
        productAddFormModel.addAttribute("product", new Product());  // Add a new product instance to the model
        return "add-new-product";
    }

    @PostMapping("/addNewProduct")  // Handles the form submission
    public String addProduct(Product product) {
        productsList.add(product);  // Adds the submitted product to productsList
        System.out.println(productsList);  // Logs the updated product list
        return "redirect:/";  // Redirects back to the main product list view
    }
}
