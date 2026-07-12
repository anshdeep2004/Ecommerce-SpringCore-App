package com.ecomspring.service;

import com.ecomspring.model.Product;
import com.ecomspring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void insert(Product product) {
        productRepository.insert(product);
    }

    public Product getProductById(int productId) {
        return productRepository.getProductById(productId).
                orElseThrow(() -> new RuntimeException("Product ID " + productId + " is Invalid.."));
    }

    public void update(int productId, int newStockQuantity) {
        productRepository.update(productId, newStockQuantity);
    }

    public Map<String, Integer> countProductsByVendor() {
        return productRepository.countProductsByVendor();
    }
}
