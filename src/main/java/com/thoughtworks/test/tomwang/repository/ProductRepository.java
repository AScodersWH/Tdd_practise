package com.thoughtworks.test.tomwang.repository;

import com.thoughtworks.test.tomwang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAll();
    Product findOneByName(String name);
    List<Product> deleteOneByName(String name);
}
