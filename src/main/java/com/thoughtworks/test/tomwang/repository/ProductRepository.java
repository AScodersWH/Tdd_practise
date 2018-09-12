package com.thoughtworks.test.tomwang.repository;

import com.thoughtworks.test.tomwang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
