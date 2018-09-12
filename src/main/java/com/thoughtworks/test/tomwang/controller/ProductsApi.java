package com.thoughtworks.test.tomwang.controller;


import com.thoughtworks.test.tomwang.model.Product;
import com.thoughtworks.test.tomwang.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsApi {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public void  create(@RequestBody Product product) {
        productRepository.save(product);
    }

    @RequestMapping
    public List<Product> getUsers() {
        return productRepository.findAll();
    }

}
