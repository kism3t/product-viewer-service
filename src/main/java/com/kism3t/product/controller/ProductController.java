package com.kism3t.product.controller;

import com.kism3t.product.model.Product;
import com.kism3t.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = { "application/json", "application/xml" })
    public ResponseEntity<Collection<Product>> getProducts() {
        Collection<Product> usersList = productService.getProducts();
        HttpStatus httpStatus = HttpStatus.OK;

        if (usersList.isEmpty()) {
            httpStatus = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(usersList, httpStatus);
    }

    @GetMapping(path = "/{id}", produces = { "application/json" })
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {

        Optional<Product> product = productService.getProduct(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        Product createProduct = productService.createProduct(product);

        return new ResponseEntity<Product>(createProduct, HttpStatus.OK);
    }
}
