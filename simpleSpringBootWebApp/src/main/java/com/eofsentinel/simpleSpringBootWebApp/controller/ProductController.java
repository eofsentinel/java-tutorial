package com.eofsentinel.simpleSpringBootWebApp.controller;

import com.eofsentinel.simpleSpringBootWebApp.model.Product;
import com.eofsentinel.simpleSpringBootWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/product/{prodId}")
    public Product getProduct(@PathVariable int prodId) {
        return service.getProductById(prodId);
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product prod) {
        boolean result = this.service.addProduct(prod);
        if (!result) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Product ID already exists in catalog");
        }

        return "Successfully added ProductID: " + prod.getProdId();
    }

    @PutMapping("/product")
    public String updateProduct(@RequestBody Product prod) {
        boolean result = this.service.updateProduct(prod);
        if (!result) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product ID not found in catalog");
        }

        return "Successfully updated ProductID: " + prod.getProdId();
    }

    @RequestMapping("/product/{prodId}")
    public String deleteProduct(@PathVariable int prodId) {
        boolean result = this.service.deleteProduct(prodId);
        if (!result) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product ID not found in catalog");
        }

        return "Successfully deleted ProductID: " + prodId;
    }
}
