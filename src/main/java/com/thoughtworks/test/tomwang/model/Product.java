package com.thoughtworks.test.tomwang.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    @JsonProperty
    private String name;

    @JsonProperty
    private String price;
}
