package com.springstarthere.httprequestsch8.controllers;


import com.springstarthere.httprequestsch8.model.Product;
import com.springstarthere.httprequestsch8.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products")
    public String getProducts(Model model) {
        List<Product> allProducts = productService.findAll();
        model.addAttribute("products", allProducts);
        return "products.html";
    }
//
//    @PostMapping(path = "/products")
//    public String addProduct(@RequestParam String name, @RequestParam double price, Model model) {
//        Product product = new Product();
//        product.setName(name);
//        product.setPrice(price);
//        productService.addProduct(product);
//
//        List<Product> allProducts = productService.findAll();
//        model.addAttribute("products", allProducts);
//        return "products.html";
//    }

    @PostMapping(path = "/products")
    public String addProduct(Product product, Model model) {
        productService.addProduct(product);

        List<Product> allProducts = productService.findAll();
        model.addAttribute("products", allProducts);
        return "products.html";
    }


}
