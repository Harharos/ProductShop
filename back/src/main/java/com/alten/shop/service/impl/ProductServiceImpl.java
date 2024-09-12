package com.alten.shop.service.impl;

import com.alten.shop.model.Product;
import com.alten.shop.repository.ProductRepository;
import com.alten.shop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(existingProduct -> {
            // Update only the fields that are present in productDetails
            if (productDetails.getCode() != null) existingProduct.setCode(productDetails.getCode());
            if (productDetails.getName() != null) existingProduct.setName(productDetails.getName());
            if (productDetails.getDescription() != null) existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setQuantity(productDetails.getQuantity());
            if (productDetails.getInventoryStatus() != null) existingProduct.setInventoryStatus(productDetails.getInventoryStatus());
            if (productDetails.getCategory() != null) existingProduct.setCategory(productDetails.getCategory());
            if (productDetails.getImage() != null) existingProduct.setImage(productDetails.getImage());
            if (productDetails.getRating() != null) existingProduct.setRating(productDetails.getRating());
            return productRepository.save(existingProduct);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}
