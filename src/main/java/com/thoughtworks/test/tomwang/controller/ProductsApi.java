package com.thoughtworks.test.tomwang.controller;


import com.thoughtworks.test.tomwang.model.Product;
import com.thoughtworks.test.tomwang.repository.UserRepository;
import com.thoughtworks.test.tomwang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsApi {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("users/{userId}/products")
    public List<Product> create(@PathVariable Integer userId, @RequestBody Product product) {
       return productService.store(userId,product);
    }

    @RequestMapping("users/{userId}/products")
    public List<Product> getUsers(@PathVariable Integer userId) {
        return productService.getAllProducts(userId);
    }

    @RequestMapping("users/{userId}/products/{name}")
    public Product getUserByName(@PathVariable Integer userId, @PathVariable String name) {
        return productService.getOneByName(userId, name);
    }

    @DeleteMapping("users/{userId}/products/{name}")
    public List<Product> deleteProductByName(@PathVariable Integer userId, @PathVariable String name) {
       return productService.deleteProductByName(userId, name);
    }


}
