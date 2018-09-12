package com.thoughtworks.test.tomwang.service;

import com.thoughtworks.test.tomwang.model.Product;
import com.thoughtworks.test.tomwang.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
