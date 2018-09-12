package com.thoughtworks.test.tomwang.controller;


import com.thoughtworks.test.tomwang.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsApi {

    @PostMapping
    public ResponseEntity create() {
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
