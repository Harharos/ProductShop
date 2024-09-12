package com.alten.shop.service;
import java.util.List;
import java.util.Optional;

import com.alten.shop.model.Product;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product updateProduct(Long id, Product productDetails);

    void deleteProduct(Long id);
}
