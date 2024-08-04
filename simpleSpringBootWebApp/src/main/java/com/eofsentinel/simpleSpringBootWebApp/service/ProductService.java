package com.eofsentinel.simpleSpringBootWebApp.service;

import com.eofsentinel.simpleSpringBootWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<Product>() {
        {
            add(new Product(101, "iPhone", 999.99));
            add(new Product(102, "Macbook Air", 1299.90));
            add(new Product(103, "Macbook Pro 2024", 2499.95));
        }
    };

    public List<Product> getProducts() {
        return this.products;
    }

    public Product getProductById(int id) {
        return this.products.stream()
                .filter(x -> x.getProdId() == id).findFirst()
                .orElse(new Product(id, "Product not found", 0));
    }

    public boolean addProduct(Product prod) {
        if (this.products.stream().anyMatch(x -> x.getProdId() == prod.getProdId())) {
            return false;
        }

        this.products.add(prod);
        return true;
    }

    public boolean updateProduct(Product prod) {
        if (this.products.stream().noneMatch(x -> x.getProdId() == prod.getProdId())) {
            return false;
        }

        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getProdId() == prod.getProdId()) {
                this.products.set(i, prod);
                break;
            }
        }

        return true;
    }

    public boolean deleteProduct(int prodId) {
        int index = -1;
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getProdId() == prodId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            this.products.remove(index);
            return true;
        }

        return false;
    }
}
