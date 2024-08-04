package com.eofsentinel.ecommerceWebApp.controller;

import com.eofsentinel.ecommerceWebApp.model.Product;
import com.eofsentinel.ecommerceWebApp.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet() {
        return "Hello world!";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product prod = this.service.getProductById(id);

        if (prod == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(prod, HttpStatus.OK);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(
            @RequestPart Product product,
            @RequestPart MultipartFile imageFile) {
        try {
            Product createdProduct = this.service.addProduct(product, imageFile);
            return new ResponseEntity<>(createdProduct, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int id) {
        Product prod = this.service.getProductById(id);

        if (prod == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(prod.getImageType()))
                    .body(prod.getImageData());
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable int id,
            @RequestPart Product product,
            @RequestPart MultipartFile imageFile) {
        Product updatedProduct;
        try {
            updatedProduct = this.service.updateProduct(id, product, imageFile);
        }
        catch (Exception ex) {
            return new ResponseEntity<>("Failed to update entity", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (updatedProduct == null) {
            return new ResponseEntity<>("Entity not found", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Successfully updated entity", HttpStatus.OK);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        boolean result = this.service.deleteProduct(id);

        if (!result) {
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>("Successfully deleted entity", HttpStatus.OK);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchKeyword(@RequestParam String keyword) {
        System.out.println("Searching with keyword: " + keyword);
        return new ResponseEntity<>(this.service.serachByKeyword(keyword), HttpStatus.OK);
    }
}
