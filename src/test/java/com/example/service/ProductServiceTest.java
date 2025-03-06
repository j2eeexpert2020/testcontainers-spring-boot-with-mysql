package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Product;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void givenProduct_whenSave_thenProductIsSaved() {

        Product product = new Product(3L, "p101", "Test Product");
        Product savedProduct = productService.save(product);
        assertEquals(product.getName(), savedProduct.getName());
        
        Product foundProduct = productService.findById(3L);
        assertEquals(product.getName(), foundProduct.getName());
    }
}
