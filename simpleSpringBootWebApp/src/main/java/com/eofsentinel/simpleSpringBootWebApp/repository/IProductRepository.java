package com.eofsentinel.simpleSpringBootWebApp.repository;

import com.eofsentinel.simpleSpringBootWebApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
}
