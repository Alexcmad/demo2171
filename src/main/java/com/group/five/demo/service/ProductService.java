package com.group.five.demo.service;

import com.group.five.demo.entitiy.Product;
import com.group.five.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    public ResponseEntity<Product> findById(int id) {
        return ResponseEntity.ok(productRepository.findById(id).orElse(null));
    }

    public ResponseEntity<Product> newProduct(Product product) {
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<Product> updateProduct(Product product, int id) {
        final Product updatedProduct = productRepository.findById(id).orElse(null);
        if (updatedProduct != null) {
            product.setId(id);
            productRepository.save(product);
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Product> deleteProduct(int id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok(productRepository.findById(id).orElse(null));
    }



}
