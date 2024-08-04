package com.eofsentinel.ecommerceWebApp.service;

import com.eofsentinel.ecommerceWebApp.model.Product;
import com.eofsentinel.ecommerceWebApp.repo.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository repo;

    public List<Product> getAllProducts() {
        return this.repo.findAll();
    }

    public Product getProductById(int id) {
        return this.repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        System.out.println(product);

        return this.repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        if (!this.repo.existsById(id)) {
            return null;
        }

        return this.addProduct(product, imageFile);
    }

    public boolean deleteProduct(int id) {
        if (!this.repo.existsById(id)) {
            return false;
        }

        this.repo.deleteById(id);
        return true;
    }

    public List<Product> serachByKeyword(String keyword) {
        return this.repo.searchByKeyword(keyword);
    }
}
