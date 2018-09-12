package com.thoughtworks.test.tomwang.controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.thoughtworks.test.tomwang.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductsApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void should_create_successfully() throws Exception {
        DocumentContext context = JsonPath.parse("{name:tom,price:1231}");
        mockMvc.perform(post("/products")
                .content(context.jsonString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void should_get_products_successfully() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void should_get_product_by_name_successfully() throws Exception {
        mockMvc.perform(get("/products/tom"))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    public void should_delete_one_by_name_successfully() throws Exception {
        mockMvc.perform(delete("/product/ellen"))
                .andExpect(status().isOk())
                .andReturn();
    }
}