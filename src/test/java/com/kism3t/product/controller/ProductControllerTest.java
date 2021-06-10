package com.kism3t.product.controller;

import com.kism3t.product.model.Product;
import com.kism3t.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @Test
    void loadAllProductsTest() throws Exception {
        Collection<Product> products = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("ProductName1");
        products.add(p1);
        when(service.getProducts()).thenReturn(products);
        this.mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath(".name", hasItem("ProductName1")))
                .andExpect(jsonPath(".id", hasItem(1)));
    }

    @Test
    void loadEmptyProducts() throws Exception {

        when(service.getProducts()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().isNoContent());
    }

    @Test
    void noProductAvailable() throws Exception {

        Optional<Product> optionalProduct = Optional.empty();
        when(service.getProduct(eq(123L))).thenReturn(optionalProduct);

        this.mockMvc.perform(get("/api/v1/products/123"))
                .andExpect(status().isNotFound());
    }

    @Test
    void productAvailable() throws Exception {

        Optional<Product> optionalProduct = Optional.of(new Product());
        when(service.getProduct(eq(123L))).thenReturn(optionalProduct);

        this.mockMvc.perform(get("/api/v1/products/123"))
                .andExpect(status().isOk());
    }
}
