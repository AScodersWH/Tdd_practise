package com.thoughtworks.test.tomwang.controller;


import com.thoughtworks.test.tomwang.model.Product;
import com.thoughtworks.test.tomwang.repository.ProductRepository;
import com.thoughtworks.test.tomwang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private ProductService productService;

    @PostMapping
    public void  create(@RequestBody Product product) {
        productRepository.save(product);
    }

    @RequestMapping
    public List<Product> getUsers() {
        return productService.getAllProducts();
    }

    @RequestMapping("/{name}")
    public Product getUserByName(@PathVariable String name) {
        return productService.getOneByName(name);
    }
}
