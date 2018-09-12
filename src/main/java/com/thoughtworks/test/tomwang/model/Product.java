package com.thoughtworks.test.tomwang.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty
    private String name;

    @JsonProperty
    private String price;
}
