package com.kism3t.product.service;

import com.kism3t.product.model.Product;
import com.kism3t.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<Product> getProducts() {

        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product createProduct(Product product) {

        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }
}
